package com.cogitationsoft.findit.service.impl;

import com.cogitationsoft.findit.common.exception.UserDTOException;
import com.cogitationsoft.findit.mapper.UserMapper;
import com.cogitationsoft.findit.pojo.UserDO;
import com.cogitationsoft.findit.pojo.UserDTO;
import com.cogitationsoft.findit.pojo.UserVO;
import com.cogitationsoft.findit.service.UserService;
import com.cogitationsoft.findit.util.GenerateBASE64MD5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public UserDO create(UserDO userDO) {
		if(userDO != null){
			try {
				String password = GenerateBASE64MD5Util.toDigest(userDO.getPassword());
				userDO.setPassword(password);
				mapper.create(userDO);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("用户注册失败！" + e.getMessage());
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		}
		return userDO;
	}

	@Transactional
	@Override
	public UserDO readById(String id) {

		return null;
	}

	@Transactional
	@Override
	public UserDO update(UserDO userDO) {
		UserDO user = null;
		try {
			mapper.update(userDO);
			user = mapper.readById(userDO.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return user;
	}

	@Transactional
	@Override
	public void delete(String id) {

	}

	@Override
	public UserVO getUserVO(UserDO userDO) {
		if(userDO != null){
			try {
				UserDO user = mapper.getUserDO(userDO);
				UserDTO dto = new UserDTO();
				UserVO vo = null;
				try {
					vo = dto.toUserVO(user);
				} catch (UserDTOException e) {
					e.printStackTrace();
					logger.error("toUserVO 发生异常！");
				}
				return vo;
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public void updateHeadPath(String headImg) {
		try {
			mapper.updateHeadPath(headImg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
