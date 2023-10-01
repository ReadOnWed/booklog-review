package com.booklog.review.detail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booklog.review.detail.entity.ReviewDetailEntity;

@Repository
public interface ReviewDetailRepository extends MongoRepository<ReviewDetailEntity, String> {
}
