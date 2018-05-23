package com.cogitationsoft.findit.pojo;

import java.util.List;

/**
 * @author: Andy
 * @date: 5/23/2018 10:12 AM
 * @description: 证件详情页的视图对象
 * @version: 1.0
 */
public class CredDetailVO {
	private CredentialDO credentialDO;
	private List<CommentDO> list;

	public CredDetailVO(){}

	public CredDetailVO(CredentialDO credentialDO, List<CommentDO> list) {
		this.credentialDO = credentialDO;
		this.list = list;
	}

	public CredentialDO getCredentialDO() {
		return credentialDO;
	}

	public void setCredentialDO(CredentialDO credentialDO) {
		this.credentialDO = credentialDO;
	}
}
