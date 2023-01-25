package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.GoodsBuyingPayment;

@Mapper
public interface GoodsBuyingPaymentMapper {

	/**
	 * 상품 매입 결제 business_code 등록하기
	 */
	public int goodsBuyingPaymentCheck (String business_code);
	
	/**
	 * 상품 매입 결제 조회
	 */
	public List<GoodsBuyingPayment> getGoodsBuyingPaymentList();
}
