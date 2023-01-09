package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Buynow;

@Mapper
public interface BuynowMapper {

	//즉시구매 조회 
	public List<Buynow> getBuynowList();
	
	
}
