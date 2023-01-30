package ks45team02.ire.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Buynow;
import ks45team02.ire.admin.dto.PointMinus;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.BuynowMapper;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.mapper.UserMapper;
import ks45team02.ire.admin.service.PointService;
import ks45team02.ire.user.dto.UserGoods;
import ks45team02.ire.user.mapper.UserGoodsMapper;

@Service
@Transactional
public class UserBuynowService {
	
	private static final Logger log = LoggerFactory.getLogger(UserBuynowService.class);

	private final BuynowMapper buynowMapper;
	private final UserGoodsMapper userGoodsMapper;
	private final UserMapper userMapper;
	private final PointMapper pointMapper;
	private final PointService pointService;
	
	public UserBuynowService(BuynowMapper buynowMapper, UserGoodsMapper userGoodsMapper, UserMapper userMapper, 
							PointMapper pointMapper, PointService pointService) {
		this.buynowMapper = buynowMapper;
		this.userGoodsMapper = userGoodsMapper;
		this.userMapper = userMapper;
		this.pointMapper = pointMapper;
		this.pointService = pointService;
	}
	
	/**
	 * 즉시구매 등록
	 * @param buynow
	 * @return int
	 */
	public int addBuynow(Buynow buynow) {
		
		int result = 0;
		
		User userInfo = userMapper.getUserInfoById(buynow.getUserId());
		int userPointState = userInfo.getPointState();
		int usePoint = buynow.getUsePoint();
		
		UserGoods goodsInfo =  userGoodsMapper.getGoodsInfoByGoodsCode(buynow.getGoodsCode());
		
		buynow.setGoodsName(goodsInfo.getGoodsName());
		buynow.setCategoryMediumCode(goodsInfo.getCategoryMediumCode());
		buynow.setGoodsPrice(goodsInfo.getGoodsPrice());
		
		result = buynowMapper.addBuynow(buynow);
		
		if(usePoint > 0) {
			
			//포인트 차감 등록
			PointMinus pointMinus = new PointMinus(); 
			pointMinus.setUserId(buynow.getUserId());
			pointMinus.setPointMinus(buynow.getUsePoint());
			pointMinus.setPointState(userPointState);
			pointMinus.setPointMinusReason("상품 주문(결제 전)");
			pointService.addPointMinus(pointMinus);
		}
		
		return result;
	}
	
	/**
	 * 즉시구매 페이지
	 * @param buynow
	 * @return Buynow
	 */
	public Buynow addBuynowPage(Buynow buynow) {
		
		UserGoods goodsInfo =  userGoodsMapper.getGoodsInfoByGoodsCode(buynow.getGoodsCode());
		
		int expectedAmount = goodsInfo.getGoodsPrice() * buynow.getBuynowAmount();
		
		buynow.setGoodsName(goodsInfo.getGoodsName());
		buynow.setCategoryMediumCode(goodsInfo.getCategoryMediumCode());
		buynow.setGoodsPrice(goodsInfo.getGoodsPrice());
		buynow.setExpectedAmount(expectedAmount);
		
		return buynow;
	}
}
