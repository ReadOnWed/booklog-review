package com.booklog.review.comment.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklog.review.comment.entity.CommentEntity;

public interface ReviewCommentRepository extends MongoRepository<CommentEntity, String> {
	List<CommentEntity> findCommentEntitiesByReviewIdAndParentCommentIdIsNull(String reviewId);
	List<CommentEntity> findCommentEntitiesByReviewIdAndParentCommentId(String reviewId, String parentCommentId);
	CommentEntity findCommentEntityByCommentId(String commentId);
	List<CommentEntity> findCommentEntitiesByParentCommentId(String parentCommentId);
}
