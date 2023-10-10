package com.booklog.review.like.service;

import com.booklog.review.like.dto.ReviewLike;

public interface ReviewLikeService {
	boolean isLiked(String reviewId, String userId);

	long likeForReview(ReviewLike reviewLike);

	long unlikeForReview(ReviewLike reviewLike);
}
