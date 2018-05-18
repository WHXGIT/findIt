package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.LetterDO;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * @author: Andy
 * @date: 5/18/2018 1:16 PM
 * @description: 信件Mapper
 * @version: 1.0
 */
public interface LetterMapper {

	/** @description： 插入一个信件*/
	void insert(LetterDO letterDO) throws SQLException;

}
