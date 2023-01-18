package ks45team02.ire.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.user.dto.UserGoods;
import ks45team02.ire.user.mapper.UserGoodsMapper;

@Service
@Transactional
public class UserGoodsService {

	private final UserGoodsMapper userGoodsMapper;
	
	public UserGoodsService(UserGoodsMapper userGoodsMapper) {
		
		this.userGoodsMapper = userGoodsMapper;
		
	}
	
	/**
	 * 상품 및 이미지 경로 불러오기
	 * return : listGoods
	 */
	public List<UserGoods> getUserGoodsList(){
		
		List<UserGoods> listGoods = userGoodsMapper.getUserGoodsList();
		
		return listGoods;
	}
	
	public List<UserGoods> getGoodsFileByCode(String goodsCode) {
		
		List<UserGoods> getGoodsList = userGoodsMapper.getGoodsFileByCode(goodsCode);
		
		return getGoodsList;
				
	}
	
	public List<UserGoods> getListItemValueByBigCode(String ItemValue){
		
		List<UserGoods> listGoods = userGoodsMapper.getListItemValueByBigCode(ItemValue);
		
		return listGoods;
	}
}
