package com.booklog.review.views.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CurrentViewsCount {
	private long currentViewsCount;

	public static CurrentViewsCount of(long currentViewsCount){
		return CurrentViewsCount.builder()
			.currentViewsCount(currentViewsCount)
			.build();
	}
}
