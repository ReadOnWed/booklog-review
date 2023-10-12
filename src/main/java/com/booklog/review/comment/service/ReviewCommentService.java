package com.booklog.review.comment.service;

import java.util.List;

import com.booklog.review.comment.dto.Comment;

public interface ReviewCommentService {
	Comment postComment(Comment comment);
	Comment editComment(Comment comment);
	Comment deleteComment(Comment comment);

	List<Comment> getCommentsByReview(String reviewId);
}
