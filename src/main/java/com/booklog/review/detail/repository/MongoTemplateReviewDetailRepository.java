package com.booklog.review.detail.repository;

public interface MongoTemplateReviewDetailRepository {
	void incrementLikesCountByReviewId(String reviewId);
	void incrementScrapsCountByReviewId(String reviewId);
	void decrementLikesCountByReviewId(String reviewId);
	void decrementScrapsCountByReviewId(String reviewId);
}
