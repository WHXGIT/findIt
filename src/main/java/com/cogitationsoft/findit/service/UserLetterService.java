package com.cogitationsoft.findit.service;

import com.cogitationsoft.findit.pojo.UserLetterDO;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * @author: Andy
 * @date: 5/18/2018 3:41 PM
 * @description:
 * @version: 1.0
 */
public interface UserLetterService {
	void insert(UserLetterDO userLetterDO) throws SQLException;
}
