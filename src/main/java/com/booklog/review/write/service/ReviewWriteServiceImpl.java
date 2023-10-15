package com.booklog.review.write.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.booklog.review.config.EnvironmentConfig;
import com.booklog.review.write.dto.Book;
import com.booklog.review.write.dto.Review;
import com.booklog.review.write.entity.ReviewEntity;
import com.booklog.review.write.repository.ReviewWriteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewWriteServiceImpl implements ReviewWriteService {
	private final WebClient webClient;
	private final ReviewWriteRepository reviewWriteRepository;
	private static final String BOOK_API_HOST = EnvironmentConfig.getBookApiHost();
	private static final String SEARCH_BOOK_INFO = "/v1/books/search/book-id";
	private static final String POST_REVIEW_INFO = "/v1/books/details/review";

	@Override
	public Mono<String> postReview(Review review) {
		// fetchBook() : 도서 정보를 가져오고 그 결과를 리뷰와 함께 DB에 비동기로 적재
		return fetchBook(review.getBookId())
			// flatMap() : 각 항목(= book)을 가져와서 새로운 스트림(= reviewEntity)으로 변환 및 작업 처리
			.flatMap(book -> reviewWriteRepository.save(ReviewEntity.of(review, book)))
			// map() : DB 적재 후 save() 메서드가 반환해주는 객체에서 id 값을 추출 및 controller 클래스로 반환
			.doOnNext(this::postReview)
			.map(ReviewEntity::getId)
			.doOnNext(savedReviewId -> log.info("post review successfully, review Id : " + savedReviewId)) 		// 로깅
			.onErrorMap(error -> new RuntimeException("post review error occurred : " + error.getMessage())); 	// 예외처리
	}

	private Mono<Book> fetchBook(String bookId) {
		/*
		 * Webclient 인스턴스는 Mono(0개 혹은 1개의 객체) 혹은 Flux(stream 객체)를 반환
		 * Webclient 인스턴스가 반환하는 두 가지 유형의 객체는 콜드스트림이므로 실제 데이터 처리는 subscribe() 메서드가 호출될때 시작된다.
		 * 	지금과 같이 Service 클래스에서 Mono<String>을 반환하고 Controller 클래스에서 반환해주는 형식이라면,
		 * 	Spring Webflux가 자동으로 subscribe() 메서드를 처리한다.
 		 */
		return webClient.mutate()
			.build()
			.get()
			.uri(String.valueOf(new StringBuilder(BOOK_API_HOST)
				.append(SEARCH_BOOK_INFO)
				.append("?bookId=")
				.append(bookId)))
			.retrieve()
			.bodyToMono(Book.class)
			.retry(3)
			.onErrorReturn(new Book());
	}

	private void postReview(ReviewEntity reviewEntity){
		webClient.mutate()
			.build()
			.post()
			.uri(String.valueOf(new StringBuilder(BOOK_API_HOST)
				.append(POST_REVIEW_INFO)))
			.bodyValue(reviewEntity)
			.retrieve()
			.bodyToMono(ReviewEntity.class)
			.retry(3)
			.doOnNext(result -> log.info(
				"post review : " + reviewEntity.getId() + " info to book : " + reviewEntity.getBook().getId()))
			.subscribe(); // 실제 api 요청 발행
	}

}
