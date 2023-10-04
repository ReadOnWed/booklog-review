package com.booklog.review.views.service;

import org.springframework.stereotype.Service;

import com.booklog.review.views.dto.ViewsCount;
import com.booklog.review.views.entity.ViewsCountEvent;
import com.booklog.review.views.repository.ViewsCountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewsCountServiceImpl implements ViewsCountService{
	private final ViewsCountRepository viewsCountRepository;
	@Override
	public long incrementViewsCount(ViewsCount viewsCount) {
		viewsCountRepository.save(ViewsCountEvent.of(viewsCount));
		viewsCountRepository.incrementViewsCountByReviewId(viewsCount.getReviewId());
		return viewsCountRepository.countViewsCountEventsByReviewId(viewsCount.getReviewId());
	}
}
