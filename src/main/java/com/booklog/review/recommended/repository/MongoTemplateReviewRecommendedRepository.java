package com.booklog.review.recommended.repository;

import java.util.List;

public interface MongoTemplateReviewRecommendedRepository {
	List<String> findWeeklyTopLikedReviewIds();
}
