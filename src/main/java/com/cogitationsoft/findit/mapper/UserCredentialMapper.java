package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.UserCredentialDO;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * @author: Andy
 * @date: 5/13/2018 3:36 PM
 * @description: 用户与证件关联信息表
 * @version: 1.0
 */
public interface UserCredentialMapper {
	/** @description： 插入信息*/
	void insert(UserCredentialDO userCredentialDO) throws SQLException;
}
