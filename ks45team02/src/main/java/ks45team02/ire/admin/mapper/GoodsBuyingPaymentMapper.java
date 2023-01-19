package ks45team02.ire.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsBuyingPaymentMapper {

	/**
	 * 상품 매입 결제 business_code 등록하기
	 */
	public int goodsBuyingPaymentCheck (String business_code);
	
}
