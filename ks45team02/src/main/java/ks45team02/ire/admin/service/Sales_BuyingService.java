package ks45team02.ire.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.GoodsBuying;
import ks45team02.ire.admin.mapper.Sales_BuyingMapper;

@Service
public class Sales_BuyingService {
	
	private Sales_BuyingMapper sales_BuyingMapper; 

	public Sales_BuyingService(Sales_BuyingMapper sales_BuyingMapper) {
		
		this.sales_BuyingMapper = sales_BuyingMapper;
	}
	
	
	/**
	 * 상품매입 리스트
	 * @return
	 */
	public List<GoodsBuying> getListGoodsBuying(){
		
		List<GoodsBuying> goodsBuyingList = sales_BuyingMapper.getListGoodsBuying();
		
		return goodsBuyingList;
	}
	
	
	
}
