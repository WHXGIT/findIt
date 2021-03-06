package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.common.Pagination;
import com.cogitationsoft.findit.pojo.*;
import com.cogitationsoft.findit.service.LetterService;
import com.cogitationsoft.findit.service.UserLetterService;
import com.cogitationsoft.findit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author: Andy
 * @date: 5/18/2018 2:06 PM
 * @description:
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/letter")
public class LetterController {

	@Autowired
	private LetterService letterService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserLetterService userLetterService;

	@Transactional(rollbackFor = RuntimeException.class)
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute LetterDO letterDO, HttpServletResponse response, HttpSession session) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		letterDO.setCreateTime(LocalDateTime.now());
		UserDO userDO = userService.readById(((UserVO) session.getAttribute("userVO")).getUserId());
		letterDO.setCreateName(userDO.getNickname());
		LetterDO letter = letterService.insert(letterDO);

		UserLetterDO userLetterDO = new UserLetterDO();
		userLetterDO.setLetterId(letter.getLetterId());
		userLetterDO.setUserId(userDO.getUserId());
		userLetterDO.setPublishTime(
				Integer.valueOf
						(String.valueOf(Duration.between(letter.getCreateTime(), LocalDateTime.now()).toDays())));
		try {
			userLetterService.insert(userLetterDO);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView listLetter(@RequestBody Pagination<LetterDO> page,
	                                   HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Pagination<LetterDO> pagination = letterService.listLetterDO(page);
		mav.addObject(pagination);
		mav.setViewName("letter/letter");
		return mav;
	}

	@RequestMapping(value = "/getSearch", method = RequestMethod.POST)
	public ModelAndView listGetLetter(@RequestBody Pagination<LetterDO> page,
	                                   HttpServletResponse response,
	                                  HttpSession session){
		ModelAndView mav = new ModelAndView();
		String userId = null;
		if(session != null){
			userId = ((UserVO)(session.getAttribute("userVO"))).getUserId();
		}

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Pagination<LetterDO> pagination = letterService.listSelfLetterDO(page, userId, "get");
		mav.addObject(pagination);
		mav.setViewName("letter/letter");
		return mav;
	}


	@RequestMapping(value = "/sendSearch", method = RequestMethod.POST)
	public ModelAndView listSentLetter(@RequestBody Pagination<LetterDO> page,
	                                  HttpServletResponse response,
	                                  HttpSession session){
		ModelAndView mav = new ModelAndView();

		String userId = null;
		if(session != null){
			userId = ((UserVO)(session.getAttribute("userVO"))).getUserId();
		}

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Pagination<LetterDO> pagination = letterService.listSelfLetterDO(page, userId, "sent");
		mav.addObject(pagination);
		mav.setViewName("letter/letter");
		return mav;
	}
}
