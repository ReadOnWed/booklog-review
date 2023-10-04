package com.booklog.review.edit.service;

import org.springframework.stereotype.Service;

import com.booklog.review.edit.dto.EditedReview;
import com.booklog.review.edit.entity.ReviewEntity;
import com.booklog.review.edit.repository.ReviewEditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewEditServiceImpl implements ReviewEditService{
	private final ReviewEditRepository reviewEditRepository;
	@Override
	public String editReview(EditedReview editedReview) {
		return reviewEditRepository.findAndModify(ReviewEntity.of(editedReview)).getId();
	}
}
