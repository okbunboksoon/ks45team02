package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.GoodsBuying;

@Mapper
public interface Sales_BuyingMapper {


	/**
	 * 상품 매입 전체 조회
	 */
	public List<GoodsBuying> getListGoodsBuying();
	
	/**
	 * 상품 매입 등록 처리
	 */
	public int addGoodsBuying(GoodsBuying goodsBuying);
	

}
