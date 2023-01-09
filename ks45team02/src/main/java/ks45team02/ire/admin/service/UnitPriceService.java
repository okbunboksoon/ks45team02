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
	
	public int addUnitPrice(Goods goods) {
		
		unitPriceMapper.addUnitPrice(goods);
		
		return 1;
	}
}
