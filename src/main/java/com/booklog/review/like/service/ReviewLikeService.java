package com.booklog.review.like.service;

import com.booklog.review.like.dto.UserReviewLike;

public interface ReviewLikeService {
	boolean isLiked(UserReviewLike reviewLike);
	long likeReview(UserReviewLike reviewLike);
	long unLikeReview(UserReviewLike reviewLike);
	long countLikes(String reviewId);
}
