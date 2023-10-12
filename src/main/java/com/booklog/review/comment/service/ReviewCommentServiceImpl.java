package com.booklog.review.comment.service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.booklog.review.detail.service.ReviewDetailUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.booklog.review.comment.dto.Comment;
import com.booklog.review.comment.entity.CommentEntity;
import com.booklog.review.comment.repository.ReviewCommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewCommentServiceImpl implements ReviewCommentService {
	private final ReviewCommentRepository reviewCommentRepository;
	private final ReviewDetailUpdateService reviewDetailUpdateService;

	@Override
	public Comment postComment(Comment comment) {
		// 댓글 작성
		if(Objects.isNull(comment.getParentCommentId())){
			reviewDetailUpdateService.updateCommentCount(comment.getReviewId(), 1);
			return Comment.of(reviewCommentRepository.save(CommentEntity.of(comment)));
		}

		// 답글 작성
		return postReply(comment);
	}

	private Comment postReply(Comment reply){
		reviewCommentRepository.save(CommentEntity.of(reply));

		reviewDetailUpdateService.updateCommentCount(reply.getReviewId(), 1);

		CommentEntity commentEntity = reviewCommentRepository.findCommentEntityByCommentId(reply.getParentCommentId());
		return Comment.of(commentEntity
				.attachReplies(reviewCommentRepository.findCommentEntitiesByParentCommentId(commentEntity.getCommentId())));
	}

	@Override
	public Comment editComment(Comment comment) {
		CommentEntity updatedCommentEntity = reviewCommentRepository.findCommentEntityByCommentId(comment.getCommentId())
				.editContent(comment.getContent())
				.updateAt();

		return Comment.of(reviewCommentRepository.save(updatedCommentEntity));
	}

	@Override
	public Comment deleteComment(Comment comment) {
		CommentEntity deletedCommentEntity = reviewCommentRepository.findCommentEntityByCommentId(comment.getCommentId())
				.editContent("삭제된 댓글입니다.")
				.delete()
				.deletedAt();

		reviewDetailUpdateService.updateCommentCount(deletedCommentEntity.getReviewId(), -1);
		return Comment.of(reviewCommentRepository.save(deletedCommentEntity));

	}

	@Override
	public List<Comment> getCommentsByReview(String reviewId) {
		List<CommentEntity> commentEntities = reviewCommentRepository.findCommentEntitiesByReviewIdAndParentCommentIdIsNull(reviewId);

		return Comment.listOf(commentEntities.stream()
				.sorted(Comparator.comparing(CommentEntity::getCreatedAt))
				.map(commentEntity -> commentEntity.attachReplies(getRepliesByComment(commentEntity)))
				.collect(Collectors.toList())
		);
	}

	private List<CommentEntity> getRepliesByComment(CommentEntity commentEntity){
		return reviewCommentRepository.findCommentEntitiesByReviewIdAndParentCommentId(
				commentEntity.getReviewId(), commentEntity.getCommentId()).stream()
				.sorted(Comparator.comparing(CommentEntity::getCreatedAt))
				.collect(Collectors.toList());
	}
}
