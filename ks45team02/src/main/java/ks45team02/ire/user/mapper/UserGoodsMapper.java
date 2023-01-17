package ks45team02.ire.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.user.dto.UserGoods;

@Mapper
public interface UserGoodsMapper {

	// 상품 및 이미지 경로 불러오기
	public List<UserGoods> getUserGoodsList();
	
	// 상품 및 이미지 특정 코드 조회
	public List<UserGoods> getGoodsFileByCode(String goodsCode);
}
