package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Basket;

@Mapper
public interface BasketMapper {
	
	
	//장바구니 조회
	public List<Basket> getBasketList();
}
