package com.booklog.review.detail.service;

import com.booklog.review.comment.service.ReviewCommentService;
import org.springframework.stereotype.Service;

import com.booklog.review.detail.dto.ReviewDetail;
import com.booklog.review.detail.repository.ReviewDetailRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewDetailServiceImpl implements ReviewDetailService{
	private final ReviewDetailRepository reviewDetailRepository;
	private final ReviewCommentService reviewCommentService;

	@Override
	public ReviewDetail findReviewDetail(String reviewId) {
		return ReviewDetail.of(reviewDetailRepository.findById(reviewId)
						.orElseThrow(() -> new RuntimeException("not find review detail by : " + reviewId)))
				.findComments(reviewCommentService.getCommentsByReview(reviewId))
				.countComments();
	}
}
