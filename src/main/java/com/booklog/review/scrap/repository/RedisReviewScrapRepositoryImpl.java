package com.booklog.review.scrap.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.booklog.review.scrap.entity.ReviewScrapEvent;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RedisReviewScrapRepositoryImpl implements RedisReviewScrapRepository {
	private final RedisTemplate<String, Object> redisTemplate;
	private static final String KEY = "scrap:review:";
	@Override
	public boolean isScrappedForReviewByUserId(String reviewId, String userId) {
		return redisTemplate.opsForHash().hasKey(KEY + reviewId, userId);
	}

	@Override
	public void postScrapByReviewId(ReviewScrapEvent reviewScrapEvent) {
		redisTemplate.opsForHash().put(
			KEY + reviewScrapEvent.getReviewId(),	// redis key
			reviewScrapEvent.getUserId(), 				// hash key
			reviewScrapEvent.getScrapedAt()				// hash value
		);
	}

	@Override
	public void deleteScrapByReviewIdAndUserId(String reviewId, String userId) {
		redisTemplate.opsForHash().delete(
			KEY + reviewId,	// redis key
			userId					// hash key
		);
	}

	@Override
	public long countScrapsByReviewId(String reviewId) {
		return redisTemplate.opsForHash().size(KEY + reviewId);
	}
}
