package com.booklog.review.edit.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.edit.dto.ReviewDeleteRequestDto;
import com.booklog.review.edit.dto.ReviewDeleteResponseDto;
import com.booklog.review.edit.service.ReviewDeleteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/v1/reviews")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ReviewDeleteController {
	private final ReviewDeleteService reviewDeleteService;

	@PostMapping(value = "/delete")
	public ReviewDeleteResponseDto deleteReview(@RequestBody ReviewDeleteRequestDto reviewDeleteRequestDto){
		log.info("delete review : {}", reviewDeleteRequestDto.getReviewId());
		return ReviewDeleteResponseDto.of(reviewDeleteService.deleteReview(reviewDeleteRequestDto.getReviewId()));
	}

}