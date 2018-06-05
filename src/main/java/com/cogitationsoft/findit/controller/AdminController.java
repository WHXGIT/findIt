package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.common.Pagination;
import com.cogitationsoft.findit.pojo.CredentialDO;
import com.cogitationsoft.findit.pojo.UserDO;
import com.cogitationsoft.findit.service.CredentialService;
import com.cogitationsoft.findit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: Andy
 * @date: 6/3/2018 10:33 AM
 * @description: 管理员控制器
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private CredentialService credentialService;

	@RequestMapping(value = "/listUser", method = RequestMethod.POST)
	@ResponseBody
	public Model listUser(@RequestBody Pagination<UserDO> pagination, Model model){
		Pagination<UserDO> page = userService.listUser(pagination);
		model.addAttribute("page", page);
		return model;
	}

	@RequestMapping(value = "/forbidUser/{userId}", method = RequestMethod.GET)
	public String forbidUser(@PathVariable("userId") String userId, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(userService.forbidUser(userId)){
			return "admin/index";
		}else {
			return "admin/index";
		}
	}

	@RequestMapping(value = "/listCred", method = RequestMethod.POST)
	@ResponseBody
	public Model review(@RequestBody Pagination<CredentialDO> pagination, Model model){
		Pagination<CredentialDO> page = credentialService.listReviewCredentialDO(pagination);
		model.addAttribute("page", page);
		return model;
	}

	@RequestMapping(value = "/pass/{credId}", method = RequestMethod.GET)
	public String pass(@PathVariable("credId") String credId, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		credentialService.check("1", credId);
		return "admin/index";
	}

	@RequestMapping(value = "/forbid/{credId}", method = RequestMethod.GET)
	public String forbid(@PathVariable("credId") String credId, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		credentialService.check("2", credId);
		return "admin/index";
	}

}
