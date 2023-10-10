package com.booklog.review.scrap.service;

import com.booklog.review.scrap.dto.ReviewScrap;

public interface ReviewScrapService {
	boolean isScrapped(String reviewId, String userId);

	long scrapForReview(ReviewScrap reviewScrap);

	long unscrapForReview(ReviewScrap reviewScrap);
}
