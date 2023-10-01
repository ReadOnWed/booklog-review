package com.booklog.review.detail.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
	private int likesCount;
	private int scrapsCount;
	private int viewsCount;
	private int commentCount;
	private List<Comment> comments;

	public static ReviewDetail of(ReviewDetailEntity reviewDetailEntity){
		return ReviewDetail.builder()
			.id(reviewDetailEntity.getId())
			.book(reviewDetailEntity.getBook())
			.userId(reviewDetailEntity.getUserId())
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
}
