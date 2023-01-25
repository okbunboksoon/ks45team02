package ks45team02.ire.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Donation;
import ks45team02.ire.user.dto.UserDonation;

@Mapper
public interface UserDonationMapper {
	
	//기부 등록
	public int addDonation(Donation donation);
	
	//기부 내역 개수 조회
	public int getDonationCnt(String loginId);
	
	//기부 내역 조회
	public List<UserDonation> getDonationList(Map<String, Object> pageMap);
}
