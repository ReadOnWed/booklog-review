package com.booklog.review.search.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booklog.review.search.common.SearchTermEnum;
import com.booklog.review.search.dto.Review;
import com.booklog.review.search.factory.ReviewSearchFactory;
import com.booklog.review.search.service.ReviewSearchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewSearchFacadeServiceImpl implements ReviewSearchFacadeService{
	private final ReviewSearchFactory reviewSearchFactory;

	@Override
	public List<Review> findReviewsByTerm(SearchTermEnum searchTerm, String keyword) {
		return reviewSearchFactory.getReviewSearchService(searchTerm)
			.findReviewsByTerm(keyword);
	}
}
