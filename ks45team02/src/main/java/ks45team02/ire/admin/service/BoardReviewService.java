package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.BoardReview;
import ks45team02.ire.admin.mapper.BoardReviewMapper;

@Service
@Transactional
public class BoardReviewService {
	
	private static final Logger log = LoggerFactory.getLogger(BoardReviewService.class);

	private final BoardReviewMapper boardReviewMapper;
	
	public BoardReviewService(BoardReviewMapper boardReviewMapper) {
		this.boardReviewMapper = boardReviewMapper;
	}
	
	/**
	 * 리뷰 게시판 목록 조회
	 * @return
	 */
	public List<BoardReview> getBoardReviewList(){
		
		List<BoardReview> boardReviewList = boardReviewMapper.getBoardReviewList();
		
		return boardReviewList;
	}
}
