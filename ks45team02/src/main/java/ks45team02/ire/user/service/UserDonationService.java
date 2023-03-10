package ks45team02.ire.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Donation;
import ks45team02.ire.user.dto.UserDonation;
import ks45team02.ire.user.mapper.UserDonationMapper;

@Service
@Transactional
public class UserDonationService {

	private final UserDonationMapper userDonationMapper;
	
	public UserDonationService(UserDonationMapper userDonationMapper) {
		this.userDonationMapper = userDonationMapper;
	}
	
	/**
	 * 기부 등록
	 * @param donation
	 * @return
	 */
	public int addDonation(Donation donation) {
		
		int result = 0;
		
		result = userDonationMapper.addDonation(donation);
		
		return result;
	}
	
	/**
	 * 기부 조회
	 * @param loginId
	 * @param currentPage
	 * @return
	 */
	public Map<String, Object> getDonationList(String loginId, int currentPage){
		
		//보여질 행의 갯수
		int rowPerPage = 10;
						
		// 로그인이력 테이블의 보여질 행의 시작점
		int startRowNum = (currentPage - 1) * rowPerPage;
						
		// 마지막페이지 
		// 1. 로그인이력 테이블의 전체 행의 갯수
		double rowCnt = userDonationMapper.getDonationCnt(loginId);
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
		pageMap.put("loginId", loginId);
						
		List<UserDonation> userDonationList = userDonationMapper.getDonationList(pageMap);
						
		pageMap.clear();
		pageMap.put("userDonationList", userDonationList);
		pageMap.put("lastPage", lastPage);
		pageMap.put("startPageNum", startPageNum);
		pageMap.put("endPageNum", endPageNum);
						
		return pageMap;
	}
}
