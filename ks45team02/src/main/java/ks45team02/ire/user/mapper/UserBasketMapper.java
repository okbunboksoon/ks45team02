package ks45team02.ire.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Basket;

@Mapper
public interface UserBasketMapper {

	//장바구니에 동일한 상품이 존재하는지 검사
	public int checkSameGoodsCode(String userId, String goodsCode);
	
	//회원의 장바구니 그룹 찾기
	public String getBasketGroup(String userId);
	
	//장바구니 등록
	public int addBasket(Basket basket);
	
	//장바구니 그룹 존재 검사
	public int checkBasketGroup(String userId);
	
	//장바구니 삭제
	public int deleteBasket(String basketCode);
	
	//장바구니 수량 수정
	public int modifyBasketAmount(String basketCode, String basketAmount);
	
	//리뷰 작성 상태로 수정
	public int updateReviewState(String basketGroup, String goodsCode);
	
	//회원의 장바구니 조회
	public List<Basket> getUserBasketList(String loginId);
}
