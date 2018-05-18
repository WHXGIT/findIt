package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.pojo.LetterDO;
import com.cogitationsoft.findit.pojo.UserDO;
import com.cogitationsoft.findit.pojo.UserLetterDO;
import com.cogitationsoft.findit.pojo.UserVO;
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
		return "letter/letter";
	}

}
