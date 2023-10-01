package com.booklog.review.edit.repository;

import com.booklog.review.edit.entity.ReviewEntity;

public interface ReviewEditRepository{
	ReviewEntity findAndModify(ReviewEntity reviewEntity);
	long deleteById(String reviewId);
}
