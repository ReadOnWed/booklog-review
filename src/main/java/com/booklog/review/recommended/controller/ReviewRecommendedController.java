package com.booklog.review.recommended.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.recommended.dto.ReviewInfo;
import com.booklog.review.recommended.service.ReviewRecommendedService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reviews")
@Slf4j
public class ReviewRecommendedController {
	private final ReviewRecommendedService reviewRecommendedService;
	@GetMapping("/recommended")
	public List<ReviewInfo> fetchRecommendedReview(){
		log.info("fetching recommended review ...");
		return reviewRecommendedService.findRecommendedReview();
	}
}
