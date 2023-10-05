package com.booklog.review.search.factory;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.booklog.review.search.common.SearchTermEnum;
import com.booklog.review.search.service.ReviewSearchService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReviewSearchFactory {

	// 더 적절한 자료구조 or 함수형 인터페이스 등..을 고민해보자
	private final Map<String, ReviewSearchService> reviewSearchServices;

	public ReviewSearchService getReviewSearchService(SearchTermEnum searchTerm){
		return reviewSearchServices.get(searchTerm.getBeanName());
	}

}
