package ks45team02.ire.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Basket;

@Mapper
public interface UserBasketMapper {

	//회원의 장바구니 조회
	public List<Basket> getUserBasketList(String loginId);
}
