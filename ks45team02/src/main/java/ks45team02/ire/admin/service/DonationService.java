package ks45team02.ire.admin.service;

import java.util.List;

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
	 * 기부 등록
	 * @param donation
	 * @return int
	 */
	public int addDonation(Donation donation) {
		
		int result = donationMapper.addDonation(donation);
		
		return result;
	}
	
	
	/**
	 * 기부 조회 및 검색
	 * @param searchKey
	 * @param searchValue
	 * @param startDate
	 * @param endDate
	 * @return List<Donation>
	 */
	public List<Donation> getDonationList(String searchKey, String searchValue, String startDate, String endDate) {
		
		if(searchKey != null) {
			switch(searchKey) {
			case "donationNum" : 
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
		
		
		List<Donation> donationList = donationMapper.getDonationList(searchKey, searchValue, startDate, endDate);
		
		return donationList;
	}
	
	
	
}
