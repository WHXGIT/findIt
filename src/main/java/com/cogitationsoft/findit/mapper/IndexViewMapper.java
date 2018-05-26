package com.cogitationsoft.findit.mapper;

import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

/**
 * @author: Andy
 * @date: 5/25/2018 1:45 PM
 * @description:
 * @version: 1.0
 */
public interface IndexViewMapper {

	/** @description： 获取已发布的所有证件数*/
	int getAllPublishCred() throws SQLException;

	/** @description： 获取已经寻找的证件数*/
	int getAllFindCred() throws SQLException;

	/** @description： 获取发布的感谢信数量*/
	int getAllLetter() throws SQLException;

	/** @description： 用户量*/
	int getAllUser() throws SQLException;

	/** @description： 获取所有为被领回的数量*/
	int getAllLeftCred() throws SQLException;

	/** @description： 获取所有涉及感谢信的人数量*/
	int getAllUsedletter() throws SQLException;

	/** @description： 获取最近的证件记录*/
	Set<Map> getResentCredRecord() throws SQLException;

	/** @description： 获取最近的感谢信记录*/
	Set<Map> getResentLetterRecord() throws SQLException;
}
