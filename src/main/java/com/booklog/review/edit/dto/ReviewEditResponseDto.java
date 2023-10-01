package com.booklog.review.edit.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewEditResponseDto {
	private String reviewId;

	public static ReviewEditResponseDto of(String reviewId){
		return ReviewEditResponseDto.builder().reviewId(reviewId).build();
	}
}
