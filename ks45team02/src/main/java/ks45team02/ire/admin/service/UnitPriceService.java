package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.controller.GoodsController;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.dto.UnitPrice;
import ks45team02.ire.admin.mapper.UnitPriceMapper;

@Service
@Transactional
public class UnitPriceService {

	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
		
	private final UnitPriceMapper unitPriceMapper;
	
	public UnitPriceService(UnitPriceMapper unitPriceMapper) {
		
		this.unitPriceMapper = unitPriceMapper;
	}
	
	/**
	 * 판매단가 및 상품가격 조회
	 * @return listUnitPrice
	 */
	public List<UnitPrice> getListUnitPrice(){
		
		List<UnitPrice> listUnitPrice = unitPriceMapper.getListUnitPrice();
		
		return listUnitPrice;
	}
	
	/**
	 * 상품코드로 특정 상품 판매단가 및 상품가격 조회
	 * @param goodsCode
	 * @return getListUnitPriceByGoodsCode
	 */
	public UnitPrice getListUnitPriceByGoodsCode(String goodsCode) {
		
		UnitPrice getListUnitPriceByGoodsCode =  unitPriceMapper.getListUnitPriceByGoodsCode(goodsCode);
		
		return getListUnitPriceByGoodsCode;
	}
	
	/**
	 * 상품 판매단가 및 상품가격 등록
	 * @param goods
	 * @return result
	 */
	public int addUnitPrice(Goods goods) {
		
		int result = unitPriceMapper.addUnitPrice(goods);
		
		return result;
	}
	
	public int modifyUnitPrice(Goods goods) {
		int result = 0;
		log.info("goods111111111111111111111111111 :{}", goods);
		result = unitPriceMapper.modifyUnitPrice(goods);
		return result;
	}
}
