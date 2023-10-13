package com.booklog.review.edit.repository;

import com.booklog.review.edit.entity.ReviewEntity;

public interface MongoTemplateReviewEditRepository {
	ReviewEntity findAndModify(ReviewEntity reviewEntity);
	long deleteByIdAndDeleteCount(String reviewId);
}
