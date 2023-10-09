package com.booklog.review.detail.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.booklog.review.comment.dto.Comment;
import com.booklog.review.detail.entity.ReviewDetailEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewDetail {
	private String id;
	private Book book;
	private String userId;
	private String reviewWriter;
	private String reviewTitle;
	private String reviewContent;
	private int rating;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDate readStartAt;
	private LocalDate readEndAt;
	private long likesCount;
	private long scrapsCount;
	private long viewsCount;
	private long commentCount;
	private List<Comment> comments;

	public static ReviewDetail of(ReviewDetailEntity reviewDetailEntity){
		return ReviewDetail.builder()
			.id(reviewDetailEntity.getId())
			.book(Book.of(reviewDetailEntity.getBook()))
			.userId(reviewDetailEntity.getUserId())
			.reviewTitle(reviewDetailEntity.getReviewTitle())
			.reviewWriter(reviewDetailEntity.getReviewWriter())
			.reviewContent(reviewDetailEntity.getReviewContent())
			.rating(reviewDetailEntity.getRating())
			.createdAt(reviewDetailEntity.getCreatedAt())
			.updatedAt(reviewDetailEntity.getUpdatedAt())
			.readStartAt(reviewDetailEntity.getReadStartAt())
			.readEndAt(reviewDetailEntity.getReadEndAt())
			.likesCount(reviewDetailEntity.getLikesCount())
			.scrapsCount(reviewDetailEntity.getScrapsCount())
			.viewsCount(reviewDetailEntity.getViewsCount())
			.commentCount(reviewDetailEntity.getCommentCount())
			.comments(reviewDetailEntity.getComments())
			.build();
	}

	public ReviewDetail findComments(List<Comment> comments){
		this.comments = comments;
		return this;
	}
}
