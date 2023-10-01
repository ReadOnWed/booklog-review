package com.booklog.review.detail.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.booklog.review.detail.dto.Book;
import com.booklog.review.detail.dto.Comment;

import lombok.Getter;

@Document(collection = "review")
@Getter
public class ReviewDetailEntity {
	@Id
	private String id;
	private Book book;
	private String userId;
	private String reviewWriter;
	private String reviewTitle;
	private String reviewContent;
	private int rating;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDate readStartAt;
	private LocalDate readEndAt;
	private long likesCount;
	private long scrapsCount;
	private long viewsCount;
	private long commentCount;
	private List<Comment> comments;
}
