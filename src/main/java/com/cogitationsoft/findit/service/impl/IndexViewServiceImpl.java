package com.cogitationsoft.findit.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cogitationsoft.findit.mapper.IndexViewMapper;
import com.cogitationsoft.findit.pojo.IndexVO;
import com.cogitationsoft.findit.service.IndexViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: Andy
 * @date: 5/25/2018 1:44 PM
 * @description:
 * @version: 1.0
 */
@Service
public class IndexViewServiceImpl implements IndexViewService{
	@Autowired(required = false)
	private IndexViewMapper indexViewMapper;
	@Override
	public IndexVO getData() {
		IndexVO vo = new IndexVO();
		try {
			vo.setAllFindCred(indexViewMapper.getAllFindCred());
			vo.setAllLeftCred(indexViewMapper.getAllLeftCred());
			vo.setAllLetter(indexViewMapper.getAllLetter());
			vo.setAllPublishCred(indexViewMapper.getAllPublishCred());
			vo.setAllUsedletter(2 * indexViewMapper.getAllUsedletter());
			vo.setAllUser(indexViewMapper.getAllUser());

			Set resentCredRecord = indexViewMapper.getResentCredRecord();
			Set resentLetterRecord = indexViewMapper.getResentLetterRecord();

			Iterator iterator1 = resentCredRecord.iterator();
			Iterator iterator2 = resentLetterRecord.iterator();
			List<String> list = new ArrayList<>();
			while (iterator1.hasNext()){
				String iterator = JSON.toJSONString(iterator1.next());
				list.add(iterator);
			}
			while (iterator2.hasNext()){
				String iterator = JSON.toJSONString(iterator2.next());
				list.add(iterator);
			}
			vo.setMessage(list);
		}catch (Exception e){
			e.printStackTrace();
		}

		return vo;
	}
}
