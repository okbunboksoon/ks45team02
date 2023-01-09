package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Buynow;

@Mapper
public interface BuynowMapper {

	//즉시구매 수정
	public int modifyBuynow(Buynow buynow);
	
	//즉시구매 코드로 즉시구매 조회
	public Buynow getBuynowInfo(String buynowCode);
	
	//즉시구매 등록
	public int addBuynow(Buynow buynow);
	
	//즉시구매 리스트 조회 
	public List<Buynow> getBuynowList();
	
	
}
