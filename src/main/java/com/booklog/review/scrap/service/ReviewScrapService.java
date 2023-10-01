package com.booklog.review.scrap.service;

import com.booklog.review.scrap.dto.UserReviewScrap;

public interface ReviewScrapService {
	boolean isScrapped(UserReviewScrap userReviewScrap);
	long scrapReview(UserReviewScrap userReviewScrap);
	long unScrapReview(UserReviewScrap userReviewScrap);
	long countScraps(String reviewId);
}
