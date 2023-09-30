package com.booklog.review.write.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Review {
	private String userId;
	private String bookId;
	private String reviewTitle;
	private String reviewContents;
	private int rating;
	private String reviewWriter;
	private LocalDate readStartAt;
	private LocalDate readEndAt;

	public static Review of(ReviewWriteRequestDto reviewWriteRequestDto){
		return Review.builder()
			.userId(reviewWriteRequestDto.getUserId())
			.bookId(reviewWriteRequestDto.getBookId())
			.reviewTitle(reviewWriteRequestDto.getTitle())
			.reviewContents(reviewWriteRequestDto.getContents())
			.rating(reviewWriteRequestDto.getRating())
			.reviewWriter(reviewWriteRequestDto.getReviewWriter())
			.readStartAt(reviewWriteRequestDto.getReadStartAt())
			.readEndAt(reviewWriteRequestDto.getReadEndAt())
			.build();
	}
}
