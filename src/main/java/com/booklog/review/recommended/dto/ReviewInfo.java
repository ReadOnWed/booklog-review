package com.booklog.review.recommended.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.booklog.review.recommended.entity.ReviewEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewInfo {
	private String id;
	private String userId;
	private String reviewWriter;
	private String reviewTitle;
	private String reviewContent;
	private long rating;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private long likesCount;
	private long scrapsCount;
	private long commentCount;
	private long viewsCount;

	public static List<ReviewInfo> listOf(List<ReviewEntity> reviewEntities){
		return reviewEntities.stream()
			.map(ReviewInfo::of)
			.collect(Collectors.toList());
	}
	private static ReviewInfo of(ReviewEntity reviewEntity){
		return ReviewInfo.builder()
			.id(reviewEntity.getId())
			.userId(reviewEntity.getUserId())
			.reviewWriter(reviewEntity.getReviewWriter())
			.reviewTitle(reviewEntity.getReviewTitle())
			.reviewContent(reviewEntity.getReviewContent())
			.rating(reviewEntity.getRating())
			.createdAt(reviewEntity.getCreatedAt())
			.updatedAt(reviewEntity.getUpdatedAt())
			.likesCount(reviewEntity.getLikesCount())
			.scrapsCount(reviewEntity.getScrapsCount())
			.commentCount(reviewEntity.getCommentCount())
			.viewsCount(reviewEntity.getViewsCount())
			.build();
	}
}
