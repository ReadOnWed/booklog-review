package com.booklog.review.detail.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

@Getter
public class Comment {
	private String commentId;
	private String userId;
	private String content;
	private String reviewId;
	private String parentCommentId;
	private String parentReplyId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int likesCount;
	private int dislikesCount;
	private List<Comment> replies;
}
