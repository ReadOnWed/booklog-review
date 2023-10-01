package com.booklog.review.write.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewWriteResponseDto {
	private String reviewId;

	public static ReviewWriteResponseDto of(String reviewId){
		return ReviewWriteResponseDto.builder().reviewId(reviewId).build();
	}
}
