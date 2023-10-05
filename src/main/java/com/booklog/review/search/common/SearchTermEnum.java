package com.booklog.review.search.common;

public enum SearchTermEnum {
	REVIEW_TITLE( "reviewTitleSearchServiceImpl"),
	REVIEW_CONTENT( "reviewContentSearchServiceImpl"),
	BOOK_TITLE("reviewBookTitleSearchServiceImpl"),
	REVIEW_WRITER("reviewWriterSearchServiceImpl"),
	USER_ID("reviewUserIdSearchServiceImpl"),
	BOOK_ID("reviewBookIdSearchServiceImpl"),
	UNKNOWN("reviewUnknownServiceImpl");

	private final String beanName;

	public String getBeanName() {
		return beanName;
	}
	SearchTermEnum( String beanName) {
		this.beanName = beanName;
	}
}
