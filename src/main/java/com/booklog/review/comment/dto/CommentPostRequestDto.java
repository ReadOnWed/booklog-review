package com.booklog.review.comment.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class CommentPostRequestDto {
	private String userId;
	private String reviewId;
	private String inputComment;

	@Nullable
	private String parentCommentId;
}
