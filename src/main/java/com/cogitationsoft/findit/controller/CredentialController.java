package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.common.Pagination;
import com.cogitationsoft.findit.pojo.CredentialDO;
import com.cogitationsoft.findit.pojo.UserCredentialDO;
import com.cogitationsoft.findit.pojo.UserVO;
import com.cogitationsoft.findit.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: Andy
 * @date: 5/13/2018 3:58 PM
 * @description:
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/credential")
public class CredentialController {
	@Autowired
	private CredentialService credentialService;

	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value = "/lost", method = RequestMethod.POST)
	public String insert(@ModelAttribute CredentialDO credentialDO, HttpServletResponse response,
	                   HttpSession session, HttpServletRequest request) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String lostTime = request.getParameter("lostTimeA");
		LocalDateTime time = LocalDateTime.parse(lostTime, df);
		credentialDO.setLostTime(time);
		credentialDO.setPickTime(time);
		credentialService.insert(credentialDO);
		String id = credentialDO.getCredId();
		UserCredentialDO userCredentialDO = new UserCredentialDO();
		userCredentialDO.setUserId(((UserVO) (session.getAttribute("userVO"))).getUserId());
		userCredentialDO.setCredId(id);
		credentialService.insertRelation(userCredentialDO);
		return "redirect:/";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView listCredential(@RequestBody Pagination<CredentialDO> page,
	                                   HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Pagination<CredentialDO> pagination = credentialService.listCredentialDO(page);
		mav.addObject(pagination);
		mav.setViewName("/search");
		return mav;
	}

}
