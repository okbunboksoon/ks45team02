package ks45team02.ire.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Donation;

@Mapper
public interface DonationMapper {

	//기부 테이블 행의 개수
	public int getDonationCnt();
	
	// 기부신청 코드로 기부 삭제
	public int deleteDonation(String donationCode);
	
	// 기부신청 코드로 raw_materials_incoming 삭제
	public int deleteRawMaterialsInComingByDonationCode(String donationCode);
	
	// 기부신청 코드로 raw_materials_outgoing 삭제
	public int deleteRawMaterialsOutGoingByDonationCode(String donationCode);
	
	// 기부신청 코드로 raw_materials 삭제
	public int deleteRawMaterialsByDonationCode(String donationCode);
	
	//기부 수정
	public int modifyDonation(Donation donation);
	
	//기부신청 번호로 기부 조회
	public Donation getDonationInfo(String donationCode);
	
	//기부 등록
	public int addDonation(Donation donation);
	
	//기부 조회 및 검색, 페이징
	public List<Donation> getDonationList();
	
}
