package com.cogitationsoft.findit.pojo;

import java.util.Objects;

/**
 * @author: Andy
 * @date: 5/7/2018 5:12 PM
 * @description: 用户证件关联数据对象
 * @version: 1.0
 */
public class UserCredentialDO {
	private String id;
	private String credId;
	private String userId;
	private Integer state;
	private Integer publishTime;

	public UserCredentialDO() {

	}

	public UserCredentialDO(String id, String credId, String userId, Integer state, Integer publishTime) {
		this.id = id;
		this.credId = credId;
		this.userId = userId;
		this.state = state;
		this.publishTime = publishTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCredId() {
		return credId;
	}

	public void setCredId(String credId) {
		this.credId = credId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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
		if (!(o instanceof UserCredentialDO)) {
			return false;
		}
		UserCredentialDO that = (UserCredentialDO) o;
		return Objects.equals(getId(), that.getId()) &&
				Objects.equals(getCredId(), that.getCredId()) &&
				Objects.equals(getUserId(), that.getUserId()) &&
				Objects.equals(getState(), that.getState()) &&
				Objects.equals(getPublishTime(), that.getPublishTime());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getCredId(), getUserId(), getState(), getPublishTime());
	}
}
