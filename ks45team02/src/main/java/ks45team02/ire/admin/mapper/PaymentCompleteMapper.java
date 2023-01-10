package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.PaymentComplete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentCompleteMapper {
	
	//결제완료 조회
    public List<PaymentComplete> listPaymentComplete();
}
