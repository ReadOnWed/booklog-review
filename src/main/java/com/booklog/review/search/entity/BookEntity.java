package com.booklog.review.search.entity;

import lombok.Getter;

@Getter
public class BookEntity {
	private String _id;
	private String mainCategory;
	private String mainCategoryName;
	private String subCategory;
	private String subCategoryName;
	private String author;
	private String publisher;
	private String title;
}
