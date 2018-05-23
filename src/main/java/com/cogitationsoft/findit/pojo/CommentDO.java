package com.cogitationsoft.findit.pojo;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author: Andy
 * @date: 5/7/2018 2:48 PM
 * @description: 评论实体
 * @version: 1.0
 */
@Alias(value = "CommentDO")
public class CommentDO {
	private String commentId;
	private String commentName;
	private String toName;
	private LocalDateTime commentTime;
	private String comment;
	private String commentUserId;
	private String toUserId;

	public CommentDO() {
	}

	public CommentDO(String commentId, String commentName, String toName, LocalDateTime commentTime,
	                 String comment, String commentUserId, String toUserId) {
		this.commentId = commentId;
		this.commentName = commentName;
		this.toName = toName;
		this.commentTime = commentTime;
		this.comment = comment;
		this.commentUserId = commentUserId;
		this.toUserId = toUserId;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public LocalDateTime getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(LocalDateTime commentTime) {
		this.commentTime = commentTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CommentDO)) {
			return false;
		}
		CommentDO commentDO = (CommentDO) o;
		return Objects.equals(getCommentId(), commentDO.getCommentId()) &&
				Objects.equals(getCommentName(), commentDO.getCommentName()) &&
				Objects.equals(getToName(), commentDO.getToName()) &&
				Objects.equals(getCommentTime(), commentDO.getCommentTime()) &&
				Objects.equals(getComment(), commentDO.getComment()) &&
				Objects.equals(getCommentUserId(), commentDO.getCommentUserId()) &&
				Objects.equals(getToUserId(), commentDO.getToUserId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCommentId(), getCommentName(), getToName(), getCommentTime(), getComment(), getCommentUserId(), getToUserId());
	}
}
