package ks45team02.ire.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.admin.dto.Buybasket;
import ks45team02.ire.admin.dto.PointMinus;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.BuybasketMapper;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.mapper.UserMapper;
import ks45team02.ire.admin.service.PointService;
import ks45team02.ire.user.mapper.UserBasketMapper;

@Service
@Transactional
public class UserBuybasketService {

	private final UserBasketService userBasketService;
	private final UserBasketMapper userBasketMapper;
	private final BuybasketMapper buybasketMapper;
	private final UserMapper userMapper;
	private final PointMapper pointMapper;
	private final PointService pointService;
	
	public UserBuybasketService(UserBasketService userBasketService, UserBasketMapper userBasketMapper, BuybasketMapper buybasketMapper, 
								UserMapper userMapper, PointMapper pointMapper, PointService pointService) {
		this.userBasketService = userBasketService;
		this.userBasketMapper = userBasketMapper;
		this.buybasketMapper = buybasketMapper;
		this.userMapper = userMapper;
		this.pointMapper = pointMapper;
		this.pointService = pointService;
	}
	
	/**
	 * 장바구니 구매 등록
	 * @param buybasket
	 * @return int
	 */
	public int addBuyBasket(Buybasket buybasket) {
		
		int result = 0;
		
		User userInfo = userMapper.getUserInfoById(buybasket.getUserId());
		int userPointState = userInfo.getPointState();
		int usePoint = buybasket.getUsePoint();
		
		String[] basketGroupArr = buybasket.getBasketGroup().split(",");
		buybasket.setBasketGroup(basketGroupArr[0]);
		
		result = buybasketMapper.addBuybasket(buybasket);
		
		String[] basketCodeArr = buybasket.getBasketCode().split(",");
		for(String basketCode : basketCodeArr) {
			//주문 완료로 변경
			buybasketMapper.modifyBasketOrderComplete(basketCode);
		}
		
		if(usePoint > 0) {
			userPointState -= buybasket.getUsePoint();
			userInfo.setPointState(userPointState);
			
			//회원 포인트 수정
			pointMapper.modifyUserPointState(userInfo);
			
			//포인트 차감 등록
			PointMinus pointMinus = new PointMinus(); 
			pointMinus.setUserId(buybasket.getUserId());
			pointMinus.setPointMinus(buybasket.getUsePoint());
			pointMinus.setPointState(userPointState);
			pointMinus.setPointMinusDate(buybasket.getRegDate());
			pointMinus.setPointMinusReason("상품 주문(결제 전)");
			pointService.addPointMinus(pointMinus);
		}
		
		return result;
	}
	
	/**
	 * 장바구니 구매 페이지
	 * @param basket
	 * @return List<Basket>
	 */
	public List<Basket> addBuyBasketPage(Basket basket) {
		
		//장바구니 수정
		userBasketService.modifyBasket(basket.getBasketCode(), Integer.toString(basket.getBasketAmount()));
		
		List<Basket> userBasketList = userBasketMapper.getUserBasketList(basket.getUserId());
		
		return userBasketList;
	}
}
