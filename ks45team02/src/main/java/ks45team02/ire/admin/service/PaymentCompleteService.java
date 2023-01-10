package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.PaymentComplete;
import ks45team02.ire.admin.mapper.PaymentCompleteMapper;

@Service
@Transactional
public class PaymentCompleteService {

	private static final Logger log = LoggerFactory.getLogger(PaymentCompleteService.class);
	
	private final PaymentCompleteMapper paymentCompleteMapper;
	
	public PaymentCompleteService(PaymentCompleteMapper paymentCompleteMapper) {
		this.paymentCompleteMapper = paymentCompleteMapper;
	}
	
	/**
	 * 결제완료 조회
	 * @return List<PaymentComplete>
	 */
	public List<PaymentComplete> getPaymentCompleteList(){
		
		List<PaymentComplete> PaymentCompleteList = paymentCompleteMapper.listPaymentComplete();
		
		return PaymentCompleteList;
	}
}
