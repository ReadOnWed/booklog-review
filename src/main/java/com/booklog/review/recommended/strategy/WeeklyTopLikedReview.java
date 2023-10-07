package com.booklog.review.recommended.strategy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.booklog.review.recommended.repository.ReviewRecommendedRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WeeklyTopLikedReview implements ReviewRecommendedStrategy{
	private final ReviewRecommendedRepository reviewRecommendedRepository;
	@Override
	public List<String> findRecommendedReviewIds() {
		// 일주일간 좋아요가 가장 많이 눌린 상위 리뷰 5개의 id 반환
		return reviewRecommendedRepository.findWeeklyTopLikedReviewIds();
	}
}
