package com.booklog.review.recommended.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklog.review.recommended.entity.ReviewEntity;

public interface ReviewRecommendedRepository extends MongoRepository<ReviewEntity, String>, MongoTemplateReviewRecommendedRepository {
	ReviewEntity findReviewEntitiesById(String reviewId);
}
