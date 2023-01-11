package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Buynow;
import ks45team02.ire.admin.dto.PointMinus;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.BuynowMapper;
import ks45team02.ire.admin.mapper.CategoryMapper;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
@Transactional
public class BuynowService {

	private static final Logger log = LoggerFactory.getLogger(BuynowService.class);

	private final BuynowMapper buynowMapper;
	private final UserMapper userMapper;
	private final CategoryMapper categoryMapper;
	private final PointMapper pointMapper;
	private final PointService pointService;
	
	public BuynowService(BuynowMapper buynowMapper, UserMapper userMapper, CategoryMapper categoryMapper, PointMapper pointMapper, PointService pointService) {
		this.buynowMapper = buynowMapper;
		this.userMapper = userMapper;
		this.categoryMapper = categoryMapper;
		this.pointMapper = pointMapper;
		this.pointService = pointService;
	}
	
	/**
	 * 즉시구매 수정
	 * @param buynow
	 * @return
	 */
	public int modifyBuynow(Buynow buynow) {
		
		int result = 0;
		int idCheck = userMapper.idCheck(buynow.getUserId());
		
		if(idCheck == 0) {
			return result;
		}
		User userInfo = userMapper.getUserInfoById(buynow.getUserId());
		int userPointState = userInfo.getPointState();
		int usePoint = buynow.getUsePoint();
		
		if(userPointState < usePoint) {
			return result;
		}
		
		String categoryMediumCode = categoryMapper.getCategoryMediumCodeByName(buynow.getCategoryMediumName());
		buynow.setCategoryMediumCode(categoryMediumCode);
		
		result = buynowMapper.modifyBuynow(buynow);
		
		return result;
	}
	
	/**
	 * 즉시구매 등록
	 * @param buynow
	 * @return int
	 */
	public int addBuynow(Buynow buynow) {
		
		int result = 0;
		int idCheck = userMapper.idCheck(buynow.getUserId());
		
		if(idCheck == 0) {
			return result;
		}
		
		User userInfo = userMapper.getUserInfoById(buynow.getUserId());
		int userPointState = userInfo.getPointState();
		int usePoint = buynow.getUsePoint();
		
		if(userPointState < usePoint) {
			return result;
		}
		
		String categoryMediumCode = categoryMapper.getCategoryMediumCodeByName(buynow.getCategoryMediumName());
		buynow.setCategoryMediumCode(categoryMediumCode);
		
		result = buynowMapper.addBuynow(buynow);
		
		if(usePoint > 0) {
			userPointState -= buynow.getUsePoint();
			userInfo.setPointState(userPointState);
			
			//회원 포인트 수정
			pointMapper.modifyUserPointState(userInfo);
			
			//포인트 차감 등록
			PointMinus pointMinus = new PointMinus(); 
			pointMinus.setUserId(buynow.getUserId());
			pointMinus.setPointMinus(buynow.getUsePoint());
			pointMinus.setPointState(userPointState);
			pointMinus.setPointMinusDate(buynow.getRegDate());
			pointMinus.setPointMinusReason("상품 주문(결제 전)");
			pointService.addPointMinus(pointMinus);
		}
		
		return result;
	}
	
	/**
	 * 즉시구매 조회
	 * @return List<Buynow>
	 */
	public List<Buynow> getBuynowList(){
		
		List<Buynow> buynowList = buynowMapper.getBuynowList();
		 
		return buynowList;
	}
	
}
