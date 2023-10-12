package com.booklog.review.comment.dto;

import lombok.Getter;

@Getter
public class CommentDeleteRequestDto {
	private String userId;
	private String commentId;
}
