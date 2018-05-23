package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.UserLetterDO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

/**
 * @author: Andy
 * @date: 5/18/2018 3:19 PM
 * @description:
 * @version: 1.0
 */
@Mapper
public interface UserLetterMapper {

	void insert(UserLetterDO userLetterDO) throws SQLException;

}
