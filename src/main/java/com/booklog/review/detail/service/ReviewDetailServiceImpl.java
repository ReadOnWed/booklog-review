package com.booklog.review.detail.service;

import org.springframework.stereotype.Service;

import com.booklog.review.detail.dto.ReviewDetail;
import com.booklog.review.detail.repository.MongoTemplateReviewDetailRepository;
import com.booklog.review.detail.repository.ReviewDetailRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewDetailServiceImpl implements ReviewDetailService{
	private final ReviewDetailRepository reviewDetailRepository;
	private final MongoTemplateReviewDetailRepository mongoTemplateReviewDetailRepository;

	@Override
	public ReviewDetail findReviewDetail(String reviewId) {
		return ReviewDetail.of(reviewDetailRepository.findById(reviewId)
			.orElseThrow(() -> new RuntimeException("not find review detail by : " + reviewId)));
	}

	@Override
	public void incrementLikesCount(String reviewId) {
		mongoTemplateReviewDetailRepository.incrementLikesCountByReviewId(reviewId);
	}

	@Override
	public void incrementScrapsCount(String reviewId) {
		mongoTemplateReviewDetailRepository.incrementScrapsCountByReviewId(reviewId);
	}

	@Override
	public void decrementLikesCount(String reviewId) {
		mongoTemplateReviewDetailRepository.decrementLikesCountByReviewId(reviewId);
	}

	@Override
	public void decrementScrapsCount(String reviewId) {
		mongoTemplateReviewDetailRepository.decrementScrapsCountByReviewId(reviewId);
	}
}
