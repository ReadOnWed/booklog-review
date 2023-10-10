package com.booklog.review.scrap.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.booklog.review.scrap.dto.ReviewScrap;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "reviewscraps")
public class ReviewScrapEvent {
	@Id
	private String id;
	private String reviewId;
	private String userId;
	private String scrapedAt;

	public static ReviewScrapEvent of(ReviewScrap reviewScrap){
		return ReviewScrapEvent.builder()
			.reviewId(reviewScrap.getReviewId())
			.userId(reviewScrap.getUserId())
			.scrapedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
			.build();
	}
}
