package ks45team02.ire.user.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ks45team02.ire.admin.dto.BoardReview;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.dto.PointSave;
import ks45team02.ire.admin.dto.PointSaveStandard;
import ks45team02.ire.admin.mapper.GoodsMapper;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.service.PointService;
import ks45team02.ire.user.mapper.UserBoardReviewMapper;
import ks45team02.ire.user.mapper.UserOrderMapper;

@Service
@Transactional
public class UserBoardReviewService {

	private final UserBoardReviewMapper userBoardReviewMapper;
	private final GoodsMapper goodsMapper;
	private final PointMapper pointMapper;
	private final PointService pointService;
	private final UserOrderMapper userOrderMapper;
	
	public UserBoardReviewService(UserBoardReviewMapper userBoardReviewMapper, GoodsMapper goodsMapper, PointMapper pointMapper, 
								  PointService pointService, UserOrderMapper userOrderMapper) {
		this.userBoardReviewMapper = userBoardReviewMapper;
		this.goodsMapper = goodsMapper;
		this.pointMapper = pointMapper;
		this.pointService = pointService;
		this.userOrderMapper = userOrderMapper;
	}
	
	public int addBoardReview(BoardReview boardReview, MultipartFile reviewImage, String orderCode) throws IllegalStateException, IOException {
		
		int result = 0;
		
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
		result = userBoardReviewMapper.addBoardReview(boardReview);
		
		//포인트 적립 처리
		pointSave.setUserId(boardReview.getUserId());
		pointSave.setPointSave(pointSaveAmount);
		pointSave.setPointSaveGroup(boardReview.getReviewPointGroup());
		pointService.addPointSave(pointSave);
		
		//주문 상태 변경
		List<String> noReviewGoodsCodeList = userBoardReviewMapper.getNoReviewGoodsCode(orderCode);
		if(noReviewGoodsCodeList.size() == 1) {
			userOrderMapper.updateReviewComplete(orderCode);
		}
		
		return result;
	}
	
	/**
	 * 구매확정 상태에 리뷰를 작성하지 않은 상품 조회
	 * @param orderCode
	 * @return List<Goods>
	 */
	public List<Goods> getNoReviewGoods(String orderCode){
		
		List<String> noReviewGoodsCodeList = userBoardReviewMapper.getNoReviewGoodsCode(orderCode);
		List<Goods> noReviewGoodsInfo = new ArrayList<Goods>();
		for(String noReviewGoods : noReviewGoodsCodeList) {
			noReviewGoodsInfo = goodsMapper.getListGoodsAndUnitPrice(noReviewGoods);
		}
		return noReviewGoodsInfo;
	}
	
	/**
	 * 리뷰 조회
	 * @param goodsCode
	 * @param currentPage
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getReviewForGoods(String goodsCode, int currentPage){
		
		//보여질 행의 갯수
		int rowPerPage = 10;
				
		// 로그인이력 테이블의 보여질 행의 시작점
		int startRowNum = (currentPage - 1) * rowPerPage;
		
		// 마지막페이지 
		// 1. 로그인이력 테이블의 전체 행의 갯수
		double rowCnt = userBoardReviewMapper.getReviewCnt(goodsCode);
		// 2. 마지막페이지
		int lastPage = (int) Math.ceil(rowCnt/rowPerPage);
				
		// 보여질 페이지 번호 구현
		// 보여질 페이지 번호 초기화
		int startPageNum = 1;
		int endPageNum = 10;
				
		// 페이지 번호 (동적) 10페이지 미만일 경우 처리
		if(currentPage > 6 && lastPage > 9){
			startPageNum = currentPage - 5;
		    endPageNum = currentPage + 4;
		    if(endPageNum >= lastPage){
		    	startPageNum = lastPage - 9;
		        endPageNum = lastPage;
		    }
		}
		if(lastPage < 10) {
			endPageNum = lastPage;
		}
		        
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("startRowNum", startRowNum);
		pageMap.put("rowPerPage", rowPerPage);
        pageMap.put("goodsCode", goodsCode);
				
		List<BoardReview> reviewForGoods = userBoardReviewMapper.getReviewForGoods(pageMap);
				
		pageMap.clear();
		pageMap.put("reviewForGoods", reviewForGoods);
		pageMap.put("lastPage", lastPage);
		pageMap.put("startPageNum", startPageNum);
		pageMap.put("endPageNum", endPageNum);
		pageMap.put("currentPage", currentPage);
		
		return pageMap;
	}

}
