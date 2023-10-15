package com.booklog.review.edit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.booklog.review.config.EnvironmentConfig;
import com.booklog.review.edit.dto.EditedReview;
import com.booklog.review.edit.entity.ReviewEntity;
import com.booklog.review.edit.repository.ReviewEditRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewEditServiceImpl implements ReviewEditService{
	private final ReviewEditRepository reviewEditRepository;
	private final WebClient webClient;
	private static final String BOOK_API_HOST = EnvironmentConfig.getBookApiHost();
	private static final String PUT_REVIEW_INFO = "/v1/books/details/review";

	@Override
	public String editReview(EditedReview editedReview) {
		reviewEditRepository.findAndModify(ReviewEntity.of(editedReview));
		ReviewEntity reviewEntity = reviewEditRepository.findReviewEntityById(editedReview.getId());
		putEditedReview(reviewEntity);

		return reviewEntity.getId();
	}

	private void putEditedReview(ReviewEntity reviewEntity){
		webClient.mutate()
			.build()
			.put()
			.uri(String.valueOf(new StringBuilder(BOOK_API_HOST)
				.append(PUT_REVIEW_INFO)))
			.bodyValue(reviewEntity)
			.retrieve()
			.bodyToMono(ReviewEntity.class)
			.retry(3)
			.doOnNext(result -> log.info(
				"post edited review : " + reviewEntity.getId()))
			.subscribe(); // 실제 api 요청 발행
	}

}
