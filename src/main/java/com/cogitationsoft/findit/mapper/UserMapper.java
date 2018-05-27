package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author: Andy
 * @date: 5/8/2018 9:39 AM
 * @description: User data operator interface
 * @version: 1.0
 */
@Mapper
public interface UserMapper {
	/** @description： Be used to insert a user*/
	void create(UserDO userDO) throws Exception;

	/** @description： Search a user by id*/
	UserDO readById(String id) throws SQLException;

	/** @description： Update a user*/
	void update(UserDO userDO) throws SQLException;

	/** @description： Delete a user by id*/
	void delete(String id) throws SQLException;

	/** @description： 通过用户名查询用户*/
	UserDO getUserDOByUsername(String username) throws SQLException;

	/** @description： 通过条件查找*/
	UserDO getUserDO(UserDO userDO) throws SQLException;

	/** @description： 修改头像*/
	void updateHeadPath(UserDO userDO) throws SQLException;

	LocalDateTime getDuringDays(String id) throws SQLException;

	Integer getAllPublishCred(String id) throws SQLException;

	Integer getAllFinishCred(String id) throws SQLException;

	Integer getAllGetLetter(String id) throws SQLException;

	Integer getAllSentLetter(String id) throws SQLException;

	Integer getAllCommentCred(String id) throws SQLException;

	Integer getAllMocriReward(String id) throws SQLException;
}
