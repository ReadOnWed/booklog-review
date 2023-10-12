package com.booklog.review.recommended.service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.booklog.review.recommended.entity.ReviewEntity;
import org.springframework.stereotype.Service;

import com.booklog.review.recommended.dto.ReviewInfo;
import com.booklog.review.recommended.repository.ReviewRecommendedRepository;
import com.booklog.review.recommended.strategy.ReviewRecommendedStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewRecommendedServiceImpl implements ReviewRecommendedService{
	private final ReviewRecommendedStrategy reviewRecommendedStrategy;
	private final ReviewRecommendedRepository reviewRecommendedRepository;

	@Override
	public List<ReviewInfo> findRecommendedReview() {
		return ReviewInfo.listOf(reviewRecommendedStrategy.findRecommendedReviewIds()
				.stream()
				.map(reviewRecommendedRepository::findReviewEntitiesById)
				.filter(Objects::nonNull)
				.sorted(Comparator.comparing(ReviewEntity::getLikesCount)
						.thenComparing(ReviewEntity::getCreatedAt))
				.collect(Collectors.toList()));
	}
}
