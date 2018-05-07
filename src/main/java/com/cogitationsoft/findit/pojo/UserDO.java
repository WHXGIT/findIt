package com.cogitationsoft.findit.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author: Andy
 * @date: 5/7/2018 2:47 PM
 * @description: 用户实体
 * @version: 1.0
 */
public class UserDO{
	private String userId;
	private String username;
	private String password;
	private String nickname;
	private String phone;
	private String otherConnect;
	private String headImg;
	private LocalDateTime registerTime;
	private Integer authority;
	private Integer state;
	private Integer sex;
	private Integer age;

	public UserDO() {
	}

	public UserDO(String userId, String username, String password, String nickname,
	              String phone, String otherConnect, String headImg, LocalDateTime registerTime,
	              Integer authority, Integer state, Integer sex, Integer age) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.phone = phone;
		this.otherConnect = otherConnect;
		this.headImg = headImg;
		this.registerTime = registerTime;
		this.authority = authority;
		this.state = state;
		this.sex = sex;
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOtherConnect() {
		return otherConnect;
	}

	public void setOtherConnect(String otherConnect) {
		this.otherConnect = otherConnect;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public LocalDateTime getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof UserDO)) {
			return false;
		}
		UserDO userDO = (UserDO) o;
		return Objects.equals(getUserId(), userDO.getUserId()) &&
				Objects.equals(getUsername(), userDO.getUsername()) &&
				Objects.equals(getPassword(), userDO.getPassword()) &&
				Objects.equals(getNickname(), userDO.getNickname()) &&
				Objects.equals(getPhone(), userDO.getPhone()) &&
				Objects.equals(getOtherConnect(), userDO.getOtherConnect()) &&
				Objects.equals(getHeadImg(), userDO.getHeadImg()) &&
				Objects.equals(getRegisterTime(), userDO.getRegisterTime()) &&
				Objects.equals(getAuthority(), userDO.getAuthority()) &&
				Objects.equals(getState(), userDO.getState()) &&
				Objects.equals(getSex(), userDO.getSex()) &&
				Objects.equals(getAge(), userDO.getAge());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUserId(), getUsername(), getPassword(), getNickname(), getPhone(),
				getOtherConnect(), getHeadImg(), getRegisterTime(), getAuthority(), getState(),
				getSex(), getAge());
	}
}
