package com.booklog.review.like.service;

import java.util.concurrent.atomic.AtomicBoolean;

import com.booklog.review.detail.service.ReviewDetailUpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booklog.review.like.dto.ReviewLike;
import com.booklog.review.like.entity.ReviewLikeEvent;
import com.booklog.review.like.repository.MongoRepositoryReviewLikeRepository;
import com.booklog.review.like.repository.RedisReviewLikeRepositoryImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewLikeServiceImpl implements ReviewLikeService{
	private final RedisReviewLikeRepositoryImpl redisReviewLikeRepository;
	private final MongoRepositoryReviewLikeRepository mongoReviewLikeRepository;
	private final ReviewDetailUpdateService reviewDetailUpdateService;

	@Override
	public boolean isLiked(String reviewId, String userId) {
		AtomicBoolean isLiked = new AtomicBoolean(false);

		if(redisReviewLikeRepository.isLikedForReviewByUserId(reviewId, userId)){
			return true;
		}

		mongoReviewLikeRepository.findReviewLikeEventByReviewIdAndUserId(reviewId, userId)
			.ifPresent(reviewLikeEvent -> {
				redisReviewLikeRepository.postLikeByReviewId(reviewLikeEvent);
				isLiked.set(true);
			});

		return isLiked.get();
	}

	@Override
	public long likeForReview(ReviewLike reviewLike) {
		if(isLiked(reviewLike.getReviewId(), reviewLike.getUserId())){
			return redisReviewLikeRepository.countLikesByReviewId(reviewLike.getReviewId());
		}

		ReviewLikeEvent reviewLikeEvent = ReviewLikeEvent.of(reviewLike);
		redisReviewLikeRepository.postLikeByReviewId(reviewLikeEvent);
		mongoReviewLikeRepository.save(reviewLikeEvent);
		reviewDetailUpdateService.incrementLikesCount(reviewLikeEvent.getReviewId());

		return mongoReviewLikeRepository.countReviewLikeEventsByReviewId(reviewLikeEvent.getReviewId());
	}

	@Override
	public long unlikeForReview(ReviewLike reviewLike) {
		mongoReviewLikeRepository.findReviewLikeEventByReviewIdAndUserId(reviewLike.getReviewId(), reviewLike.getUserId())
			.ifPresent(reviewLikeEvent -> {
				redisReviewLikeRepository.deleteLikeByReviewIdAndUserId(reviewLike.getReviewId(), reviewLike.getUserId());
				mongoReviewLikeRepository.deleteById(reviewLikeEvent.getId());
				reviewDetailUpdateService.decrementLikesCount(reviewLike.getReviewId());
			});

		return mongoReviewLikeRepository.countReviewLikeEventsByReviewId(reviewLike.getReviewId());
	}
}
