package com.booklog.review.like.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewLikeResponseDto {
	private long likesCount;

	public static ReviewLikeResponseDto of(long likesCount){
		return ReviewLikeResponseDto.builder()
			.likesCount(likesCount)
			.build();
	}
}
