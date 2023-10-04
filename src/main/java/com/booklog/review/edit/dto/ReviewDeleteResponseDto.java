package com.booklog.review.edit.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewDeleteResponseDto {
	private long deleteCount;

	public static ReviewDeleteResponseDto of(long deleteCount){
		return ReviewDeleteResponseDto.builder()
			.deleteCount(deleteCount)
			.build();
	}
}
