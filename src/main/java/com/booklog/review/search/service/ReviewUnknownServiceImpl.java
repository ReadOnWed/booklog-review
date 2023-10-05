package com.booklog.review.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.booklog.review.search.dto.Review;

@Service
public class ReviewUnknownServiceImpl implements ReviewSearchService{
	@Override
	public List<Review> findReviewsByTerm(String keyword) {
		return new ArrayList<>();
	}
}
