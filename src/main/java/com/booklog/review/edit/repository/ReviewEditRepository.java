package com.booklog.review.edit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklog.review.edit.entity.ReviewEntity;

public interface ReviewEditRepository extends MongoRepository<ReviewEntity, String>, MongoTemplateReviewEditRepository {
	ReviewEntity findReviewEntityById(String reviewId);
}
