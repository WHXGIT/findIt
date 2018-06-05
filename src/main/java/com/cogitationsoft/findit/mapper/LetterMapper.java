package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.LetterDO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Andy
 * @date: 5/18/2018 1:16 PM
 * @description: 信件Mapper
 * @version: 1.0
 */
public interface LetterMapper {

	/** @description： 插入一个信件*/
	void insert(LetterDO letterDO) throws SQLException;

	/** @description： 分页查询、 信件列表*/
	List<LetterDO> listLetterDO(LetterDO letterDO);

	List<LetterDO> listGetLetterDO(String id) throws SQLException;

	List<LetterDO> listSentLetterDO(String id) throws SQLException;

}
