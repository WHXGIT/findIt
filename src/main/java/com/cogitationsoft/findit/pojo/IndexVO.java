package com.cogitationsoft.findit.pojo;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author: Andy
 * @date: 5/25/2018 11:02 AM
 * @description: 首页内容
 * @version: 1.0
 */
@Alias(value = "IndexVO")
public class IndexVO {
	private int allPublishCred;
	private int allFindCred;
	private int allLetter;
	private int allUser;
	private int allUsedletter;
	private int allLeftCred;
	private List<String> message;

	public IndexVO(){}

	public IndexVO(int allPublishCred, int allFindCred, int allLetter, int allUser,
	               int allUsedletter, int allLeftCred, List<String> message) {
		this.allPublishCred = allPublishCred;
		this.allFindCred = allFindCred;
		this.allLetter = allLetter;
		this.allUser = allUser;
		this.allUsedletter = allUsedletter;
		this.allLeftCred = allLeftCred;
		this.message = message;
	}

	public int getAllPublishCred() {
		return allPublishCred;
	}

	public void setAllPublishCred(int allPublishCred) {
		this.allPublishCred = allPublishCred;
	}

	public int getAllFindCred() {
		return allFindCred;
	}

	public void setAllFindCred(int allFindCred) {
		this.allFindCred = allFindCred;
	}

	public int getAllLetter() {
		return allLetter;
	}

	public void setAllLetter(int allLetter) {
		this.allLetter = allLetter;
	}

	public int getAllUser() {
		return allUser;
	}

	public void setAllUser(int allUser) {
		this.allUser = allUser;
	}

	public int getAllUsedletter() {
		return allUsedletter;
	}

	public void setAllUsedletter(int allUsedletter) {
		this.allUsedletter = allUsedletter;
	}

	public int getAllLeftCred() {
		return allLeftCred;
	}

	public void setAllLeftCred(int allLeftCred) {
		this.allLeftCred = allLeftCred;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}
}
