package com.booklog.review.edit.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.booklog.review.edit.entity.ReviewEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoTemplateReviewEditRepositoryImpl implements MongoTemplateReviewEditRepository {
	private final MongoTemplate mongoTemplate;

	@Override
	public ReviewEntity findAndModify(ReviewEntity reviewEntity) {
		Query query = new Query(Criteria.where("_id").is(reviewEntity.getId()));
		Update update = new Update()
			.set("reviewTitle", reviewEntity.getReviewTitle())
			.set("reviewContent", reviewEntity.getReviewContent())
			.set("rating", reviewEntity.getRating())
			.set("readStartAt", reviewEntity.getReadStartAt())
			.set("readEndAt", reviewEntity.getReadEndAt())
			.set("updatedAt", reviewEntity.getUpdatedAt());

		return mongoTemplate.findAndModify(query, update, ReviewEntity.class);
	}

	@Override
	public long deleteByIdAndDeleteCount(String reviewId) {
		Query query = new Query(Criteria.where("_id").is(reviewId));
		return mongoTemplate.remove(query, ReviewEntity.class).getDeletedCount();
	}
}
