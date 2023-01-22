package ks45team02.ire.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Basket;

@Mapper
public interface UserBasketMapper {

	//장바구니 삭제
	public int deleteBasket(String basketCode);
	
	//장바구니 수량 수정
	public int modifyBasketAmount(String basketCode, String basketAmount);
	
	//리뷰 작성 상태로 수정
	public int updateReviewState(String basketGroup, String goodsCode);
	
	//회원의 장바구니 조회
	public List<Basket> getUserBasketList(String loginId);
}
