package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.common.Pagination;
import com.cogitationsoft.findit.pojo.CredentialDO;
import com.cogitationsoft.findit.pojo.UserCredentialDO;
import com.cogitationsoft.findit.pojo.UserDO;
import com.cogitationsoft.findit.pojo.UserVO;
import com.cogitationsoft.findit.service.CredentialService;
import com.cogitationsoft.findit.util.DoCodeUtil;
import com.cogitationsoft.findit.util.OCRUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Method Description:
	 * 〈Insert a credential〉
	 *
	 * @param:      null
	 * @return:
	 * @author:     Andy
	 * @date:       5/17/2018 2:36 PM
	 */
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


	/**
	 * Method Description:
	 * 〈分页展示列表〉
	 *
	 * @param:      null
	 * @return:
	 * @author:     Andy
	 * @date:       5/17/2018 2:37 PM
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView listCredential(@RequestBody Pagination<CredentialDO> page,
	                                   HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Pagination<CredentialDO> pagination = credentialService.listCredentialDO(page);
		mav.addObject(pagination);
		List list = new ArrayList();
		mav.setViewName("/search");
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
			String path = session.getServletContext().getRealPath("public-resources\\CredImg");
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
					JSONObject result = OCRUtil.getYoutuOCR().IdCardOcr(rootPathDir.getAbsolutePath()
							+ File.separator + filename, 0);
					System.out.println(result);
					/*UserDO userDO = new UserDO();
					userDO.setUserId(((UserVO) session.getAttribute("userVO")).getUserId());
					userDO.setHeadImg("\\public-resources\\CredImg"+  File.separator + filename);
					credentialService.insertByImg(userDO);
					UserVO user = (UserVO) session.getAttribute("userVO");
					user.setHeadImg(rootPathDir.getAbsolutePath() + File.separator + filename);
					session.setAttribute("userVO", user);
					System.out.println("Write file: " + serverFile);*/
				} catch (Exception e) {
					System.out.println("Error Write file: " + filename);
				}
			}
		}
		return "redirect:/";
	}

/*	@RequestMapping(value = "/search/detail/{id}")
	public ModelAndView getCredential(@PathVariable("id") String id, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		CredentialDO credentialDO = new CredentialDO();
		credentialDO.setCredId(id);
		CredentialDO credential = credentialService.getCredentialDO(credentialDO);
		credential.setCredNo(DoCodeUtil.doCode(credential.getCredNo()));
		mav.setViewName("/credential/search_detail");
		mav.addObject("credentialDO",credentialDO);
		return mav;
	}*/
}
