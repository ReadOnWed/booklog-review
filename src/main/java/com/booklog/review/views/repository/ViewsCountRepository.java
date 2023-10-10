package com.booklog.review.views.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklog.review.views.entity.ViewsCountEvent;

public interface ViewsCountRepository extends MongoRepository<ViewsCountEvent, String>, MongoTemplateViewsCountRepository {
	long countViewsCountEventsByReviewId(String reviewId);
}
