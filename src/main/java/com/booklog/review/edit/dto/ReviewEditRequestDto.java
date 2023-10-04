package com.booklog.review.edit.dto;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class ReviewEditRequestDto {
	private String reviewId;
	private String title;
	private String content;
	private int rating;
	private LocalDate readStartAt;
	private LocalDate readEndAt;

}
