package ks45team02.ire.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.user.dto.UserGoods;

@Mapper
public interface UserGoodsMapper {

	//상품코드로 상품 조회
	public UserGoods getGoodsInfoByGoodsCode(String goodsCode);
	
	// 상품 및 이미지 경로 불러오기
	public List<UserGoods> getUserGoodsList();
	
	// 상품 및 이미지 특정 코드 조회
	public List<UserGoods> getGoodsFileByCode(String goodsCode);
	
	// 카테고리 상품 선택
	public List<UserGoods> getListItemValueByBigCode(String ItemValue);
	
	public List<UserGoods> getListGoodsBag(String categoryCode);
	
	public List<UserGoods> getListGoodsShose(String categoryCode);
	
	public List<UserGoods> getListGoodsAcc(String categoryCode);
}
