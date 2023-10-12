package com.booklog.review.comment.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.booklog.review.comment.entity.CommentEntity;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Comment {
	private String commentId;
	private String userId;
	private String content;
	private String reviewId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<Comment> replies;

	@Nullable
	private String parentCommentId;

	public static Comment of(CommentPostRequestDto commentPostRequestDto){
		return Comment.builder()
			.reviewId(commentPostRequestDto.getReviewId())
			.userId(commentPostRequestDto.getUserId())
			.content(commentPostRequestDto.getInputComment())
			.parentCommentId(commentPostRequestDto.getParentCommentId())
			.build();
	}

	public static Comment of(CommentEditRequestDto commentEditRequestDto){
		return Comment.builder()
			.userId(commentEditRequestDto.getUserId())
			.commentId(commentEditRequestDto.getCommentId())
			.content(commentEditRequestDto.getInputContent())
			.build();
	}

	public static Comment of(CommentDeleteRequestDto commentDeleteRequestDto){
		return Comment.builder()
			.userId(commentDeleteRequestDto.getUserId())
			.commentId(commentDeleteRequestDto.getCommentId())
			.build();
	}

	public static Comment of(CommentEntity commentEntity){
		return Comment.builder()
			.commentId(commentEntity.getCommentId())
			.userId(commentEntity.getUserId())
			.content(commentEntity.getContent())
			.reviewId(commentEntity.getReviewId())
			.createdAt(commentEntity.getCreatedAt())
			.updatedAt(commentEntity.getUpdatedAt())
			.replies(listOf(commentEntity.getReplies()))
			.parentCommentId(commentEntity.getParentCommentId())
			.build();
	}

	public static List<Comment> listOf(List<CommentEntity> commentEntities){
		return commentEntities.stream()
				.map(Comment::of)
				.collect(Collectors.toList());
	}
}
