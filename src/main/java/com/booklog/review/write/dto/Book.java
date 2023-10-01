package com.booklog.review.write.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private String id;
	private String mainCategory;
	private String mainCategoryName;
	private String subCategory;
	private String subCategoryName;
	private String author;
	private String publisher;
	private String title;
}
