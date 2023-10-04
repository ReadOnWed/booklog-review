package com.booklog.review.detail.service;

import org.springframework.stereotype.Service;

import com.booklog.review.detail.dto.ReviewDetail;
import com.booklog.review.detail.repository.ReviewDetailRepository;
import com.booklog.review.like.service.ReviewLikeService;
import com.booklog.review.scrap.service.ReviewScrapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewDetailServiceImpl implements ReviewDetailService{
	private final ReviewDetailRepository reviewDetailRepository;
	private final ReviewLikeService reviewLikeService;
	private final ReviewScrapService reviewScrapService;

	@Override
	public ReviewDetail findReviewDetail(String reviewId) {
		return ReviewDetail.of(reviewDetailRepository.findById(reviewId)
			.orElseThrow(() -> new RuntimeException("not find review detail by : " + reviewId)))
			.countLikes(reviewLikeService.countLikes(reviewId))
			.countScraps(reviewScrapService.countScraps(reviewId));
	}
}
