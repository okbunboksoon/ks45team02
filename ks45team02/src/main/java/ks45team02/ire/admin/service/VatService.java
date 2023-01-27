package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.Vat;
import ks45team02.ire.admin.mapper.Sales_BuyingMapper;
import ks45team02.ire.admin.mapper.VatMapper;

@Service
public class VatService {
	
	private VatMapper vatMapper;
	private Sales_BuyingMapper sales_BuyingMapper;
	
	public VatService(VatMapper vatMapper, Sales_BuyingMapper sales_BuyingMapper) {
		this.vatMapper = vatMapper;
		this.sales_BuyingMapper = sales_BuyingMapper;
		
	}

	private static final Logger log = LoggerFactory.getLogger(VatService.class);

	
	/**
	 * 부가세 계산 조회
	 */
	public List<Vat> getListVat(){
		List<Vat> vatList = vatMapper.getListVat();
		
		return vatList;
	}
	
	
	/**
	 * 부가세 월별 계산 
	 */
	
}
