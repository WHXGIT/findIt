package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.UserLetterDO;

import java.sql.SQLException;

/**
 * @author: Andy
 * @date: 5/18/2018 3:19 PM
 * @description:
 * @version: 1.0
 */
public interface UserLetterMapper {

	void insert(UserLetterDO userLetterDO) throws SQLException;

}
