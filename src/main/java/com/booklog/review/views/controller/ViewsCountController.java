package com.booklog.review.views.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.views.dto.CurrentViewsCount;
import com.booklog.review.views.dto.ViewsCount;
import com.booklog.review.views.dto.ViewsCountRequestDto;
import com.booklog.review.views.service.ViewsCountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/reviews")
@RequiredArgsConstructor
@Slf4j
public class ViewsCountController {
	private final ViewsCountService viewsCountService;
	@PostMapping("/views")
	public CurrentViewsCount incrementViewCount(@RequestBody ViewsCountRequestDto viewsCountRequestDto){
		log.info("view review detail page by review : {}, increment views count by review", viewsCountRequestDto.getReviewId());
		return CurrentViewsCount.of(viewsCountService.incrementViewsCount(ViewsCount.of(viewsCountRequestDto)));
	}
}
