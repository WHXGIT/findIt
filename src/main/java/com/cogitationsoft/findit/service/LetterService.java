package com.cogitationsoft.findit.service;

import com.cogitationsoft.findit.common.Pagination;
import com.cogitationsoft.findit.pojo.LetterDO;

/**
 * @author: Andy
 * @date: 5/18/2018 1:39 PM
 * @description: letter
 * @version: 1.0
 */
public interface LetterService {
	/** @description： 插入一个信件*/
	LetterDO insert(LetterDO letterDO);

	/** @description： 分页查询、条件查询 证件列表*/
	Pagination<LetterDO> listLetterDO(Pagination<LetterDO> page);

	/** @description： 查询与自己相关的信息*/
	Pagination<LetterDO> listSelfLetterDO(Pagination<LetterDO> page, String user_id,String type);
}
