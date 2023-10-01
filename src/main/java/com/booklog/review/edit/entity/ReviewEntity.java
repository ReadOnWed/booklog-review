package com.booklog.review.edit.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.booklog.review.edit.dto.EditedReview;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document(collection = "review")
public class ReviewEntity {
	@Id
	private String id;
	private String reviewTitle;
	private String reviewContent;
	private int rating;
	private LocalDate readStartAt;
	private LocalDate readEndAt;
	private LocalDateTime updatedAt;

	public static ReviewEntity of(EditedReview editedReview){
		return ReviewEntity.builder()
			.id(editedReview.getId())
			.reviewTitle(editedReview.getReviewTitle())
			.reviewContent(editedReview.getReviewContent())
			.rating(editedReview.getRating())
			.readStartAt(editedReview.getReadStartAt())
			.readEndAt(editedReview.getReadEndAt())
			.updatedAt(LocalDateTime.now())
			.build();
	}
}
