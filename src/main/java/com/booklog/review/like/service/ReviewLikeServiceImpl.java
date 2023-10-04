package com.booklog.review.like.service;

import org.springframework.stereotype.Service;

import com.booklog.review.like.dto.UserReviewLike;
import com.booklog.review.like.dto.UserReviewLikeEvent;
import com.booklog.review.like.repository.ReviewLikeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewLikeServiceImpl implements ReviewLikeService{
	private final ReviewLikeRepository reviewLikeRepository;
	@Override
	public boolean isLiked(UserReviewLike userReviewLike) {
		return reviewLikeRepository.isLikedByUserId(userReviewLike.getReviewId(), userReviewLike.getUserId());
	}

	@Override
	public long likeReview(UserReviewLike userReviewLike) {
		if(isLiked(userReviewLike)){
			return reviewLikeRepository.getLikesCountByReviewId(userReviewLike.getReviewId());
		}
		reviewLikeRepository.putLikeForReview(UserReviewLikeEvent.of(userReviewLike));
		return reviewLikeRepository.getLikesCountByReviewId(userReviewLike.getReviewId());
	}

	@Override
	public long unLikeReview(UserReviewLike userReviewLike) {
		reviewLikeRepository.deleteLikeForReviewByUserId(userReviewLike.getReviewId(), userReviewLike.getUserId());
		return reviewLikeRepository.getLikesCountByReviewId(userReviewLike.getReviewId());
	}

	@Override
	public long countLikes(String reviewId) {
		return reviewLikeRepository.getLikesCountByReviewId(reviewId);
	}
}
