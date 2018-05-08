package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

/**
 * @author: Andy
 * @date: 5/8/2018 9:39 AM
 * @description: User data operator interface
 * @version: 1.0
 */
@Mapper
public interface UserMapper {
	/** @description： Be used to insert a user*/
	void create(UserDO userDO) throws SQLException;

	/** @description： Search a user by id*/
	UserDO getUserDO(String id) throws SQLException;

	/** @description： Update a user*/
	void update(UserDO userDO) throws SQLException;

	/** @description： Delete a user by id*/
	void delete(String id) throws SQLException;

}
