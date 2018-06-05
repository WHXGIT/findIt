package com.cogitationsoft.findit.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Andy
 * @date: 5/29/2018 8:59 PM
 * @description: 分割
 * @version: 1.0
 */
public class CutName {

	public static Map<String, String> getDoltResult(String parm){
		int indexDolt = parm.indexOf('.');
		String name = parm.substring(0, indexDolt);
		String type = parm.substring(indexDolt + 1, parm.length());
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("type", type);
		return map;
	}
}
