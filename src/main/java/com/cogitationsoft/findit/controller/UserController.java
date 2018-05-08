package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.pojo.UserVO;
import com.cogitationsoft.findit.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Andy
 * @date: 5/8/2018 4:45 PM
 * @description: 用户前端控制器
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@RequestMapping(value = "reg", method = RequestMethod.POST)
	public String register(@ModelAttribute("userVO") UserVO userVO){

		return "register";
	}
}
