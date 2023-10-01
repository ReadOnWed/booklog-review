package com.booklog.review.like.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.like.dto.ReviewIsLikedResponseDto;
import com.booklog.review.like.dto.ReviewLikeRequestDto;
import com.booklog.review.like.dto.ReviewLikeResponseDto;
import com.booklog.review.like.dto.UserReviewLike;
import com.booklog.review.like.service.ReviewLikeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/v1/reviews")
@RequiredArgsConstructor
@Slf4j
@RestController
public class ReviewLikeController {
	private final ReviewLikeService reviewLikeService;
	@GetMapping("/is-liked")
	public ReviewIsLikedResponseDto isLiked(@RequestParam String userId, @RequestParam String reviewId){
		log.info("is liked review {}, by user : {} ?", reviewId, userId);
		return ReviewIsLikedResponseDto.of(reviewLikeService.isLiked(UserReviewLike.of(userId, reviewId)));
	}

	@PostMapping(value = "/like")
	public ReviewLikeResponseDto likeReview(@RequestBody ReviewLikeRequestDto reviewLikeRequestDto){
		log.info("like review : {}, by user : {}", reviewLikeRequestDto.getReviewId(), reviewLikeRequestDto.getUserId());
		return ReviewLikeResponseDto.of(reviewLikeService.likeReview(UserReviewLike.of(reviewLikeRequestDto)));
	}

	@PostMapping(value = "/unlike")
	public ReviewLikeResponseDto unLikeReview(@RequestBody ReviewLikeRequestDto reviewLikeRequestDto){
		log.info("unlike review : {}, by user : {}", reviewLikeRequestDto.getReviewId(), reviewLikeRequestDto.getUserId());
		return ReviewLikeResponseDto.of(reviewLikeService.unLikeReview(UserReviewLike.of(reviewLikeRequestDto)));

	}
}
