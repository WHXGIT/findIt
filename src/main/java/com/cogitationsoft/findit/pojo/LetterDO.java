package com.cogitationsoft.findit.pojo;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author: Andy
 * @date: 5/7/2018 2:48 PM
 * @description: 信件实体
 * @version: 1.0
 */
public class LetterDO {
	private String letterId;
	private LocalDateTime createTime;
	private String title;
	private String content;
	private String createName;
	private String toName;

	public LetterDO() {
	}

	public LetterDO(String letterId, LocalDateTime createTime, String title,
	                String content, String createName, String toName) {
		this.letterId = letterId;
		this.createTime = createTime;
		this.title = title;
		this.content = content;
		this.createName = createName;
		this.toName = toName;
	}

	public String getLetterId() {
		return letterId;
	}

	public void setLetterId(String letterId) {
		this.letterId = letterId;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof LetterDO)) {
			return false;
		}
		LetterDO letterDO = (LetterDO) o;
		return Objects.equals(getLetterId(), letterDO.getLetterId()) &&
				Objects.equals(getCreateTime(), letterDO.getCreateTime()) &&
				Objects.equals(getTitle(), letterDO.getTitle()) &&
				Objects.equals(getContent(), letterDO.getContent()) &&
				Objects.equals(getCreateName(), letterDO.getCreateName()) &&
				Objects.equals(getToName(), letterDO.getToName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLetterId(), getCreateTime(), getTitle(),
				getContent(), getCreateName(), getToName());
	}
}
