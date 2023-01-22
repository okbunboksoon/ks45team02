package ks45team02.ire.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.user.mapper.UserBasketMapper;

@Service
@Transactional
public class UserBasketService {

	private final UserBasketMapper userBasketMapper;
	
	public UserBasketService (UserBasketMapper userBasketMapper){
		this.userBasketMapper = userBasketMapper;
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
