package com.booklog.review.edit.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EditedReview {
	private String id;
	private String reviewTitle;
	private String reviewContent;
	private int rating;
	private LocalDate readStartAt;
	private LocalDate readEndAt;

	public static EditedReview of(ReviewEditRequestDto reviewEditRequestDto){
		return EditedReview.builder()
			.id(reviewEditRequestDto.getReviewId())
			.reviewTitle(reviewEditRequestDto.getTitle())
			.reviewContent(reviewEditRequestDto.getContent())
			.rating(reviewEditRequestDto.getRating() * 10)
			.readStartAt(reviewEditRequestDto.getReadStartAt())
			.readEndAt(reviewEditRequestDto.getReadEndAt())
			.build();
	}

}
