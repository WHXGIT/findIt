package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.pojo.IndexVO;
import com.cogitationsoft.findit.service.IndexViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Andy
 * @date: 5/25/2018 1:41 PM
 * @description: 首页需要显示的内容
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/index")
public class IndexViewController {

	@Autowired
	private IndexViewService indexViewService;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public Model init(Model model) {
		IndexVO vo = indexViewService.getData();

		model.addAttribute("vo", vo);
		return model;
	}

}
