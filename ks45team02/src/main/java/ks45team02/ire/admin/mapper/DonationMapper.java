package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Donation;

@Mapper
public interface DonationMapper {

	//기부 등록
	public int addDonation(Donation donation);
	
	//기부 조회 및 검색
	public List<Donation> getDonationList(String searchKey, String searchValue, String startDate, String endDate);
	
}
