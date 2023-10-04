package com.booklog.review.like.repository;

import com.booklog.review.like.entity.ReviewLikeEvent;

public interface RedisReviewLikeRepository {
	boolean isLikedForReviewByUserId(String reviewId, String userId);
	void postLikeByReviewId(ReviewLikeEvent reviewLikeEvent);
	void deleteLikeByReviewIdAndUserId(String reviewId, String userId);
	long countLikesByReviewId(String reviewId);
}
