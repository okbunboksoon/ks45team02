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
	 * 회원 장바구니 조회
	 * @param loginId
	 * @return List<Basket>
	 */
	public List<Basket> getUserBasketList(String loginId){
		
		List<Basket> userBasketList = userBasketMapper.getUserBasketList(loginId);
		
		return userBasketList;
	}
}
