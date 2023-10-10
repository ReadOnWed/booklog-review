package com.booklog.review.views.repository;

public interface MongoTemplateViewsCountRepository {
	void incrementViewsCountByReviewId(String reviewId);
	
}
