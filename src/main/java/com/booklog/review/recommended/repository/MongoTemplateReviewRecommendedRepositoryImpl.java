package com.booklog.review.recommended.repository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoTemplateReviewRecommendedRepositoryImpl implements MongoTemplateReviewRecommendedRepository{
	private final MongoTemplate mongoTemplate;
	private static final String COLLECTION = "reviewlikes";
	private static final String TOTAL_REVIEW_LIKES = "totalLikes";

	@Override
	public List<String> findWeeklyTopLikedReviewIds() {
		// mongo db 시간은 UTC 기준으로 저장되므로 UTC 기준으로 지난 1주일 값을 지정
		String oneWeekAgo = LocalDateTime.now(ZoneOffset.UTC).minusWeeks(1)
			.format(DateTimeFormatter.ISO_DATE_TIME);

		Aggregation aggregation = Aggregation.newAggregation(
			Aggregation.match(Criteria.where("likedAt").gte(oneWeekAgo)),
			Aggregation.group("reviewId").count().as(TOTAL_REVIEW_LIKES),
			Aggregation.sort(Sort.Direction.DESC, TOTAL_REVIEW_LIKES),
			Aggregation.limit(5)
		);

		return mongoTemplate.aggregate(aggregation, COLLECTION, Document.class)
			.getMappedResults().stream()
			.map(document -> document.getString("_id"))
			.collect(Collectors.toList());
	}
}
