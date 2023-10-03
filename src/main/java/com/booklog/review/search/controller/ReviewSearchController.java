package com.booklog.review.search.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.search.common.SearchTermEnum;
import com.booklog.review.search.dto.Review;
import com.booklog.review.search.service.facade.ReviewSearchFacadeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/reviews/search")
public class ReviewSearchController {
	private final ReviewSearchFacadeService reviewSearchFacadeService;
	@GetMapping("/review-title")
	public List<Review> reviewSearchByReviewTitle(@RequestParam String searchKeyword) {
		log.info("search reviews by review title : {}", searchKeyword);
		return reviewSearchFacadeService.findReviewsByTerm(SearchTermEnum.REVIEW_TITLE, searchKeyword);
	}

	@GetMapping("/review-content")
	public List<Review> reviewSearchByReviewContent(@RequestParam String searchKeyword) {
		log.info("search reviews by review content : {}", searchKeyword);
		return reviewSearchFacadeService.findReviewsByTerm(SearchTermEnum.REVIEW_CONTENT, searchKeyword);
	}

	@GetMapping("/book-title")
	public List<Review> reviewSearchByBookTitle(@RequestParam String bookTitle) {
		log.info("search reviews by book title : {}", bookTitle);
		return reviewSearchFacadeService.findReviewsByTerm(SearchTermEnum.BOOK_TITLE, bookTitle);

	}

	@GetMapping("/review-writer")
	public List<Review> reviewSearchByReviewWriter(@RequestParam String reviewWriter) {
		log.info("search reviews by review writer : {}", reviewWriter);
		return reviewSearchFacadeService.findReviewsByTerm(SearchTermEnum.REVIEW_WRITER, reviewWriter);
	}

	@GetMapping("/user-id")
	public List<Review> reviewSearchByUserId(@RequestParam String userId) {
		log.info("search reviews by user id : {}", userId);
		return reviewSearchFacadeService.findReviewsByTerm(SearchTermEnum.USER_ID, userId);
	}

	@GetMapping("/book-id")
	public List<Review> reviewSearchByBookId(@RequestParam String bookId) {
		log.info("search reviews by book id : {}", bookId);
		return reviewSearchFacadeService.findReviewsByTerm(SearchTermEnum.BOOK_ID, bookId);
	}
}
