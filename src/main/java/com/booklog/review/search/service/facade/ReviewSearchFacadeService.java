package com.booklog.review.search.service.facade;

import java.util.List;

import com.booklog.review.search.common.SearchTermEnum;
import com.booklog.review.search.dto.Review;

public interface ReviewSearchFacadeService {
	List<Review> findReviewsByTerm(SearchTermEnum searchTerm, String keyword);
}
