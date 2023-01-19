package ks45team02.ire.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.BoardReview;
import ks45team02.ire.user.dto.UserOrder;
import ks45team02.ire.user.mapper.UserBoardReviewMapper;

@Service
@Transactional
public class UserBoardReviewService {

	private final UserBoardReviewMapper userBoardReviewMapper;
	
	public UserBoardReviewService(UserBoardReviewMapper userBoardReviewMapper) {
		this.userBoardReviewMapper = userBoardReviewMapper;
	}
	
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
		
		return pageMap;
	}
}
