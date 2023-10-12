package com.booklog.review.comment.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.booklog.review.comment.dto.Comment;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "comment")
@Getter
@Builder
public class CommentEntity {
	@Id
	private String commentId;
	private String userId;
	private String content;
	private String reviewId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;
	private String parentCommentId;
	private List<CommentEntity> replies;
	private boolean deleted;

	public static CommentEntity of(Comment comment){
		return CommentEntity.builder()
			.userId(comment.getUserId())
			.content(comment.getContent())
			.reviewId(comment.getReviewId())
			.createdAt(LocalDateTime.now())
			.updatedAt(LocalDateTime.now())
			.parentCommentId(comment.getParentCommentId())
			.replies(new ArrayList<>())
			.deleted(false)
			.build();
	}

	public CommentEntity attachReplies(List<CommentEntity> replies){
		this.replies = replies;
		return this;
	}

	public CommentEntity editContent(String content){
		this.content = content;
		return this;
	}

	public CommentEntity updateAt(){
		this.updatedAt = LocalDateTime.now();
		return this;
	}

	public CommentEntity delete(){
		this.deleted = true;
		return this;
	}

	public CommentEntity deletedAt(){
		this.deletedAt = LocalDateTime.now();
		return this;
	}
}
