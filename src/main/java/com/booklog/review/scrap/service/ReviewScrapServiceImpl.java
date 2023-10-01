package com.booklog.review.scrap.service;

import org.springframework.stereotype.Service;

import com.booklog.review.scrap.dto.UserReviewScrap;
import com.booklog.review.scrap.dto.UserReviewScrapEvent;
import com.booklog.review.scrap.repository.ReviewScrapRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewScrapServiceImpl implements ReviewScrapService {
	private final ReviewScrapRepository reviewScrapRepository;
	@Override
	public boolean isScrapped(UserReviewScrap userReviewScrap) {
		return reviewScrapRepository.isScrappedByUserId(userReviewScrap.getReviewId(), userReviewScrap.getUserId());
	}

	@Override
	public long scrapReview(UserReviewScrap userReviewScrap) {
		if(isScrapped(userReviewScrap)){
			return reviewScrapRepository.getScrapsCountByReviewId(userReviewScrap.getReviewId());
		}
		reviewScrapRepository.putScrapForReview(UserReviewScrapEvent.of(userReviewScrap));
		return reviewScrapRepository.getScrapsCountByReviewId(userReviewScrap.getReviewId());
	}

	@Override
	public long unScrapReview(UserReviewScrap userReviewScrap) {
		reviewScrapRepository.deleteScrapForReviewByUserId(userReviewScrap.getReviewId(), userReviewScrap.getUserId());
		return reviewScrapRepository.getScrapsCountByReviewId(userReviewScrap.getReviewId());
	}

	@Override
	public long countScraps(String reviewId) {
		return reviewScrapRepository.getScrapsCountByReviewId(reviewId);
	}
}
