package com.booklog.review.scrap.repository;

import com.booklog.review.scrap.entity.ReviewScrapEvent;

public interface RedisReviewScrapRepository {
	boolean isScrappedForReviewByUserId(String reviewId, String userId);
	void postScrapByReviewId(ReviewScrapEvent reviewScrapEvent);
	void deleteScrapByReviewIdAndUserId(String reviewId, String userId);
	long countScrapsByReviewId(String reviewId);
}
