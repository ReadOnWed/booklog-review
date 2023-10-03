package com.booklog.review.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booklog.review.search.dto.Review;
import com.booklog.review.search.repository.MongoRepositoryReviewSearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewTitleSearchServiceImpl implements ReviewSearchService{
	private final MongoRepositoryReviewSearchRepository reviewSearchRepository;
	@Override
	public List<Review> findReviewsByTerm(String keyword) {
		return Review.listOf(reviewSearchRepository.findReviewEntitiesByReviewTitleRegex(
			keyword.replace("(", "\\(").replace(")", "\\)")
		));
	}
}
