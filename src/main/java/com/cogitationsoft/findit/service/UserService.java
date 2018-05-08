package com.cogitationsoft.findit.service;

import com.cogitationsoft.findit.pojo.UserDO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Andy
 * @date: 5/8/2018 9:37 AM
 * @description: 用户操作
 * @version: 1.0
 */
public interface UserService {

	/** @description： Be used to insert a user*/
	UserDO create(UserDO userDO);

	/** @description： Search a user by id*/
	UserDO readById(String id);

	/** @description： Update a user*/
	UserDO update(UserDO userDO);

	/** @description： Delete a user by id*/
	void delete(String id);

	UserDO login();
}
