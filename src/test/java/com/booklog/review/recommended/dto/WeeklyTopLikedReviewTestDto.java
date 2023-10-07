package com.booklog.review.recommended.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Document(collection = "reviewlikes")
@Getter
@RequiredArgsConstructor
public class WeeklyTopLikedReviewTestDto {
	@Id
	private String id;
	private final String reviewId;
	private final String userId;
	private final String likedAt;
}
