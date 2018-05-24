package com.cogitationsoft.findit.service.impl;

import com.cogitationsoft.findit.common.Pagination;
import com.cogitationsoft.findit.mapper.CredentialMapper;
import com.cogitationsoft.findit.mapper.UserCredentialMapper;
import com.cogitationsoft.findit.pojo.CredentialDO;
import com.cogitationsoft.findit.pojo.UserCredentialDO;
import com.cogitationsoft.findit.service.CredentialService;
import com.github.pagehelper.PageHelper;
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
 * @date: 5/13/2018 3:31 PM
 * @description:
 * @version: 1.0
 */
@Service
public class CredentialServiceImpl implements CredentialService{

	private static final Logger logger = LogManager.getLogger(CredentialServiceImpl.class);
	@Autowired(required = false)
	private CredentialMapper credentialMapper;

	@Autowired(required = false)
	private UserCredentialMapper userCredentialMapper;
	/**
	 * Method Description:
	 * 〈同时插入证件信息和用户与证件的关联信息〉
	 *
	 * @param:      null
	 * @return:
	 * @author:     Andy
	 * @date:       5/13/2018 3:35 PM
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void insert(CredentialDO credentialDO) {
		try {
			credentialMapper.insert(credentialDO);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new RuntimeException();
		}
	}
	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void insertRelation(UserCredentialDO userCredentialDO){
		try {
			userCredentialMapper.insert(userCredentialDO);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public CredentialDO getCredentialDO(CredentialDO credentialDO) {
		try {
			credentialDO = credentialMapper.getCredentialDO(credentialDO);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return credentialDO;
	}

	@Override
	public Pagination<CredentialDO> listCredentialDO(Pagination<CredentialDO> page) {

		PageHelper.startPage(page.getCurrentPage(), page.getPageCount());
		List<CredentialDO> list = credentialMapper.listCredentialDO((CredentialDO) page.getData().get(0));
		page.setData(list);
		PageInfo pagelist = new PageInfo(list);
		page.setCurrentPage(pagelist.getPageNum());
		page.setTotalCount(Integer.valueOf(String.valueOf(pagelist.getTotal())));
		page.setTotalPage(pagelist.getPages());
		return page;
	}

	@Override
	public void insertByImg(CredentialDO credentialDO) {
		try {
			credentialMapper.insertByImg(credentialDO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
