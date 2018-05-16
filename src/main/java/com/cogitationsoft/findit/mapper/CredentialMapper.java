package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.CredentialDO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Andy
 * @date: 5/13/2018 10:04 AM
 * @description: mapper
 * @version: 1.0
 */
public interface CredentialMapper {
	/** @description： 插入一条数据*/
	void insert(CredentialDO credentialDO) throws SQLException;

	/** @description： 修改数据*/
	void update(CredentialDO credentialDO) throws SQLException;

	/** @description： 证书信息*/
	void delete(String credId) throws SQLException;

	/** @description： 获取一条证书信息*/
	CredentialDO getCredentialDO(CredentialDO credentialDO) throws SQLException;

	/** @description： 分页查询、条件查询 证件列表*/
	List<CredentialDO> listCredentialDO(CredentialDO credentialDO);
}
