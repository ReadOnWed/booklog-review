package com.booklog.review.edit.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.edit.dto.EditedReview;
import com.booklog.review.edit.dto.ReviewEditRequestDto;
import com.booklog.review.edit.dto.ReviewEditResponseDto;
import com.booklog.review.edit.service.ReviewEditService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/reviews")
@Slf4j
@RequiredArgsConstructor
public class ReviewEditController {
	private final ReviewEditService reviewEditService;

	@PostMapping("/edit")
	public ReviewEditResponseDto editReview(@RequestBody ReviewEditRequestDto reviewEditRequestDto){
		return ReviewEditResponseDto.of(reviewEditService.editReview(EditedReview.of(reviewEditRequestDto)));
	}
}
