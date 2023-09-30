package com.booklog.review.write.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.write.dto.Review;
import com.booklog.review.write.dto.ReviewWriteRequestDto;
import com.booklog.review.write.dto.ReviewWriteResponseDto;
import com.booklog.review.write.service.ReviewWriteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/reviews")
@Slf4j
@RequiredArgsConstructor
public class ReviewWriteController {
	private final ReviewWriteService reviewWriteService;
	@PostMapping("/write")
	public Mono<ResponseEntity<ReviewWriteResponseDto>> writeReview(@RequestBody ReviewWriteRequestDto reviewWriteRequestDto){
		log.info("posting review For BookId {} By userId : {}"
			, reviewWriteRequestDto.getBookId(), reviewWriteRequestDto.getUserId());

		return reviewWriteService.postReview(Review.of(reviewWriteRequestDto))
			.map(ReviewWriteResponseDto::of)
			.map(ResponseEntity::ok);
	}
}
