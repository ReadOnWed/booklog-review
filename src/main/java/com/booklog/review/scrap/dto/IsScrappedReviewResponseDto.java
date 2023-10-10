package com.booklog.review.scrap.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IsScrappedReviewResponseDto {
	private boolean scrapped;

	public static IsScrappedReviewResponseDto of(boolean scrapped){
		return IsScrappedReviewResponseDto.builder()
			.scrapped(scrapped)
			.build();
	}
}
