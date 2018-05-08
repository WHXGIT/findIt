package com.cogitationsoft.findit.service.impl;

import com.cogitationsoft.findit.mapper.UserMapper;
import com.cogitationsoft.findit.pojo.UserDO;
import com.cogitationsoft.findit.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * @author: Andy
 * @date: 5/8/2018 9:38 AM
 * @description: 用户接口实现
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService{
	private final static Logger logger = LogManager.getLogger(UserServiceImpl.class);
	@Autowired(required = false)
	private UserMapper mapper;
	@Transactional
	@Override
	public UserDO create(UserDO userDO) {
		if(userDO != null){
			try {
				mapper.create(userDO);
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("用户注册失败！" + e.getMessage());
			}
		}
		return userDO;
	}

	@Override
	public UserDO readById(String id) {
		return null;
	}

	@Override
	public UserDO update(UserDO userDO) {
		return null;
	}

	@Override
	public void delete(String id) {

	}

	@Override
	public UserDO login() {
		return null;
	}
}
