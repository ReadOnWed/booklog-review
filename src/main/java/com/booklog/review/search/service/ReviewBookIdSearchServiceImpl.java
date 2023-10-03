package com.booklog.review.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booklog.review.search.dto.Review;
import com.booklog.review.search.repository.MongoRepositoryReviewSearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewBookIdSearchServiceImpl implements ReviewSearchService{
	private final MongoRepositoryReviewSearchRepository reviewSearchRepository;
	@Override
	public List<Review> findReviewsByTerm(String bookId) {
		return Review.listOf(reviewSearchRepository.findReviewEntitiesByBook__id(bookId));
	}
}
