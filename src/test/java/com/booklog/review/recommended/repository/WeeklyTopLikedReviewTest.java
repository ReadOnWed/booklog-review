package com.booklog.review.recommended.repository;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.booklog.review.recommended.dto.WeeklyTopLikedReviewTestDto;
import com.booklog.review.recommended.strategy.WeeklyTopLikedReview;

@DataMongoTest
@Import(WeeklyTopLikedReview.class)
public class WeeklyTopLikedReviewTest {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private WeeklyTopLikedReview weeklyTopLikedReview;

	private List<String> testDataIds = new ArrayList<>();

	@BeforeEach
	public void setupTestDats(){
		// review_like_1은 1주일 내에 좋아요를 5개받음
		var review1LikeAtNowByUser1 = new WeeklyTopLikedReviewTestDto(
			"review_like_1", "user1",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review1LikeAtNowByUser2 = new WeeklyTopLikedReviewTestDto(
			"review_like_1", "user2",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review1LikeAtNowByUser3 = new WeeklyTopLikedReviewTestDto(
			"review_like_1", "user3",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review1LikeAtNowByUser4 = new WeeklyTopLikedReviewTestDto(
			"review_like_1", "user4",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review1LikeAtNowByUser5 = new WeeklyTopLikedReviewTestDto(
			"review_like_1", "user5",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));

		mongoTemplate.save(review1LikeAtNowByUser1);
		mongoTemplate.save(review1LikeAtNowByUser2);
		mongoTemplate.save(review1LikeAtNowByUser3);
		mongoTemplate.save(review1LikeAtNowByUser4);
		mongoTemplate.save(review1LikeAtNowByUser5);

		testDataIds.add(review1LikeAtNowByUser1.getId());
		testDataIds.add(review1LikeAtNowByUser2.getId());
		testDataIds.add(review1LikeAtNowByUser3.getId());
		testDataIds.add(review1LikeAtNowByUser4.getId());
		testDataIds.add(review1LikeAtNowByUser5.getId());

		// review_like_2은 1주일 내에 좋아요를 4개받음
		var review2LikeAtNowByUser1 = new WeeklyTopLikedReviewTestDto(
			"review_like_2", "user1",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review2LikeAtNowByUser2 = new WeeklyTopLikedReviewTestDto(
			"review_like_2", "user2",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review2LikeAtNowByUser3 = new WeeklyTopLikedReviewTestDto(
			"review_like_2", "user3",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review2LikeAtNowByUser4 = new WeeklyTopLikedReviewTestDto(
			"review_like_2", "user4",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));

		mongoTemplate.save(review2LikeAtNowByUser1);
		mongoTemplate.save(review2LikeAtNowByUser2);
		mongoTemplate.save(review2LikeAtNowByUser3);
		mongoTemplate.save(review2LikeAtNowByUser4);

		testDataIds.add(review2LikeAtNowByUser1.getId());
		testDataIds.add(review2LikeAtNowByUser2.getId());
		testDataIds.add(review2LikeAtNowByUser3.getId());
		testDataIds.add(review2LikeAtNowByUser4.getId());

		// review_like_3은 1주일 내에 좋아요를 3개받음
		var review3LikeAtNowByUser1 = new WeeklyTopLikedReviewTestDto(
			"review_like_3", "user1",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review3LikeAtNowByUser2 = new WeeklyTopLikedReviewTestDto(
			"review_like_3", "user2",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review3LikeAtNowByUser3 = new WeeklyTopLikedReviewTestDto(
			"review_like_3", "user3",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));

		mongoTemplate.save(review3LikeAtNowByUser1);
		mongoTemplate.save(review3LikeAtNowByUser2);
		mongoTemplate.save(review3LikeAtNowByUser3);

		testDataIds.add(review3LikeAtNowByUser1.getId());
		testDataIds.add(review3LikeAtNowByUser2.getId());
		testDataIds.add(review3LikeAtNowByUser3.getId());

		// review_like_4은 1주일 내에 좋아요를 2개받음
		var review4LikeAtNowByUser1 = new WeeklyTopLikedReviewTestDto(
			"review_like_4", "user1",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		var review4LikeAtNowByUser2 = new WeeklyTopLikedReviewTestDto(
			"review_like_4", "user2",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		mongoTemplate.save(review4LikeAtNowByUser1);
		mongoTemplate.save(review4LikeAtNowByUser2);

		testDataIds.add(review4LikeAtNowByUser1.getId());
		testDataIds.add(review4LikeAtNowByUser2.getId());

		// review_like_5은 1주일 내에 좋아요를 1개받음
		var review5LikeAtNowByUser1 = new WeeklyTopLikedReviewTestDto(
			"review_like_5", "user1",
			LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME));
		mongoTemplate.save(review5LikeAtNowByUser1);
		testDataIds.add(review5LikeAtNowByUser1.getId());

		// review_like_6은 1주일 이전에 좋아요를 6개받음
		var review6LikeAt8DaysAgoByUser1 = new WeeklyTopLikedReviewTestDto(
			"review_like_6", "user1",
			LocalDateTime.now(ZoneOffset.UTC).minusDays(8).format(DateTimeFormatter.ISO_DATE_TIME));
		var review6LikeAt8DaysAgoByUser2 = new WeeklyTopLikedReviewTestDto(
			"review_like_6", "user2",
			LocalDateTime.now(ZoneOffset.UTC).minusDays(8).format(DateTimeFormatter.ISO_DATE_TIME));
		var review6LikeAt8DaysAgoByUser3 = new WeeklyTopLikedReviewTestDto(
			"review_like_6", "user3",
			LocalDateTime.now(ZoneOffset.UTC).minusDays(8).format(DateTimeFormatter.ISO_DATE_TIME));
		var review6LikeAt8DaysAgoByUser4 = new WeeklyTopLikedReviewTestDto(
			"review_like_6", "user4",
			LocalDateTime.now(ZoneOffset.UTC).minusDays(8).format(DateTimeFormatter.ISO_DATE_TIME));
		var review6LikeAt8DaysAgoByUser5 = new WeeklyTopLikedReviewTestDto(
			"review_like_6", "user5",
			LocalDateTime.now(ZoneOffset.UTC).minusDays(8).format(DateTimeFormatter.ISO_DATE_TIME));
		var review6LikeAt8DaysAgoByUser6 = new WeeklyTopLikedReviewTestDto(
			"review_like_6", "user6",
			LocalDateTime.now(ZoneOffset.UTC).minusDays(8).format(DateTimeFormatter.ISO_DATE_TIME));

		mongoTemplate.save(review6LikeAt8DaysAgoByUser1);
		mongoTemplate.save(review6LikeAt8DaysAgoByUser2);
		mongoTemplate.save(review6LikeAt8DaysAgoByUser3);
		mongoTemplate.save(review6LikeAt8DaysAgoByUser4);
		mongoTemplate.save(review6LikeAt8DaysAgoByUser5);
		mongoTemplate.save(review6LikeAt8DaysAgoByUser6);

		testDataIds.add(review6LikeAt8DaysAgoByUser1.getId());
		testDataIds.add(review6LikeAt8DaysAgoByUser2.getId());
		testDataIds.add(review6LikeAt8DaysAgoByUser3.getId());
		testDataIds.add(review6LikeAt8DaysAgoByUser4.getId());
		testDataIds.add(review6LikeAt8DaysAgoByUser5.getId());
		testDataIds.add(review6LikeAt8DaysAgoByUser6.getId());
	}

	@Test
	public void findRecommendedReviewIdsTest(){
		List<String> expectedReviewIds = Arrays.asList(
			"review_like_1",
			"review_like_2",
			"review_like_3",
			"review_like_4",
			"review_like_5"
		);
		List<String> resultReviewIds = weeklyTopLikedReview.findRecommendedReviewIds();

		assertThat(resultReviewIds).isEqualTo(expectedReviewIds);
	}

	@AfterEach
	public void cleanupTestData(){
		// 기록된 ID를 사용하여 해당 데이터만 삭제
		for (String id : testDataIds) {
			mongoTemplate.remove(new Query(Criteria.where("id").is(id)), WeeklyTopLikedReviewTestDto.class);
		}
		testDataIds.clear(); // 목록 초기화
	}
}
