package com.booklog.review.edit.service;

import org.springframework.stereotype.Service;

import com.booklog.review.edit.repository.ReviewEditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewDeleteServiceImpl implements ReviewDeleteService {
	private final ReviewEditRepository reviewEditRepository;
	@Override
	public long deleteReview(String reviewId) {
		return reviewEditRepository.deleteById(reviewId);
	}
}
