package com.cogitationsoft.findit.service.impl;

import com.cogitationsoft.findit.common.Pagination;
import com.cogitationsoft.findit.mapper.LetterMapper;
import com.cogitationsoft.findit.pojo.LetterDO;
import com.cogitationsoft.findit.pojo.UserLetterDO;
import com.cogitationsoft.findit.service.LetterService;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Andy
 * @date: 5/18/2018 1:43 PM
 * @description:
 * @version: 1.0
 */
@Service
public class LetterServiceImpl implements LetterService{
	@Autowired(required = false)
	private LetterMapper letterMapper;

	private static final Logger logger = LogManager.getLogger(LetterServiceImpl.class);

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public LetterDO insert(LetterDO letterDO) {
		try {
			letterMapper.insert(letterDO);
			return letterDO;
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Pagination<LetterDO> listLetterDO(Pagination<LetterDO> page) {
		List<LetterDO> list = letterMapper.listLetterDO((LetterDO)page.getData().get(0));
		page.setData(list);
		PageInfo pagelist = new PageInfo(list);
		page.setCurrentPage(pagelist.getPageNum());
		page.setTotalCount(Integer.valueOf(String.valueOf(pagelist.getTotal())));
		page.setTotalPage(pagelist.getPages());
		return page;
	}
}
