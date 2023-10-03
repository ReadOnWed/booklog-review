package com.booklog.review.search.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document(collection = "review")
@Getter
public class ReviewEntity {
	@Id
	private String id;
	private String userId;
	private String reviewWriter;
	private String reviewTitle;
	private String reviewContent;
	private int rating;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDate readStartAt;
	private LocalDate readEndAt;
	private int likesCount;
	private int scrapsCount;
	private int viewsCount;
	private boolean hidden;
	private BookEntity book;
}
