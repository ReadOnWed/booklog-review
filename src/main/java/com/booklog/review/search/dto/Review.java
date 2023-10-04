package com.booklog.review.search.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.booklog.review.search.entity.ReviewEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Review {
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

	public static List<Review> listOf(List<ReviewEntity> reviewEntities){
		return reviewEntities.stream()
			.map(Review::of)
			.collect(Collectors.toList());
	}

	private static Review of(ReviewEntity reviewEntity){
		return Review.builder()
			.id(reviewEntity.getId())
			.userId(reviewEntity.getUserId())
			.reviewWriter(reviewEntity.getReviewWriter())
			.reviewTitle(reviewEntity.getReviewTitle())
			.reviewContent(reviewEntity.getReviewContent())
			.rating(reviewEntity.getRating())
			.createdAt(reviewEntity.getCreatedAt())
			.updatedAt(reviewEntity.getUpdatedAt())
			.readStartAt(reviewEntity.getReadStartAt())
			.readEndAt(reviewEntity.getReadEndAt())
			.likesCount(reviewEntity.getLikesCount())
			.scrapsCount(reviewEntity.getScrapsCount())
			.viewsCount(reviewEntity.getViewsCount())
			.book(Book.of(reviewEntity.getBook()))
			.build();
	}
}
