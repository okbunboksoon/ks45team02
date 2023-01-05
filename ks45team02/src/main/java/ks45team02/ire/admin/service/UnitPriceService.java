package ks45team02.ire.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.UnitPrice;
import ks45team02.ire.admin.mapper.UnitPriceMapper;

@Service
@Transactional
public class UnitPriceService {

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
}
