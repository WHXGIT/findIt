package com.cogitationsoft.findit.service;

import com.cogitationsoft.findit.pojo.CommentDO;

import java.util.List;

/**
 * @author: Andy
 * @date: 5/22/2018 8:29 PM
 * @description: 评论
 * @version: 1.0
 */
public interface CommentService {

	/** @description： 插入一条评论*/
	void insert(CommentDO commentDO);

	/** @description： 获取评论列表*/
	List<CommentDO> listComment(CommentDO commentDO);

	/** @description： 终止一个已发布的证件*/
	boolean shutdownCred(String credId, String userId);

}
