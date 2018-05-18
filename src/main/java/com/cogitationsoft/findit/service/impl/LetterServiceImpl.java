package com.cogitationsoft.findit.service.impl;

import com.cogitationsoft.findit.mapper.LetterMapper;
import com.cogitationsoft.findit.pojo.LetterDO;
import com.cogitationsoft.findit.pojo.UserLetterDO;
import com.cogitationsoft.findit.service.LetterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

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
}
