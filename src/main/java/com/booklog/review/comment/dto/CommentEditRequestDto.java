package com.booklog.review.comment.dto;

import lombok.Getter;

@Getter
public class CommentEditRequestDto {
	private String userId;
	private String commentId;
	private String inputContent;
}
