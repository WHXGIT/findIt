package com.cogitationsoft.findit.service.impl;

import com.cogitationsoft.findit.mapper.CommentMapper;
import com.cogitationsoft.findit.pojo.CommentDO;
import com.cogitationsoft.findit.service.CommentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Andy
 * @date: 5/22/2018 8:30 PM
 * @description: 评论Service实现类
 * @version: 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
	private static final Logger logger = LogManager.getLogger(CommentServiceImpl.class);


	@Autowired(required = false)
	private CommentMapper commentMapper;

	/**
	 * Method Description:
	 * 〈对数据进行处理， 添加一些默认信息〉
	 *
	 * @param:      评论数据对象
	 * @return:
	 * @author:     Andy
	 * @date:       5/22/2018 8:32 PM
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void insert(CommentDO commentDO) {
		try {
			commentMapper.insert(commentDO);
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * Method Description:
	 * 〈获取评论的列表信息〉
	 *
	 * @param:      null
	 * @return:
	 * @author:     Andy
	 * @date:       5/23/2018 10:44 AM
	 */
	@Override
	public List<CommentDO> listComment(CommentDO commentDO) {
		List<CommentDO> list = null;
		try {
			list = commentMapper.listComment(commentDO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
