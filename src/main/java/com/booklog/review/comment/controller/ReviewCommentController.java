package com.booklog.review.comment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklog.review.comment.dto.Comment;
import com.booklog.review.comment.dto.CommentDeleteRequestDto;
import com.booklog.review.comment.dto.CommentEditRequestDto;
import com.booklog.review.comment.dto.CommentPostRequestDto;
import com.booklog.review.comment.service.ReviewCommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/v1/reviews")
@RestController
@RequiredArgsConstructor
public class ReviewCommentController {
	private final ReviewCommentService reviewCommentService;

	@PostMapping(value = "/comment")
	public Comment postComment(@RequestBody CommentPostRequestDto commentPostRequestDto){
		log.info("posting comment for review : {}, by user : {}..."
			, commentPostRequestDto.getReviewId(), commentPostRequestDto.getUserId());

		return reviewCommentService.postComment(Comment.of(commentPostRequestDto));
	}

	@PutMapping(value = "/edit-comment")
	public Comment editComment(@RequestBody CommentEditRequestDto commentEditRequestDto){
		log.info("edit comment for comment : {}, by user : {}..."
			, commentEditRequestDto.getCommentId(), commentEditRequestDto.getUserId());
		return reviewCommentService.editComment(Comment.of(commentEditRequestDto));
	}

	@PutMapping(value = "/delete-comment")
	public Comment deleteComment(@RequestBody CommentDeleteRequestDto commentDeleteRequestDto){
		log.info("delete comment for comment : {}, by user : {}..."
			, commentDeleteRequestDto.getCommentId(), commentDeleteRequestDto.getUserId());
		return reviewCommentService.deleteComment(Comment.of(commentDeleteRequestDto));
	}
}
