package com.cogitationsoft.findit.pojo;

import org.apache.ibatis.type.Alias;

import java.util.Objects;

/**
 * @author: Andy
 * @date: 5/7/2018 5:18 PM
 * @description: 用户信件数据对象
 * @version: 1.0
 */
@Alias(value = "UserLetterDO")
public class UserLetterDO {
	private String id;
	private String letterId;
	private String userId;
	private Integer publishTime;

	public UserLetterDO() {

	}

	public UserLetterDO(String id, String letterId, String userId, Integer publishTime) {
		this.id = id;
		this.letterId = letterId;
		this.userId = userId;
		this.publishTime = publishTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLetterId() {
		return letterId;
	}

	public void setLetterId(String letterId) {
		this.letterId = letterId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Integer publishTime) {
		this.publishTime = publishTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof UserLetterDO)) {
			return false;
		}
		UserLetterDO that = (UserLetterDO) o;
		return Objects.equals(getId(), that.getId()) &&
				Objects.equals(getLetterId(), that.getLetterId()) &&
				Objects.equals(getUserId(), that.getUserId()) &&
				Objects.equals(getPublishTime(), that.getPublishTime());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getLetterId(), getUserId(), getPublishTime());
	}
}
