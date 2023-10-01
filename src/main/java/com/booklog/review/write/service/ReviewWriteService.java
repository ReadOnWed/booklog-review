package com.booklog.review.write.service;

import com.booklog.review.write.dto.Review;

import reactor.core.publisher.Mono;

public interface ReviewWriteService {
	Mono<String> postReview(Review review);
}
