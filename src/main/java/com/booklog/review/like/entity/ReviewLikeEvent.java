package com.booklog.review.like.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.booklog.review.like.dto.ReviewLike;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "reviewlikes")
public class ReviewLikeEvent {
	@Id
	private String id;
	private String reviewId;
	private String userId;
	private String likedAt;

	public static ReviewLikeEvent of(ReviewLike reviewLike){
		return ReviewLikeEvent.builder()
			.reviewId(reviewLike.getReviewId())
			.userId(reviewLike.getUserId())
			.likedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
			.build();
	}
}
