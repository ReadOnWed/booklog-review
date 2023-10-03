package com.booklog.review.search.service;

import java.util.List;

import com.booklog.review.search.dto.Review;

public interface ReviewSearchService {
	List<Review> findReviewsByTerm(String keyword);
}
