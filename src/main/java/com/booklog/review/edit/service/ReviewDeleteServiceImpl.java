package com.booklog.review.edit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.booklog.review.config.EnvironmentConfig;
import com.booklog.review.edit.entity.ReviewEntity;
import com.booklog.review.edit.repository.ReviewEditRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewDeleteServiceImpl implements ReviewDeleteService {
	private final ReviewEditRepository reviewEditRepository;
	private final WebClient webClient;
	private static final String BOOK_API_HOST = EnvironmentConfig.getBookApiHost();
	private static final String DELETE_REVIEW_INFO = "/v1/books/details/review";

	@Override
	public long deleteReview(String reviewId) {
		String bookId = reviewEditRepository.findReviewEntityById(reviewId).getBook().getId();
		requestDeleteReview(reviewId, bookId);
		return reviewEditRepository.deleteByIdAndDeleteCount(reviewId);
	}

	private void requestDeleteReview(String reviewId, String bookId){
		webClient.mutate()
			.build()
			.delete()
			.uri(String.valueOf(new StringBuilder(BOOK_API_HOST)
				.append(DELETE_REVIEW_INFO)
				.append("?reviewId=")
				.append(reviewId)
				.append("&bookId=")
				.append(bookId)))
			.retrieve()
			.bodyToMono(ReviewEntity.class)
			.retry(3)
			.doOnNext(result -> log.info(
				"delete review : " + reviewId))
			.subscribe(); // 실제 api 요청 발행
	}
}
