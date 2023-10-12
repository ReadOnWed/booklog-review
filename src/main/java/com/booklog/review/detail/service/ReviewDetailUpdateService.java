package com.booklog.review.detail.service;

public interface ReviewDetailUpdateService {
    void incrementLikesCount(String reviewId);
    void incrementScrapsCount(String reviewId);
    void decrementLikesCount(String reviewId);
    void decrementScrapsCount(String reviewId);
    void updateCommentCount(String reviewId, long count);
}
