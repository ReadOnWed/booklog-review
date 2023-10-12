package com.booklog.review.detail.service;

import com.booklog.review.detail.entity.ReviewDetailEntity;
import com.booklog.review.detail.repository.ReviewDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewDetailUpdateServiceImpl implements ReviewDetailUpdateService{
	private final ReviewDetailRepository reviewDetailRepository;

	@Override
	public void incrementLikesCount(String reviewId) {
		reviewDetailRepository.incrementLikesCountByReviewId(reviewId);
	}

	@Override
	public void incrementScrapsCount(String reviewId) {
		reviewDetailRepository.incrementScrapsCountByReviewId(reviewId);
	}

	@Override
	public void decrementLikesCount(String reviewId) {
		reviewDetailRepository.decrementLikesCountByReviewId(reviewId);
	}

	@Override
	public void decrementScrapsCount(String reviewId) {
		reviewDetailRepository.decrementScrapsCountByReviewId(reviewId);
	}

	@Override
	public void updateCommentCount(String reviewId, long count) {
		ReviewDetailEntity reviewDetailEntity = reviewDetailRepository.findReviewDetailEntityById(reviewId)
				.orElseThrow(() -> new IllegalArgumentException("illegal review id : " + reviewId + " for count comment"));

		reviewDetailRepository.save(reviewDetailEntity.incrementCommentCount(count));
	}
}
