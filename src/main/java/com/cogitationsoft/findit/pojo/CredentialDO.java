package com.cogitationsoft.findit.pojo;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author: Andy
 * @date: 5/7/2018 2:49 PM
 * @description: Credential Data Object
 * @version: 1.0
 */
@Alias(value = "CredentialDO")
public class CredentialDO {
	private String credId;
	private String credNo;
	private String credName;
	private String credType;
	private String credHoldName;
	private String pickAddress;
	private LocalDateTime pickTime;
	private String description;
	private String address;
	private String lostAddress;
	private LocalDateTime lostTime;
	private String photoPath;
	private Integer microReward;

	public CredentialDO() {
	}

	public CredentialDO(String credId, String credNo, String credName, String credType,
	                    String credHoldName, String pickAddress, LocalDateTime pickTime, String description,
	                    String address, String lostAddress, LocalDateTime lostTime,
	                    String photoPath, Integer microReward) {
		this.credId = credId;
		this.credNo = credNo;
		this.credName = credName;
		this.credType = credType;
		this.credHoldName = credHoldName;
		this.pickAddress = pickAddress;
		this.pickTime = pickTime;
		this.description = description;
		this.address = address;
		this.lostAddress = lostAddress;
		this.lostTime = lostTime;
		this.photoPath = photoPath;
		this.microReward = microReward;
	}

	public String getCredId() {
		return credId;
	}

	public void setCredId(String credId) {
		this.credId = credId;
	}

	public String getCredNo() {
		return credNo;
	}

	public void setCredNo(String credNo) {
		this.credNo = credNo;
	}

	public String getCredName() {
		return credName;
	}

	public void setCredName(String credName) {
		this.credName = credName;
	}

	public String getCredType() {
		return credType;
	}

	public void setCredType(String credType) {
		this.credType = credType;
	}

	public String getCredHoldName() {
		return credHoldName;
	}

	public void setCredHoldName(String credHoldName) {
		this.credHoldName = credHoldName;
	}

	public String getPickAddress() {
		return pickAddress;
	}

	public void setPickAddress(String pickAddress) {
		this.pickAddress = pickAddress;
	}

	public LocalDateTime getPickTime() {
		return pickTime;
	}

	public void setPickTime(LocalDateTime pickTime) {
		this.pickTime = pickTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLostAddress() {
		return lostAddress;
	}

	public void setLostAddress(String lostAddress) {
		this.lostAddress = lostAddress;
	}

	public LocalDateTime getLostTime() {
		return lostTime;
	}

	public void setLostTime(LocalDateTime lostTime) {
		this.lostTime = lostTime;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Integer getMicroReward() {
		return microReward;
	}

	public void setMicroReward(Integer microReward) {
		this.microReward = microReward;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CredentialDO)) {
			return false;
		}
		CredentialDO that = (CredentialDO) o;
		return Objects.equals(getCredId(), that.getCredId()) &&
				Objects.equals(getCredNo(), that.getCredNo()) &&
				Objects.equals(getCredName(), that.getCredName()) &&
				Objects.equals(getCredType(), that.getCredType()) &&
				Objects.equals(getCredHoldName(), that.getCredHoldName()) &&
				Objects.equals(getPickAddress(), that.getPickAddress()) &&
				Objects.equals(getPickTime(), that.getPickTime()) &&
				Objects.equals(getDescription(), that.getDescription()) &&
				Objects.equals(getAddress(), that.getAddress()) &&
				Objects.equals(getLostAddress(), that.getLostAddress()) &&
				Objects.equals(getLostTime(), that.getLostTime()) &&
				Objects.equals(getPhotoPath(), that.getPhotoPath()) &&
				Objects.equals(getMicroReward(), that.getMicroReward());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCredId(), getCredNo(), getCredName(), getCredType(),
				getCredHoldName(), getPickAddress(), getPickTime(), getDescription(),
				getAddress(), getLostAddress(), getLostTime(), getPhotoPath(), getMicroReward());
	}
}
