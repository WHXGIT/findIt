package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.pojo.UserVO;
import com.cogitationsoft.findit.service.impl.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: Andy
 * @date: 5/3/2018 3:55 PM
 * @description: 主控制器
 * @version: 1.0
 */
@Controller
public class IndexController {

	@Autowired
	private DemoServiceImpl service;

	/**
	 * Method Description:
	 * 〈负责跳转到首页〉
	 *
	 * @param: null
	 * @return: String： index explain: view name
	 * @author: Andy
	 * @date: 5/3/2018 3:57 PM
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		return "index";
	}

	/**
	 * Method Description:
	 * 〈跳转到注册页面〉
	 *
	 * @param: null
	 * @return:
	 * @author: Andy
	 * @date: 5/10/2018 10:36 AM
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		return "user/register";
	}

	/**
	 * Method Description:
	 * 〈跳转到登录页面〉
	 *
	 * @param: null
	 * @return:
	 * @author: Andy
	 * @date: 5/10/2018 11:04 AM
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		return "user/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		session.removeAttribute("userVO");
		return "index";
	}

	@RequestMapping(value = "/lost", method = RequestMethod.GET)
	public String lost(HttpServletResponse response, HttpSession session) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if ((session.getAttribute("userVO") == null)) {
			return "user/login";
		}
		return "credential/lost";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(HttpServletResponse response, HttpSession session) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if ((session.getAttribute("userVO") == null)) {
			return "user/login";
		}
		return "credential/find";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		return "credential/search";
	}

	@RequestMapping(value = "/letter", method = RequestMethod.GET)
	public String letter(HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		return "letter/letter";
	}

	@RequestMapping(value = "/write_letter", method = RequestMethod.GET)
	public String writeLetter(HttpServletResponse response, HttpSession session) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if (session.getAttribute("userVO") == null) {
			return "user/login";
		}
		return "letter/letter_write";
	}


}
