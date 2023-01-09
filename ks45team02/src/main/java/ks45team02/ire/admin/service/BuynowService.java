package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Buynow;
import ks45team02.ire.admin.dto.User;
import ks45team02.ire.admin.mapper.BuynowMapper;
import ks45team02.ire.admin.mapper.CategoryMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
@Transactional
public class BuynowService {

	private static final Logger log = LoggerFactory.getLogger(BuynowService.class);

	private final BuynowMapper buynowMapper;
	private final UserMapper userMapper;
	private final CategoryMapper categoryMapper;
	
	public BuynowService(BuynowMapper buynowMapper, UserMapper userMapper, CategoryMapper categoryMapper) {
		this.buynowMapper = buynowMapper;
		this.userMapper = userMapper;
		this.categoryMapper = categoryMapper;
	}
	
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
