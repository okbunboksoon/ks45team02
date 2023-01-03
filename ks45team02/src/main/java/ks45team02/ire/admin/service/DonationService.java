package ks45team02.ire.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Donation;
import ks45team02.ire.admin.mapper.DonationMapper;

@Service
@Transactional
public class DonationService {
	
	private static final Logger log = LoggerFactory.getLogger(DonationService.class);

	private final DonationMapper donationMapper;
	
	public DonationService(DonationMapper donationMapper) {
		this.donationMapper = donationMapper;
	}
	
	/**
	 * 기부 삭제
	 * @param donationCode
	 * @return int
	 */
	public int deleteDonation(String donationCode) {
		
		int result = 0;
		
		result += donationMapper.deleteRawMaterialsByDonationCode(donationCode);
		result += donationMapper.deleteRawMaterialsOutGoingByDonationCode(donationCode);
		result += donationMapper.deleteRawMaterialsInComingByDonationCode(donationCode);
		result += donationMapper.deleteDonation(donationCode);
		
		return result;
	}
	
	/**
	 * 기부 수정
	 * @param donation
	 * @return int
	 */
	public int modifyDonation(Donation donation) {
		
		int result = donationMapper.modifyDonation(donation);
		
		return result;
	}
	
	/**
	 * 기부 등록
	 * @param donation
	 * @return int
	 */
	public int addDonation(Donation donation) {
		
		int result = donationMapper.addDonation(donation);
		
		return result;
	}
	
	
	/**
	 * 기부 조회 및 검색, 페이징
	 * @param searchKey
	 * @param searchValue
	 * @param startDate
	 * @param endDate
	 * @param currentPage
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getDonationList(String searchKey, String searchValue, String startDate, String endDate, int currentPage) {
		
		if(searchKey != null) {
			switch(searchKey) {
			case "donationCode" : 
				searchKey = "donation_num"; 
				break;
			
			case "userId" : 
				searchKey = "user_id"; 
				break;
				
			case "goodsC02Code" : 
				searchKey = "goods_co2_code"; 
				break;
			case "donationStatus" : 
				searchKey = "donation_status"; 
				break;
			}
		}
		
		int rowPerPage = 10;
		int startRowNum = (currentPage - 1) * rowPerPage;
		double rowCnt = donationMapper.getDonationCnt();
		int lastPage = (int) Math.ceil(rowCnt/rowPerPage);
		
		int startPageNum = 1;
		int endPageNum = 10;
		
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
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRowNum", startRowNum);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		
		List<Donation> donationList = donationMapper.getDonationList(paramMap);
		
		paramMap.clear();
		paramMap.put("donationList", donationList);
		paramMap.put("lastPage", lastPage);
		paramMap.put("startPageNum", startPageNum);
		paramMap.put("endPageNum", endPageNum);
		
		return paramMap;
	}
	
	
	
}
