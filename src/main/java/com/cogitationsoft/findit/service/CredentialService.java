package com.cogitationsoft.findit.service;

import com.cogitationsoft.findit.common.Pagination;
import com.cogitationsoft.findit.pojo.CredentialDO;
import com.cogitationsoft.findit.pojo.UserCredentialDO;

import java.util.List;

/**
 * @author: Andy
 * @date: 5/13/2018 3:24 PM
 * @description: 证件service
 * @version: 1.0
 */
public interface CredentialService {

	/** @description： 插入证件信息及证件与用户的信息*/
	void insert(CredentialDO credentialDO);

	/** @description： 用户关系对象*/
	void insertRelation(UserCredentialDO userCredentialDO);

	/** @description： 获取证件的信息*/
	CredentialDO getCredentialDO(CredentialDO credentialDO);

	/** @description： 分页查询、条件查询 证件列表*/
	Pagination<CredentialDO> listCredentialDO(Pagination<CredentialDO> page);
}
