package com.booklog.review.views.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.booklog.review.views.entity.ReviewDetailEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoTemplateViewsCountRepositoryImpl implements MongoTemplateViewsCountRepository{
	private final MongoTemplate mongoTemplate;
	@Override
	public void incrementViewsCountByReviewId(String reviewId) {
		Query query = new Query(Criteria.where("_id").is(reviewId));
		Update update = new Update().inc("viewsCount", 1);
		mongoTemplate.updateFirst(query, update, ReviewDetailEntity.class);
	}
}
