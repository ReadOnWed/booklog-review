package com.booklog.review.views.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.booklog.review.views.dto.ViewsCount;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "viewscount")
public class ViewsCountEvent {
	private String userId;
	private String reviewId;
	private LocalDateTime viewAt;

	public static ViewsCountEvent of(ViewsCount viewsCount){
		return ViewsCountEvent.builder()
			.userId(viewsCount.getUserId())
			.reviewId(viewsCount.getReviewId())
			.viewAt(LocalDateTime.now())
			.build();
	}
}
