package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.CommentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Andy
 * @date: 5/22/2018 8:16 PM
 * @description: 评论
 * @version: 1.0
 */
@Mapper
public interface CommentMapper {

	/** @description： 插入一条数据 */
	void insert(CommentDO commentDO) throws SQLException;

	/** @description： 获取评论列表*/
	List<CommentDO> listComment(CommentDO commentDO) throws SQLException;
}
