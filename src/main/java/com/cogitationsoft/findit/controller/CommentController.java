package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.pojo.CommentDO;
import com.cogitationsoft.findit.pojo.CredDetailVO;
import com.cogitationsoft.findit.pojo.CredentialDO;
import com.cogitationsoft.findit.pojo.UserVO;
import com.cogitationsoft.findit.service.CommentService;
import com.cogitationsoft.findit.service.CredentialService;
import com.cogitationsoft.findit.util.DoCodeUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Andy
 * @date: 5/22/2018 8:33 PM
 * @description: 评论控制器
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private CredentialService credentialService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute CommentDO commentDO, HttpSession session, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		UserVO vo = ((UserVO)session.getAttribute("userVO"));
		if(vo == null){
			mav.setViewName("user/login");
			return mav;
		}

		commentDO.setCommentUserId(vo.getUserId());
		commentDO.setCommentName(vo.getNickname());
		LocalDateTime ldt = LocalDateTime.now();
		commentDO.setCommentTime(ldt);

		commentService.insert(commentDO);
		mav.setViewName("credential/search");
		return mav;
	}


	@RequestMapping(value = "/credDetail/{id}", method = RequestMethod.GET)
	public ModelAndView credDetail(@PathVariable("id")String id, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		ModelAndView mav = new ModelAndView();
		CredentialDO credentialDO = new CredentialDO();
		credentialDO.setCredId(id);
		credentialDO = credentialService.getCredentialDO(credentialDO);
		String credNo = DoCodeUtil.doCode(credentialDO.getCredNo());
		credentialDO.setCredNo(credNo);
		CommentDO commentDO = new CommentDO();
		commentDO.setToUserId(id);
		List<CommentDO> commentDOList = commentService.listComment(commentDO);
		mav.addObject("credentialDO", credentialDO);
		mav.addObject("commentDOList", commentDOList);
		mav.setViewName("comment/comment");
		return mav;
	}
}
