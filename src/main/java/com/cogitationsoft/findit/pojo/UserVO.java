package com.cogitationsoft.findit.pojo;

import com.cogitationsoft.findit.common.enums.AuthorityEnum;
import com.cogitationsoft.findit.common.enums.SexEnum;
import com.cogitationsoft.findit.common.enums.StateEnum;

import java.time.LocalDateTime;

/**
 * @author: Andy
 * @date: 5/8/2018 4:57 PM
 * @description: User view object
 * @version: 1.0
 */
public class UserVO {
	private String userId;
	private String username;
	private String password;
	private String nickname;
	private String phone;
	private String otherConnect;
	private String headImg;
	private LocalDateTime registerTime;
	private AuthorityEnum authority;
	private StateEnum state;
	private SexEnum sex;
	private Integer age;

	public UserVO(){}

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

	public AuthorityEnum getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityEnum authority) {
		this.authority = authority;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserVO{" +
				"userId='" + userId + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", nickname='" + nickname + '\'' +
				", phone='" + phone + '\'' +
				", otherConnect='" + otherConnect + '\'' +
				", headImg='" + headImg + '\'' +
				", registerTime=" + registerTime +
				", authority='" + authority + '\'' +
				", state='" + state + '\'' +
				", sex='" + sex + '\'' +
				", age=" + age +
				'}';
	}
}