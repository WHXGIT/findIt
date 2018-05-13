package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.common.exception.LoginException;
import com.cogitationsoft.findit.common.exception.UserDTOException;
import com.cogitationsoft.findit.pojo.UserDO;
import com.cogitationsoft.findit.pojo.UserDTO;
import com.cogitationsoft.findit.pojo.UserVO;
import com.cogitationsoft.findit.service.UserService;
import com.cogitationsoft.findit.util.GenerateBASE64MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Andy
 * @date: 5/8/2018 4:45 PM
 * @description: 用户前端控制器
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Method Description:
	 * 〈注册〉
	 *
	 * @param: User data object
	 * @return: 注册成功页面
	 * @author: Andy
	 * @date: 5/10/2018 3:15 PM
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String register(@ModelAttribute("userDO") UserDO userDO, HttpServletResponse response,
	                       HttpSession session) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		System.out.println(userDO.toString());
		UserDO user = userService.create(userDO);
		UserVO userSearch = userService.getUserVO(user);
		if (userSearch.getUserId() != null && !"".equals(userSearch.getUserId())) {
			session.setAttribute("userVO", userSearch);
			return "user/reg_success";
		}
		return "error/error";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("userDO") UserDO userDO, HttpServletResponse response,
	                          HttpSession session) throws LoginException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		try {
			if (userDO.getUsername() == null || "".equals(userDO.getUsername())) {
				throw new LoginException("警告：该用户有非法操作的嫌疑！");
			}

			if (userDO.getPassword() == null || "".equals(userDO.getPassword())) {
				throw new LoginException("警告：该用户有非法操作的嫌疑！");
			}
			userDO.setPassword(GenerateBASE64MD5Util.toDigest(userDO.getPassword()));
			UserVO user = userService.getUserVO(userDO);
			mav.addObject("userVO", user);
			if (user != null) {
				session.setAttribute("userVO", user);
				mav.setViewName("/index");
			} else {
				mav.setViewName("error/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}


	/**
	 * Method Description:
	 * 〈查看个人信息/我的中心〉
	 *
	 * @param: null
	 * @return:
	 * @author: Andy
	 * @date: 5/11/2018 9:35 AM
	 */
	@RequestMapping(value = "/readMe", method = RequestMethod.GET)
	public ModelAndView readme(HttpServletResponse response, HttpSession session) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userVO", userVO);
		if (userVO != null) {
			mav.setViewName("user/myCenter");
		} else {
			mav.setViewName("user/login");
		}
		return mav;
	}

	/**
	 * Method Description:
	 * 〈update personal information〉
	 *
	 * @param:      UserVO,Session
	 * @return:
	 * @author:     Andy
	 * @date:       5/11/2018 12:27 PM
	 */
	@RequestMapping(value = "/updatePerInfo", method = RequestMethod.POST)
	public ModelAndView updateMyInfo(@RequestBody UserVO userVO, HttpServletResponse response,
	                                 HttpSession session){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		UserDTO dto = new UserDTO();
		UserDO userDO = null;
		try {
			userDO = dto.toUserDO(userVO);
		} catch (UserDTOException e) {
			e.printStackTrace();
		}
		userDO.setUserId(((UserDO)session.getAttribute("userVO")).getUserId());
		UserDO user = userService.update(userDO);
		session.setAttribute("userVO", user);
		ModelAndView mav = new ModelAndView();
		mav.addObject("userVO", userVO);
		if (userVO != null) {
			mav.setViewName("user/myCenter");
		} else {
			mav.setViewName("error/error");
		}
		return mav;
	}

	/**
	 * Method Description:
	 * 〈上传头像〉
	 *
	 * @param:      image
	 * @return:
	 * @author:     Andy
	 * @date:       5/11/2018 2:25 PM
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestParam(value = "img") MultipartFile file,
	                                HttpServletResponse response, HttpServletRequest request,
	                                HttpSession session) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(!file.isEmpty()){
			String contentType=file.getContentType();
			String filename = file.getOriginalFilename();
			String path = session.getServletContext().getRealPath("HeadImg");
			File rootPathDir = new File(path);
			if (!rootPathDir.exists()) {
				rootPathDir.mkdirs();
			}

			if (filename != null && filename.length() > 0) {
				try {
					byte[] bytes = file.getBytes();

					// Create the file on server
					File serverFile = new File(rootPathDir.getAbsolutePath()
							+ File.separator + filename);

					// Stream to write data to file in server.
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					userService.updateHeadPath(rootPathDir.getAbsolutePath()
							+ File.separator + filename);
					UserVO user = (UserVO) session.getAttribute("userVO");
					user.setHeadImg(rootPathDir.getAbsolutePath() + File.separator + filename);
					session.setAttribute("userVO", user);
					System.out.println("Write file: " + serverFile);
				} catch (Exception e) {
					System.out.println("Error Write file: " + filename);
				}
			}
		}

		return "redirect:/user/readMe";
	}
}
