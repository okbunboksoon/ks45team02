package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.BusinessOrder;
import ks45team02.ire.admin.dto.GoodsBuying;
import ks45team02.ire.admin.mapper.Sales_BuyingMapper;

@Service
public class Sales_BuyingService {

	private Sales_BuyingMapper sales_BuyingMapper;

	public Sales_BuyingService(Sales_BuyingMapper sales_BuyingMapper) {

		this.sales_BuyingMapper = sales_BuyingMapper;
	}

	private static final Logger log = LoggerFactory.getLogger(Sales_BuyingService.class);

	/**
	 * 상품매입 리스트
	 * 
	 * @return
	 */
	public List<GoodsBuying> getListGoodsBuying() {

		List<GoodsBuying> goodsBuyingList = sales_BuyingMapper.getListGoodsBuying();

		return goodsBuyingList;
	}

	
	/*	*//**
			 * 상품 매입 등록 처리
			 * 
			 * @param goodsBuying
			 * @return result
			 *//*
				 * public int addGoodsBuying(BusinessOrder businessOrder) {
				 * 
				 * int result = 0; int getGoodsOrderAmount =
				 * businessOrder.getGoodsOrderAmount(); int getFactoryGoodsPrice =
				 * businessOrder.getFactoryGoodsPrice(); int buy_price = getGoodsOrderAmount *
				 * getFactoryGoodsPrice; int buy_vat = (int) ((getGoodsOrderAmount *
				 * getFactoryGoodsPrice) * 0.1); int buy_total = buy_price + buy_vat;
				 * 
				 * log.info("businessOrder: {}" , businessOrder);
				 * log.info("getGoodsOrderAmount: {}" , getGoodsOrderAmount);
				 * log.info("getFactoryGoodsPrice: {}" , getFactoryGoodsPrice);
				 * log.info("buy_price: {}" , buy_price); log.info("buy_vat: {}" , buy_vat);
				 * log.info("buy_total: {}" , buy_total);
				 * 
				 * 
				 * return result; }
				 */

}
