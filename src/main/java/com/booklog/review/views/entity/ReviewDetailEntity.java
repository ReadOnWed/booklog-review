package com.booklog.review.views.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;

@Document(collection = "review")
@Getter
public class ReviewDetailEntity {
	@Id
	private String id;
	private long viewsCount;
}
