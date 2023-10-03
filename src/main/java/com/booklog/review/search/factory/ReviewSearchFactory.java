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
		if(SearchTermEnum.REVIEW_TITLE.equals(searchTerm)){
			return reviewSearchServices.get(SearchTermEnum.REVIEW_TITLE.getBeanName());
		}
		if(SearchTermEnum.REVIEW_CONTENT.equals(searchTerm)){
			return reviewSearchServices.get(SearchTermEnum.REVIEW_CONTENT.getBeanName());
		}
		if(SearchTermEnum.BOOK_TITLE.equals(searchTerm)){
			return reviewSearchServices.get(SearchTermEnum.BOOK_TITLE.getBeanName());
		}
		if(SearchTermEnum.REVIEW_WRITER.equals(searchTerm)){
			return reviewSearchServices.get(SearchTermEnum.REVIEW_WRITER.getBeanName());
		}
		if(SearchTermEnum.USER_ID.equals(searchTerm)){
			return reviewSearchServices.get(SearchTermEnum.USER_ID.getBeanName());
		}
		if(SearchTermEnum.BOOK_ID.equals(searchTerm)){
			return reviewSearchServices.get(SearchTermEnum.BOOK_ID.getBeanName());
		}
		throw new IllegalArgumentException("not found search service - illegal search term");

	}

}
