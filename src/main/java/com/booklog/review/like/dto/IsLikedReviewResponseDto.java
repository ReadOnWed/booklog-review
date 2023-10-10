package com.booklog.review.like.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IsLikedReviewResponseDto {
	private boolean liked;

	public static IsLikedReviewResponseDto of(boolean liked){
		return IsLikedReviewResponseDto.builder()
			.liked(liked)
			.build();
	}
}
