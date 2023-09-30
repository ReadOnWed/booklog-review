package com.booklog.review.detail.service;

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
	@Override
	public ReviewDetail findReviewDetail(String reviewId) {
		return ReviewDetail.of(reviewDetailRepository.findById(reviewId)
			.orElseThrow(() -> new RuntimeException("not find review detail by : " + reviewId)));
	}
}
