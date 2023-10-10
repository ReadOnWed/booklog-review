package com.booklog.review.detail.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.booklog.review.detail.entity.ReviewDetailEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoTemplateReviewDetailRepositoryImpl implements MongoTemplateReviewDetailRepository{
	private final MongoTemplate mongoTemplate;
	@Override
	public void incrementLikesCountByReviewId(String reviewId) {
		Query query = new Query(Criteria.where("_id").is(reviewId));
		Update update = new Update().inc("likesCount", 1);
		mongoTemplate.updateFirst(query, update, ReviewDetailEntity.class);
	}

	@Override
	public void incrementScrapsCountByReviewId(String reviewId) {
		Query query = new Query(Criteria.where("_id").is(reviewId));
		Update update = new Update().inc("scrapsCount", 1);
		mongoTemplate.updateFirst(query, update, ReviewDetailEntity.class);
	}

	@Override
	public void decrementLikesCountByReviewId(String reviewId) {
		Query query = new Query(Criteria.where("_id").is(reviewId));
		Update update = new Update().inc("likesCount", -1);
		mongoTemplate.updateFirst(query, update, ReviewDetailEntity.class);
	}

	@Override
	public void decrementScrapsCountByReviewId(String reviewId) {
		Query query = new Query(Criteria.where("_id").is(reviewId));
		Update update = new Update().inc("scrapsCount", -1);
		mongoTemplate.updateFirst(query, update, ReviewDetailEntity.class);
	}
}
