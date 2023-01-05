package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Goods;

@Mapper
public interface GoodsMapper {
	
	//상품 검색
	public List<Goods> searchGoods(String searchKey, String searchValue);
	
	public List<Goods> getListGoods();

}
