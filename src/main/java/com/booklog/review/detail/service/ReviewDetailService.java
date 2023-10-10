package com.booklog.review.detail.service;

import com.booklog.review.detail.dto.ReviewDetail;

public interface ReviewDetailService {
	ReviewDetail findReviewDetail(String reviewId);
	void incrementLikesCount(String reviewId);
	void incrementScrapsCount(String reviewId);
	void decrementLikesCount(String reviewId);
	void decrementScrapsCount(String reviewId);
}
