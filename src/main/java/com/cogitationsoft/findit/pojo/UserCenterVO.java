package com.cogitationsoft.findit.pojo;

/**
 * @author: Andy
 * @date: 5/26/2018 1:54 PM
 * @description: 用户中心
 * @version: 1.0
 */
public class UserCenterVO {
	private UserVO userVO;
	private Integer duringDays;
	private Integer allPublishCred;
	private Integer allFinishCred;
	private Integer allGetLetter;
	private Integer allSentLetter;
	private Integer allCommentCred;
	private Integer allMocriReward;

	public UserCenterVO(){}

	public UserCenterVO(UserVO userVO, Integer duringDays, Integer allPublishCred, Integer allFinishCred,
	                    Integer allGetLetter, Integer allSentLetter, Integer allCommentCred, Integer allMocriReward) {
		this.userVO = userVO;
		this.duringDays = duringDays;
		this.allPublishCred = allPublishCred;
		this.allFinishCred = allFinishCred;
		this.allGetLetter = allGetLetter;
		this.allSentLetter = allSentLetter;
		this.allCommentCred = allCommentCred;
		this.allMocriReward = allMocriReward;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public Integer getDuringDays() {
		return duringDays;
	}

	public void setDuringDays(Integer duringDays) {
		this.duringDays = duringDays;
	}

	public Integer getAllPublishCred() {
		return allPublishCred;
	}

	public void setAllPublishCred(Integer allPublishCred) {
		this.allPublishCred = allPublishCred;
	}

	public Integer getAllFinishCred() {
		return allFinishCred;
	}

	public void setAllFinishCred(Integer allFinishCred) {
		this.allFinishCred = allFinishCred;
	}

	public Integer getAllGetLetter() {
		return allGetLetter;
	}

	public void setAllGetLetter(Integer allGetLetter) {
		this.allGetLetter = allGetLetter;
	}

	public Integer getAllSentLetter() {
		return allSentLetter;
	}

	public void setAllSentLetter(Integer allSentLetter) {
		this.allSentLetter = allSentLetter;
	}

	public Integer getAllCommentCred() {
		return allCommentCred;
	}

	public void setAllCommentCred(Integer allCommentCred) {
		this.allCommentCred = allCommentCred;
	}

	public Integer getAllMocriReward() {
		return allMocriReward;
	}

	public void setAllMocriReward(Integer allMocriReward) {
		this.allMocriReward = allMocriReward;
	}
}
