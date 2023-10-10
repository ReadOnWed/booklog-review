package com.booklog.review.scrap.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewScrap {
	private String reviewId;
	private String userId;

	public static ReviewScrap of(ReviewScrapRequestDto reviewScrapRequestDto){
		return ReviewScrap.builder()
			.reviewId(reviewScrapRequestDto.getReviewId())
			.userId(reviewScrapRequestDto.getUserId())
			.build();
	}
}
