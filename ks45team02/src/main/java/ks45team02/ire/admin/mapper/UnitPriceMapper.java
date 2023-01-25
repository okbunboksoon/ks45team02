package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.dto.UnitPrice;

@Mapper
public interface UnitPriceMapper {
	
	/**
	 * 판매단가 및 상품가격 조회
	 */
	public List<UnitPrice> getListUnitPrice();
	
	/**
	 * 상품코드로 특정 상품 판매단가 및 상품가격 조회
	 */
	public UnitPrice getListUnitPriceByGoodsCode(String goodsCode);
	
	/**
	 * 판매단가 및 상품가격 상품등록시 같이 등록
	 */
	public int addUnitPrice(Goods goods);
	
	/**
	 * 상품삭제시 판매단가 및 상품가격 삭제
	 */
	public int deleteUnitPrice(String goodsCode);
	
	/**
	 * 상품수정시 판매단가 및 상품가격 수정
	 */
	public int modifyUnitPrice(Goods goods);
}
