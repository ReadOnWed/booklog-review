package com.booklog.review.search.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.booklog.review.search.entity.ReviewEntity;
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
		return Review.listOf(reviewSearchRepository.findReviewEntitiesByBook__id(bookId).stream()
				.sorted(Comparator.comparing(ReviewEntity::getUpdatedAt).reversed())
				.collect(Collectors.toList()));
	}
}
