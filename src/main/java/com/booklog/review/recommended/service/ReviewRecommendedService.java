package com.booklog.review.recommended.service;

import java.util.List;

import com.booklog.review.recommended.dto.ReviewInfo;

public interface ReviewRecommendedService {
	List<ReviewInfo> findRecommendedReview();
}
