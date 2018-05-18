package com.cogitationsoft.findit.service.impl;

import com.cogitationsoft.findit.mapper.UserLetterMapper;
import com.cogitationsoft.findit.pojo.UserLetterDO;
import com.cogitationsoft.findit.service.UserLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * @author: Andy
 * @date: 5/18/2018 3:41 PM
 * @description:
 * @version: 1.0
 */
@Service
public class UserLetterServiceImpl implements UserLetterService {

	@Autowired(required = false)
	private UserLetterMapper userLetterMapper;

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void insert(UserLetterDO userLetterDO) {
		try {
			userLetterMapper.insert(userLetterDO);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
