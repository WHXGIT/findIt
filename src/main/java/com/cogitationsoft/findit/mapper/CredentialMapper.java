package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.CredentialDO;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

	void insertByImg(CredentialDO credentialDO) throws SQLException;

	/** @description： 获取我相关的证件信息*/
	List<CredentialDO> listSelfCredentialDO(Map<String, Object> map) throws SQLException;

	/** @description： 我评论过的证件信息*/
	List<CredentialDO> listSelfCommentCredentialDO(String userId) throws SQLException;

	List<CredentialDO> listReviewCredentialDO(CredentialDO credentialDO) throws SQLException;

	void check(Map<String, String> map) throws SQLException;
}
