package com.booklog.review.edit.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookEntity {
	@Field("_id")
	private String id;
}
