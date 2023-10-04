package com.booklog.review.views.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ViewsCount {
	private String userId;
	private String reviewId;

	public static ViewsCount of(ViewsCountRequestDto viewsCountRequestDto){
		return ViewsCount.builder()
			.userId(viewsCountRequestDto.getUserId())
			.reviewId(viewsCountRequestDto.getReviewId())
			.build();
	}
}
