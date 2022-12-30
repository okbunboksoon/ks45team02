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
	
	public List<Donation> getDonationList() {
		
		List<Donation> donationList = donationMapper.getDonationList();
		
		return donationList;
	}
	
	
	
}
