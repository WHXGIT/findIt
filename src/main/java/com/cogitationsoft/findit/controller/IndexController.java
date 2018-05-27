package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.pojo.UserVO;
import com.cogitationsoft.findit.service.impl.DemoServiceImpl;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

	@Autowired
	private DefaultKaptcha captchaProducer;
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

	@RequestMapping(value = "/searchSelf", method = RequestMethod.GET)
	public String searchSelf(HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		return "credential/search_self";
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
	 * 〈生成验证码〉
	 *
	 * @param:      null
	 * @return:
	 * @author:     Andy
	 * @date:       5/23/2018 5:01 PM
	 */
	@RequestMapping(value = "/captcha-image")
	public ModelAndView getKaptchaImage(HttpServletRequest request,
	                                    HttpServletResponse response,
	                                    HttpSession session) throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");

		String capText = captchaProducer.createText();
		session.setAttribute("code", capText);
		try {
			String uuid= UuidUtil.getTimeBasedUuid().toString();
			Cookie cookie = new Cookie("captchaCode",uuid);
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}

}
