package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Buybasket;

@Mapper
public interface BuybasketMapper {
	
	//장바구니 구매 조회
	public List<Buybasket> getBuybasketList();
}
