package com.booklog.review.write.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.booklog.review.write.dto.Book;
import com.booklog.review.write.dto.Review;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "review")
@Getter
@Builder
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
	private Book book;

	public static ReviewEntity of(Review review, Book book){
		return ReviewEntity.builder()
			.userId(review.getUserId())
			.reviewWriter(review.getReviewWriter())
			.reviewTitle(review.getReviewTitle())
			.reviewContent(review.getReviewContents())
			.rating(review.getRating() * 10)
			.createdAt(LocalDateTime.now())
			.updatedAt(LocalDateTime.now())
			.readStartAt(review.getReadStartAt())
			.readEndAt(review.getReadEndAt())
			.hidden(false)
			.book(book)
			.build();
	}
}
