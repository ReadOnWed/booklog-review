package com.booklog.review.search.common;

public enum SearchTermEnum {
	REVIEW_TITLE("reviewTitle", "reviewTitleSearchServiceImpl"),
	REVIEW_CONTENT("reviewContent", "reviewContentSearchServiceImpl"),
	BOOK_TITLE("bookTitle", "reviewBookTitleSearchServiceImpl"),
	REVIEW_WRITER("reviewWriter", "reviewWriterSearchServiceImpl"),
	USER_ID("userId", "reviewUserIdSearchServiceImpl"),
	BOOK_ID("bookId", "reviewBookIdSearchServiceImpl");


	private final String searchTerm;
	private final String beanName;

	public String getSearchTerm() {
		return searchTerm;
	}
	public String getBeanName() {
		return beanName;
	}
	SearchTermEnum(String searchTerm, String searchBeanName) {
		this.searchTerm = searchTerm;
		this.beanName = searchBeanName;
	}
}
