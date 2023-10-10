package com.booklog.review.recommended.entity;

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
	private long rating;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private long likesCount;
	private long scrapsCount;
	private long commentCount;
	private long viewsCount;
}
