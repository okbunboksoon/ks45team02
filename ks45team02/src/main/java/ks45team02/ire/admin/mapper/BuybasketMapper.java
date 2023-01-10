package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Buybasket;

@Mapper
public interface BuybasketMapper {
	
	//새로운 장바구니 그룹 조회
	public String getNewBasketGroup();
	
	//주문 안 한 장바구니에게 새로운 장바구니 그룹 부여
	public int newBasketGroupNotBuy(String basketGroup, String newBasketGroup);
	
	//주문 한 장바구니를 주문 완료로 변경
	public int modifyBasketOrderComplete(String basketCode);
	
	//장바구니 구매 등록
	public int addBuybasket(Buybasket buybasket);
	
	//장바구니 구매 조회
	public List<Buybasket> getBuybasketList();
}
