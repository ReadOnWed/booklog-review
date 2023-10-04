package com.booklog.review.like.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewLike {
	private String reviewId;
	private String userId;

	public static ReviewLike of(ReviewLikeRequestDto reviewLikeRequestDto){
		return ReviewLike.builder()
			.reviewId(reviewLikeRequestDto.getReviewId())
			.userId(reviewLikeRequestDto.getUserId())
			.build();
	}
}
