package ks45team02.ire.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.user.dto.UserGoods;
import ks45team02.ire.user.mapper.UserBasketMapper;
import ks45team02.ire.user.mapper.UserGoodsMapper;

@Service
@Transactional
public class UserBasketService {

	private final UserBasketMapper userBasketMapper;
	private final UserGoodsMapper userGoodsMapper;
	
	public UserBasketService (UserBasketMapper userBasketMapper, UserGoodsMapper userGoodsMapper){
		this.userBasketMapper = userBasketMapper;
		this.userGoodsMapper = userGoodsMapper;
	}
	
	/**
	 * 장바구니 등록
	 * @param basket
	 * @return int
	 */
	public int addBasket(Basket basket) {
		
		int result = 0;
		
		UserGoods goodsInfo =  userGoodsMapper.getGoodsInfoByGoodsCode(basket.getGoodsCode());
		int eachPaymentAmount = goodsInfo.getGoodsPrice() * basket.getBasketAmount();
		
		basket.setGoodsName(goodsInfo.getGoodsName());
		basket.setCategoryMediumCode(goodsInfo.getCategoryMediumCode());
		basket.setGoodsPrice(goodsInfo.getGoodsPrice());
		basket.setEachPaymentAmount(eachPaymentAmount);
		
		//장바구니 그룹 존재 여부 검사
		int checkBasketGroup = userBasketMapper.checkBasketGroup(basket.getUserId());
		
		//장바구니에 동일한 상품이 존재하는지 검사
		int checkSameGoods = userBasketMapper.checkSameGoodsCode(basket.getUserId(), basket.getGoodsCode());
		if(checkSameGoods == 1) {
			result = 10;
		}else {
			//기존 장바구니 그룹 유지
			if(checkBasketGroup > 0) {
				
				//장바구니에 새로운 상품
				String basketGroup = userBasketMapper.getBasketGroup(basket.getUserId());
				basket.setBasketGroup(basketGroup);
			}
			result = userBasketMapper.addBasket(basket);
		}
		
		return result;
	}
	
	/**
	 * 장바구니 수정 처리
	 * @param basketCode
	 * @param basketAmount
	 * @return
	 */
	public int modifyBasket(String basketCode, String basketAmount) {
		
		int result = 0;
		
		String[] basketCodeArr = basketCode.split(",");
		String[] basketAmountArr = basketAmount.split(",");
		for(int idx = 0; idx < basketAmountArr.length; idx++) {
			//수량이 0일 경우 삭제 처리
			if(basketAmountArr[idx].equals("0")) {
				userBasketMapper.deleteBasket(basketCodeArr[idx]);
			}
			result += userBasketMapper.modifyBasketAmount(basketCodeArr[idx], basketAmountArr[idx]);
		}
		
		return result;
	}
	
	/**
	 * 회원 장바구니 조회
	 * @param loginId
	 * @return List<Basket>
	 */
	public List<Basket> getUserBasketList(String loginId){
		
		List<Basket> userBasketList = userBasketMapper.getUserBasketList(loginId);
		
		return userBasketList;
	}
}
