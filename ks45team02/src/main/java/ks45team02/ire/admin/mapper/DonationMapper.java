package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Donation;

@Mapper
public interface DonationMapper {

	public List<Donation> getDonationList();
	
}
