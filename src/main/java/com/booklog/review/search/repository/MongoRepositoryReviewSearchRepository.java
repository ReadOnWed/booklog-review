package com.booklog.review.search.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.booklog.review.search.entity.ReviewEntity;

public interface MongoRepositoryReviewSearchRepository extends MongoRepository<ReviewEntity, String> {

	@Query(value = "{'reviewTitle':  {$regex :  ?0, $options:  'i'}}")
	List<ReviewEntity> findReviewEntitiesByReviewTitleRegex(String reviewTitle);

	@Query(value = "{'reviewContent' :  {$regex :  ?0, $options:  'i'}}")
	List<ReviewEntity> findReviewEntitiesByReviewContentRegex(String reviewContent);

	List<ReviewEntity> findReviewEntitiesByReviewWriter(String reviewWriter);

	@Query(value = "{'book_title' :  {$regex :  ?0, $options:  'i'}}")
	List<ReviewEntity> findReviewEntitiesByBook_TitleRegex(String bookTitle);

	List<ReviewEntity> findReviewEntitiesByUserId(String userId);

	List<ReviewEntity> findReviewEntitiesByBook__id(String bookId);

}
