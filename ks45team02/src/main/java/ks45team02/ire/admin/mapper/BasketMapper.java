package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Basket;

@Mapper
public interface BasketMapper {
	
	// 결제 전인 장바구니 조회
	public List<Basket> getBasketListBeforePayment(String searchKey, String searchValue);
	
	//결제 완료된 장바구니 그룹인지 확인
	public int checkBasketGroup(String basketGroup);
	
	//장바구니 삭제
	public int deleteBasket(String basketCode);
	
	//장바구니 수정
	public int modifyBasket(Basket basket);
	
	//장바구니 코드로 장바구니 조회
	public Basket getBasketInfo(String basketCode);
	
	//장바구니 등록
	public int addBasket(Basket basket);
	
	//장바구니 조회
	public List<Basket> getBasketList();
}
