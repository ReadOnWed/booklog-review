package com.booklog.review.scrap.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewScrapResponseDto {
	private long scrapsCount;

	public static ReviewScrapResponseDto of(long scrapsCount){
		return ReviewScrapResponseDto.builder()
			.scrapsCount(scrapsCount)
			.build();
	}
}
