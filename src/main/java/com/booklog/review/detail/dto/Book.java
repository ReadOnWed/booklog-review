package com.booklog.review.detail.dto;

import com.booklog.review.detail.entity.BookEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Book {
	private String bookId;
	private String subCategory;
	private String subCategoryName;
	private String author;
	private String publisher;
	private String title;

	public static Book of(BookEntity bookEntity){
		return Book.builder()
			.bookId(bookEntity.get_id())
			.subCategory(bookEntity.getSubCategory())
			.subCategoryName(bookEntity.getSubCategoryName())
			.author(bookEntity.getAuthor())
			.publisher(bookEntity.getPublisher())
			.title(bookEntity.getTitle())
			.build();
	}
}
