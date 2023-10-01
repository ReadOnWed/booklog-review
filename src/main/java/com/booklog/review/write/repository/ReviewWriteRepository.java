package com.booklog.review.write.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.booklog.review.write.entity.ReviewEntity;

public interface ReviewWriteRepository extends ReactiveMongoRepository<ReviewEntity, String> {
}
