package com.booklog.review.search.dto;

import com.booklog.review.search.entity.BookEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Book {
	private String _id;
	private String mainCategory;
	private String mainCategoryName;
	private String subCategory;
	private String subCategoryName;
	private String author;
	private String publisher;
	private String title;

	public static Book of(BookEntity bookEntity){
		return Book.builder()
			._id(builder()._id)
			.mainCategory(bookEntity.getMainCategoryName())
			.mainCategoryName(bookEntity.getMainCategoryName())
			.subCategory(bookEntity.getSubCategory())
			.subCategoryName(bookEntity.getSubCategoryName())
			.author(bookEntity.getAuthor())
			.publisher(bookEntity.getAuthor())
			.title(bookEntity.getTitle())
			.build();
	}
}
