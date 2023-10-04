package com.booklog.review.views.service;

import com.booklog.review.views.dto.ViewsCount;

public interface ViewsCountService {
	long incrementViewsCount(ViewsCount viewsCount);
}
