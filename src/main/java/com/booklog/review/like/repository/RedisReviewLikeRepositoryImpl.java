package com.booklog.review.like.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.booklog.review.like.entity.ReviewLikeEvent;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RedisReviewLikeRepositoryImpl implements RedisReviewLikeRepository {
	private final RedisTemplate<String, Object> redisTemplate;
	private static final String KEY = "like:review:";
	@Override
	public boolean isLikedForReviewByUserId(String reviewId, String userId) {
		return redisTemplate.opsForHash().hasKey(KEY + reviewId, userId);
	}

	@Override
	public void postLikeByReviewId(ReviewLikeEvent reviewLikeEvent) {
		redisTemplate.opsForHash().put(
			KEY + reviewLikeEvent.getReviewId(),	// redis key
			reviewLikeEvent.getUserId(), 				// hash key
			reviewLikeEvent.getLikedAt()				// hash value
		);
	}

	@Override
	public void deleteLikeByReviewIdAndUserId(String reviewId, String userId) {
		redisTemplate.opsForHash().delete(
			KEY + reviewId,	// redis key
			userId					// hash key
		);
	}

	@Override
	public long countLikesByReviewId(String reviewId) {
		return redisTemplate.opsForHash().size(KEY + reviewId);
	}
}
