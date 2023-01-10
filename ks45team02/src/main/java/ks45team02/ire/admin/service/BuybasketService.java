package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Buybasket;
import ks45team02.ire.admin.dto.PointMinus;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.BuybasketMapper;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
@Transactional
public class BuybasketService {

	
	private static final Logger log = LoggerFactory.getLogger(BuybasketService.class);

	
	private final BuybasketMapper buybasketMapper;
	private final PointMapper pointMapper;
	private final PointService pointService;
	private final UserMapper userMapper;
	
	public BuybasketService(BuybasketMapper buybasketMapper, PointMapper pointMapper, UserMapper userMapper, PointService pointService) {
		this.buybasketMapper = buybasketMapper;
		this.pointMapper = pointMapper;
		this.userMapper = userMapper;
		this.pointService = pointService;
	}
	
	public int addBuybasket(Buybasket buybasket) {
		
		int result = 0;
		
		User userInfo = userMapper.getUserInfoById(buybasket.getUserId());
		int userPointState = userInfo.getPointState();
		int usePoint = buybasket.getUsePoint();
		
		
		if(userPointState < usePoint) {
			return result;
		}
		
		result = buybasketMapper.addBuybasket(buybasket);
		
		String[] basketCodeArr = buybasket.getBasketCode().split(",");
		for(String basketCode : basketCodeArr) {
			//주문 완료로 변경
			buybasketMapper.modifyBasketOrderComplete(basketCode);
		}
		String newBasketGroup = buybasketMapper.getNewBasketGroup();
		
		//주문 안 한 장바구니에게 새로운 장바구니 그룹 부여
		buybasketMapper.newBasketGroupNotBuy(buybasket.getBasketGroup(), newBasketGroup);
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
			pointMinus.setPointMinusReason("상품 구매 시 사용");
			pointService.addPointMinus(pointMinus);
		}
		
		return result;
	}
	
	/**
	 * 장바구니 구매 조회
	 * @return List<Buybasket>
	 */
	public List<Buybasket> getBuybasketList(){
		
		List<Buybasket> buybasketList = buybasketMapper.getBuybasketList();
		
		return buybasketList;
	}
	
}
