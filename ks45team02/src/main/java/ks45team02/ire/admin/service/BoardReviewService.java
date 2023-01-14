package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.BoardReview;
import ks45team02.ire.admin.dto.PointSave;
import ks45team02.ire.admin.dto.PointSaveStandard;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.BoardReviewMapper;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
@Transactional
public class BoardReviewService {
	
	private static final Logger log = LoggerFactory.getLogger(BoardReviewService.class);

	private final BoardReviewMapper boardReviewMapper;
	private final UserMapper userMapper;
	private final PointMapper pointMapper;
	private final PointService pointService;
	
	public BoardReviewService(BoardReviewMapper boardReviewMapper, UserMapper userMapper, PointMapper pointMapper, PointService pointService) {
		this.boardReviewMapper = boardReviewMapper;
		this.userMapper = userMapper;
		this.pointMapper = pointMapper;
		this.pointService = pointService;
	}
	
	public int modifyBoardReview(BoardReview boardReview) {
		
		int result = 0;
	
		int idCheck = userMapper.idCheck(boardReview.getUserId());
		if(idCheck == 0) {
			return 10;
		}
		
		result = boardReviewMapper.modifyBoardReview(boardReview);
		
		return result;
	}
	
	/**
	 * 리뷰 글 등록
	 * @param boardReview
	 * @return int
	 */
	public int addBoardReview(BoardReview boardReview) {
		
		int result = 0;
		
		int idCheck = userMapper.idCheck(boardReview.getUserId());
		if(idCheck == 0) {
			return 10;
		}
		
		//텍스트 리뷰인지 포토 리뷰인지 조건 추가 후 포인트 적립금 및 포인트 그룹 구분 필요
		int pointSaveAmount = 0;
		if(true) {
			//텍스트 리뷰 적립금
			PointSaveStandard pointSaveStandardInfo = pointMapper.getPointSaveStandardInfo("point_save_standard_002");
			pointSaveAmount = pointSaveStandardInfo.getPointSave();
			boardReview.setReviewPointSave(pointSaveAmount);
			
			//포인트 그룹 추가
			boardReview.setReviewPointGroup("text_review");
		}
		result = boardReviewMapper.addBoardReview(boardReview);
		
		//포인트 적립 처리
		PointSave pointSave = new PointSave();
		pointSave.setUserId(boardReview.getUserId());
		pointSave.setPointSave(pointSaveAmount);
		pointSave.setPointSaveReason("텍스트 리뷰 등록");
		pointSave.setPointSaveGroup(boardReview.getReviewPointGroup());
		pointService.addPointSave(pointSave);
		
		return result;
	}
	
	/**
	 * 리뷰 글 상세조회
	 * @param reviewCode
	 * @return
	 */
	public BoardReview getBoardReviewInfo(String reviewCode) {
		
		BoardReview boardReviewInfo = boardReviewMapper.getBoardReviewInfo(reviewCode);
		
		return boardReviewInfo;
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
