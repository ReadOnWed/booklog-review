package com.booklog.review.like.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.like.dto.IsLikedReviewResponseDto;
import com.booklog.review.like.dto.ReviewLike;
import com.booklog.review.like.dto.ReviewLikeRequestDto;
import com.booklog.review.like.dto.ReviewLikeResponseDto;
import com.booklog.review.like.service.ReviewLikeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/reviews/")
public class ReviewLikeController {
	private final ReviewLikeService reviewLikeService;
	@GetMapping("/is-liked")
	public IsLikedReviewResponseDto isLiked(@RequestParam String reviewId, @RequestParam String userId) {
		log.info("is like for review {}, by user : {}", reviewId, userId);
		return IsLikedReviewResponseDto.of(reviewLikeService.isLiked(reviewId, userId));
	}

	@PostMapping("/like")
	public ReviewLikeResponseDto likeReview(@RequestBody ReviewLikeRequestDto reviewLikeRequestDto) {
		log.info("post like for review {}, by user : {}", reviewLikeRequestDto.getReviewId(), reviewLikeRequestDto.getUserId());
		return ReviewLikeResponseDto.of(reviewLikeService.likeForReview(ReviewLike.of(reviewLikeRequestDto)));
	}

	@PostMapping("/unlike")
	public ReviewLikeResponseDto unLikeReview(@RequestBody ReviewLikeRequestDto reviewLikeRequestDto) {
		log.info("delete like for review {}, by user : {}", reviewLikeRequestDto.getReviewId(), reviewLikeRequestDto.getUserId());
		return ReviewLikeResponseDto.of(reviewLikeService.unlikeForReview(ReviewLike.of(reviewLikeRequestDto)));
	}

}