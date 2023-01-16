package ks45team02.ire.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.mapper.GoodsBuyingPaymentMapper;

@Service
public class GoodsBuyingPaymentService {
	
	
	private GoodsBuyingPaymentMapper goodsBuyingPaymentMapper;
	
	public GoodsBuyingPaymentService(GoodsBuyingPaymentMapper goodsBuyingPaymentMapper) {
		this.goodsBuyingPaymentMapper = goodsBuyingPaymentMapper ;
	}
	
	
	private static final Logger log = LoggerFactory.getLogger(GoodsBuyingPaymentService.class);
	
	/**
	 * 상품 매입 결제 business_code 등록하기
	 */
	
	public int goodsBuyingPaymentCheck (String business_code) {
		int goodsBuyingPaymentCheck = goodsBuyingPaymentMapper.goodsBuyingPaymentCheck(business_code);
		return goodsBuyingPaymentCheck;
	}

}
