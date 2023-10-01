package com.booklog.review.write.dto;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class ReviewWriteRequestDto {
	private String userId;
	private String bookId;
	private String title;
	private String contents;
	private int rating;
	private String reviewWriter;
	private LocalDate readStartAt;
	private LocalDate readEndAt;
}
