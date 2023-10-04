package com.booklog.review.scrap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.scrap.dto.ReviewIsScrappedResponseDto;
import com.booklog.review.scrap.dto.ReviewScrapRequestDto;
import com.booklog.review.scrap.dto.ReviewScrapResponseDto;
import com.booklog.review.scrap.dto.UserReviewScrap;
import com.booklog.review.scrap.service.ReviewScrapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/v1/reviews")
@RequiredArgsConstructor
@Slf4j
@RestController
public class ReviewScrapController {
	private final ReviewScrapService reviewScrapService;
	@GetMapping("/is-scrapped")
	public ReviewIsScrappedResponseDto isLiked(@RequestParam String userId, @RequestParam String reviewId){
		log.info("is scrapped review {}, by user : {} ?", reviewId, userId);
		return ReviewIsScrappedResponseDto.of(reviewScrapService.isScrapped(UserReviewScrap.of(userId, reviewId)));
	}

	@PostMapping(value = "/scrap")
	public ReviewScrapResponseDto scrapReview(@RequestBody ReviewScrapRequestDto reviewScrapRequestDto){
		log.info("scrap review : {}, by user : {}", reviewScrapRequestDto.getReviewId(), reviewScrapRequestDto.getUserId());
		return ReviewScrapResponseDto.of(reviewScrapService.scrapReview(UserReviewScrap.of(reviewScrapRequestDto)));
	}

	@PostMapping(value = "/unscrap")
	public ReviewScrapResponseDto unScrapReview(@RequestBody ReviewScrapRequestDto reviewScrapRequestDto){
		log.info("un scrap review : {}, by user : {}", reviewScrapRequestDto.getReviewId(), reviewScrapRequestDto.getUserId());
		return ReviewScrapResponseDto.of(reviewScrapService.unScrapReview(UserReviewScrap.of(reviewScrapRequestDto)));

	}
}
