package ks45team02.ire.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.PaymentComplete;

@Mapper
public interface UserPaymentMapper {
	
	//구매확정 상태로 수정
	public int updatePaymentConfirm(PaymentComplete paymentComplete);
}
