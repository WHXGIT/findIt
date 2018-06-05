package com.cogitationsoft.findit.service.impl;

import com.cogitationsoft.findit.common.Pagination;
import com.cogitationsoft.findit.common.exception.UserDTOException;
import com.cogitationsoft.findit.mapper.UserMapper;
import com.cogitationsoft.findit.pojo.UserCenterVO;
import com.cogitationsoft.findit.pojo.UserDO;
import com.cogitationsoft.findit.pojo.UserDTO;
import com.cogitationsoft.findit.pojo.UserVO;
import com.cogitationsoft.findit.service.UserService;
import com.cogitationsoft.findit.util.GenerateBASE64MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Andy
 * @date: 5/8/2018 9:38 AM
 * @description: 用户接口实现
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	private final static Logger logger = LogManager.getLogger(UserServiceImpl.class);
	@Autowired(required = false)
	private UserMapper mapper;

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public UserDO create(UserDO userDO) {
		if (userDO != null) {
			try {
				String password = GenerateBASE64MD5Util.toDigest(userDO.getPassword());
				userDO.setPassword(password);
				userDO.setRegisterTime(LocalDateTime.now());
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
		UserDO userDO = null;
		try {
			userDO = mapper.readById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userDO;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void update(UserDO userDO) {
		UserDO user = null;
		try {
			mapper.update(userDO);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
			throw new RuntimeException();
		}
	}

	@Transactional
	@Override
	public void delete(String id) {

	}

	@Override
	public UserVO getUserVO(UserDO userDO) {
		if (userDO != null) {
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
	public void updateHeadPath(UserDO userDO) {
		try {
			mapper.updateHeadPath(userDO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserCenterVO getUserCenterVO(String id) {
		UserCenterVO vo = new UserCenterVO();
		try {
			LocalDateTime regTime = mapper.getDuringDays(id);
			long day = Duration.between(regTime, LocalDateTime.now()).toDays();
			int days = Integer.valueOf(String.valueOf(day));
			vo.setDuringDays(days);
			if (mapper.getAllCommentCred(id) == null) {
				vo.setAllCommentCred(0);
			} else {
				vo.setAllCommentCred(mapper.getAllCommentCred(id));
			}
			if (mapper.getAllFinishCred(id) == null) {
				vo.setAllFinishCred(0);
			} else {
				vo.setAllFinishCred(mapper.getAllFinishCred(id));
			}
			if (mapper.getAllGetLetter(id) == null) {
				vo.setAllGetLetter(0);
			} else {
				vo.setAllGetLetter(mapper.getAllGetLetter(id));
			}
			if (mapper.getAllMocriReward(id) == null) {
				vo.setAllMocriReward(0);
			} else {
				vo.setAllMocriReward(mapper.getAllMocriReward(id));
			}
			if (mapper.getAllPublishCred(id) == null) {
				vo.setAllPublishCred(0);
			} else {
				vo.setAllPublishCred(mapper.getAllPublishCred(id));
			}
			if (mapper.getAllSentLetter(id) == null) {
				vo.setAllSentLetter(0);
			} else {
				vo.setAllSentLetter(mapper.getAllSentLetter(id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Transactional
	@Override
	public Pagination<UserDO> listUser(Pagination<UserDO> pagination) {
		try {
			PageHelper.startPage(pagination.getCurrentPage(), pagination.getPageCount());
			List<UserDO> list = null;
			if((UserDO) pagination.getData() != null) {
				UserDO userDO = (UserDO) pagination.getData().get(0);
				list = mapper.listUser((UserDO) pagination.getData().get(0));
			}else {
				list = mapper.listUser(null);
			}
			PageInfo pagelist = new PageInfo(list);
			pagination.setData(list);
			pagination.setCurrentPage(pagelist.getPageNum());
			pagination.setTotalCount(Integer.valueOf(String.valueOf(pagelist.getTotal())));
			pagination.setTotalPage(pagelist.getPages());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pagination;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public boolean forbidUser(String userId) {
		try {
			mapper.forbidUser(userId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return true;
	}

}
