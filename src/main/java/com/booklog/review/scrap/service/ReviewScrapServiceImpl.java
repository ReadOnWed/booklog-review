package com.booklog.review.scrap.service;

import java.util.concurrent.atomic.AtomicBoolean;

import com.booklog.review.detail.service.ReviewDetailUpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booklog.review.scrap.dto.ReviewScrap;
import com.booklog.review.scrap.entity.ReviewScrapEvent;
import com.booklog.review.scrap.repository.MongoRepositoryReviewScrapRepository;
import com.booklog.review.scrap.repository.RedisReviewScrapRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewScrapServiceImpl implements ReviewScrapService {
	private final RedisReviewScrapRepository redisReviewScrapRepository;
	private final MongoRepositoryReviewScrapRepository mongoReviewScrapRepository;
	private final ReviewDetailUpdateService reviewDetailUpdateService;

	@Override
	public boolean isScrapped(String reviewId, String userId) {
		AtomicBoolean isLiked = new AtomicBoolean(false);

		if(redisReviewScrapRepository.isScrappedForReviewByUserId(reviewId, userId)){
			return true;
		}

		mongoReviewScrapRepository.findReviewScrapEventByReviewIdAndUserId(reviewId, userId)
			.ifPresent(reviewLikeEvent -> {
				redisReviewScrapRepository.postScrapByReviewId(reviewLikeEvent);
				isLiked.set(true);
			});

		return isLiked.get();
	}

	@Override
	public long scrapForReview(ReviewScrap reviewScrap) {
		if(isScrapped(reviewScrap.getReviewId(), reviewScrap.getUserId())){
			return redisReviewScrapRepository.countScrapsByReviewId(reviewScrap.getReviewId());
		}

		ReviewScrapEvent reviewScrapEvent = ReviewScrapEvent.of(reviewScrap);
		redisReviewScrapRepository.postScrapByReviewId(reviewScrapEvent);
		mongoReviewScrapRepository.save(reviewScrapEvent);
		reviewDetailUpdateService.incrementScrapsCount(reviewScrapEvent.getReviewId());

		return mongoReviewScrapRepository.countReviewScrapEventsByReviewId(reviewScrapEvent.getReviewId());
	}

	@Override
	public long unscrapForReview(ReviewScrap reviewScrap) {
		mongoReviewScrapRepository.findReviewScrapEventByReviewIdAndUserId(reviewScrap.getReviewId(), reviewScrap.getUserId())
			.ifPresent(reviewLikeEvent -> {
				redisReviewScrapRepository.deleteScrapByReviewIdAndUserId(reviewScrap.getReviewId(), reviewScrap.getUserId());
				mongoReviewScrapRepository.deleteById(reviewLikeEvent.getId());
				reviewDetailUpdateService.decrementScrapsCount(reviewScrap.getReviewId());
			});

		return mongoReviewScrapRepository.countReviewScrapEventsByReviewId(reviewScrap.getReviewId());
	}
}
