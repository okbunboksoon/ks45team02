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
	 * 기부 조회
	 * @return List<Donation>
	 */
	public List<Donation> getDonationList() {
		
		List<Donation> donationList = donationMapper.getDonationList();
	
		return donationList;
	}
	
	
	
}
