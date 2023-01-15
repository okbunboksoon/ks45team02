package ks45team02.ire.admin.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ks45team02.ire.admin.dto.BoardReview;
import ks45team02.ire.admin.dto.PointSave;
import ks45team02.ire.admin.dto.PointSaveStandard;
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
	
	/**
	 * 리뷰 글 수정
	 * @param boardReview
	 * @return int
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public int modifyBoardReview(BoardReview boardReview, MultipartFile reviewImage) throws IllegalStateException, IOException {
		
		int result = 0;
	
		int idCheck = userMapper.idCheck(boardReview.getUserId());
		if(idCheck == 0) {
			return 10;
		}
		
			if(!reviewImage.isEmpty()) {
			
			//저장될 프로젝트 경로 지정
			String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/reviewImages";
			
			//랜덤 식별자
			UUID uuid = UUID.randomUUID();
			
			//파일 이름 생성
			String fileName = uuid + "_" + reviewImage.getOriginalFilename();
			
			File saveFile = new File(projectPath, fileName);
			
			reviewImage.transferTo(saveFile);
			
			boardReview.setReviewImageName(fileName);
			boardReview.setReviewImagePath("/reviewImages/" + fileName);
		 }
		
		result = boardReviewMapper.modifyBoardReview(boardReview);
		
		return result;
	}
	
	/**
	 * 리뷰 글 등록
	 * @param boardReview
	 * @return int
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public int addBoardReview(BoardReview boardReview, MultipartFile reviewImage) throws IllegalStateException, IOException {
		
		int result = 0;
		
		int idCheck = userMapper.idCheck(boardReview.getUserId());
		if(idCheck == 0) {
			return 10;
		}
		
		if(!reviewImage.isEmpty()) {
			
			//저장될 프로젝트 경로 지정
			String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/reviewImages";
			
			//랜덤 식별자
			UUID uuid = UUID.randomUUID();
			
			//파일 이름 생성
			String fileName = uuid + "_" + reviewImage.getOriginalFilename();
			
			File saveFile = new File(projectPath, fileName);
			
			reviewImage.transferTo(saveFile);
			
			boardReview.setReviewImageName(fileName);
			boardReview.setReviewImagePath("/reviewImages/" + fileName);
		 }
		
		int pointSaveAmount = 0;
		PointSave pointSave = new PointSave();
		if(reviewImage.isEmpty()) {
			//텍스트 리뷰 적립금
			PointSaveStandard pointSaveStandardInfo = pointMapper.getPointSaveStandardInfo("point_save_standard_002");
			pointSaveAmount = pointSaveStandardInfo.getPointSave();
			boardReview.setReviewPointSave(pointSaveAmount);
			
			pointSave.setPointSaveReason("텍스트 리뷰 등록");
			
			//포인트 그룹 추가
			boardReview.setReviewPointGroup("text_review");
		}else {
			//포토 리뷰 적립금
			PointSaveStandard pointSaveStandardInfo = pointMapper.getPointSaveStandardInfo("point_save_standard_003");
			pointSaveAmount = pointSaveStandardInfo.getPointSave();
			boardReview.setReviewPointSave(pointSaveAmount);
			
			pointSave.setPointSaveReason("포토 리뷰 등록");
			
			//포인트 그룹 추가
			boardReview.setReviewPointGroup("photo_review");
		}
		result = boardReviewMapper.addBoardReview(boardReview);
		
		//포인트 적립 처리
		pointSave.setUserId(boardReview.getUserId());
		pointSave.setPointSave(pointSaveAmount);
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
