package com.booklog.review.detail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.detail.dto.ReviewDetail;
import com.booklog.review.detail.service.ReviewDetailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/reviews/")
public class ReviewDetailController {
	private final ReviewDetailService reviewDetailService;
	@GetMapping("/details")
	public ReviewDetail findReviewDetail(@RequestParam String reviewId) {
		log.info("fetching review detail by review : {}", reviewId);
		return reviewDetailService.findReviewDetail(reviewId);
	}
}
