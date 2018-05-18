package com.cogitationsoft.findit.service;

import com.cogitationsoft.findit.pojo.LetterDO;
import org.springframework.stereotype.Service;

/**
 * @author: Andy
 * @date: 5/18/2018 1:39 PM
 * @description: letter
 * @version: 1.0
 */
public interface LetterService {
	/** @description： 插入一个信件*/
	LetterDO insert(LetterDO letterDO);
}
