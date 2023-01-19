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
	
	/**
	 * 상품 및 이미지 경로 불러오기
	 * @param goodsCode
	 * @return getGoodsList
	 */
	public List<UserGoods> getGoodsFileByCode(String goodsCode) {
		
		List<UserGoods> getGoodsList = userGoodsMapper.getGoodsFileByCode(goodsCode);
		
		return getGoodsList;
				
	}
	
	/**
	 * 상품 카테고리 별 상품 조회
	 * @param ItemValue
	 * @return listGoods
	 */
	public List<UserGoods> getListItemValueByBigCode(String ItemValue){
		
		List<UserGoods> listGoods = userGoodsMapper.getListItemValueByBigCode(ItemValue);
		
		return listGoods;
	}
	
	/**
	 * 상품 가방 카테고리 선택
	 * @return BaglistGoods
	 */
	public List<UserGoods> getListGoodsBag(){
		String categoryCode = "cate_big_002";
		
		List<UserGoods> BaglistGoods = userGoodsMapper.getListGoodsBag(categoryCode);
		
		return BaglistGoods;
				
	}
	
	/**
	 * 상품 신발 카테고리 선택
	 * @return ShoselistGoods
	 */
	public List<UserGoods> getListGoodsShose(){
		String categoryCode = "cate_big_001";
		
		List<UserGoods> ShoselistGoods = userGoodsMapper.getListGoodsShose(categoryCode);
		
		return ShoselistGoods;
		
	}
	
	/**
	 * 상품 신발 카테고리 선택
	 * @return ShoselistGoods
	 */
	public List<UserGoods> getListGoodsAcc(){
		String categoryCode = "cate_big_003";
		
		List<UserGoods> AcclistGoods = userGoodsMapper.getListGoodsAcc(categoryCode);
		
		return AcclistGoods;
		
	}
}
