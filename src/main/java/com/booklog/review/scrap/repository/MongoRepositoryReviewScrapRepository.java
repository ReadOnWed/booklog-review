package com.booklog.review.scrap.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklog.review.scrap.entity.ReviewScrapEvent;

public interface MongoRepositoryReviewScrapRepository extends MongoRepository<ReviewScrapEvent, String> {
	long countReviewScrapEventsByReviewId(String reviewId);
	Optional<ReviewScrapEvent> findReviewScrapEventByReviewIdAndUserId(String reviewId, String userId);
}
