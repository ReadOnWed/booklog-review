package com.booklog.review.like.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklog.review.like.entity.ReviewLikeEvent;

public interface MongoRepositoryReviewLikeRepository extends MongoRepository<ReviewLikeEvent, String> {
	long countReviewLikeEventsByReviewId(String reviewId);
	Optional<ReviewLikeEvent> findReviewLikeEventByReviewIdAndUserId(String reviewId, String userId);
}
