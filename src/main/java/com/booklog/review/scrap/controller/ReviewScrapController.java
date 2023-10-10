package com.booklog.review.scrap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.scrap.dto.IsScrappedReviewResponseDto;
import com.booklog.review.scrap.dto.ReviewScrap;
import com.booklog.review.scrap.dto.ReviewScrapRequestDto;
import com.booklog.review.scrap.dto.ReviewScrapResponseDto;
import com.booklog.review.scrap.service.ReviewScrapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/reviews/")
public class ReviewScrapController {
	private final ReviewScrapService reviewScrapService;
	@GetMapping("/is-scrapped")
	public IsScrappedReviewResponseDto isScrapped(@RequestParam String reviewId, @RequestParam String userId) {
		log.info("is scrap for review {}, by user : {}", reviewId, userId);
		return IsScrappedReviewResponseDto.of(reviewScrapService.isScrapped(reviewId, userId));
	}

	@PostMapping("/scrap")
	public ReviewScrapResponseDto scrapReview(@RequestBody ReviewScrapRequestDto reviewScrapRequestDto) {
		log.info("post scrap for review {}, by user : {}", reviewScrapRequestDto.getReviewId(), reviewScrapRequestDto.getUserId());
		return ReviewScrapResponseDto.of(reviewScrapService.scrapForReview(ReviewScrap.of(reviewScrapRequestDto)));
	}

	@PostMapping("/unscrap")
	public ReviewScrapResponseDto unScrapReview(@RequestBody ReviewScrapRequestDto reviewScrapRequestDto) {
		log.info("delete scrap for review {}, by user : {}", reviewScrapRequestDto.getReviewId(), reviewScrapRequestDto.getUserId());
		return ReviewScrapResponseDto.of(reviewScrapService.unscrapForReview(ReviewScrap.of(reviewScrapRequestDto)));
	}

}