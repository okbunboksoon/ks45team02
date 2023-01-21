package ks45team02.ire.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.PaymentComplete;
import ks45team02.ire.admin.dto.PointSave;
import ks45team02.ire.admin.mapper.PaymentCompleteMapper;
import ks45team02.ire.admin.service.PaymentCompleteService;
import ks45team02.ire.admin.service.PointService;
import ks45team02.ire.user.mapper.UserPaymentMapper;

@Service
@Transactional
public class UserPaymentService {
	
	private final UserPaymentMapper userPaymentCompleteMapper;
	private final PaymentCompleteMapper paymentCompleteMapper;
	private final PaymentCompleteService paymentCompleteService;
	private final PointService pointService;
	
	public UserPaymentService(UserPaymentMapper userPaymentCompleteMapper, PaymentCompleteMapper paymentCompleteMapper, 
							  PointService pointService, PaymentCompleteService paymentCompleteService) {
		this.userPaymentCompleteMapper = userPaymentCompleteMapper;
		this.paymentCompleteMapper = paymentCompleteMapper;
		this.pointService = pointService;
		this.paymentCompleteService = paymentCompleteService;
	}
	
	/**
	 * 결제 취소
	 * @param orderCode
	 * @return int
	 */
	public int cancelPayment(String orderCode) {
		
		int result = 0;
		
		PaymentComplete paymentComplete = paymentCompleteMapper.getPaymentCompleteInfoByBuynowBasketTotalCode(orderCode);
		
		result = paymentCompleteService.cancelPaymentComplete(paymentComplete);
		
		return result;
	}
	
	/**
	 * 구매확정 상태로 수정
	 * @param orderCode
	 * @return int
	 */
	public int updatePaymentConfirm(String orderCode) {
		
		int result = 0;
		
		PaymentComplete paymentComplete = paymentCompleteMapper.getPaymentCompleteInfoByBuynowBasketTotalCode(orderCode);
		
		//결제완료 데이터 수정
		int finalPaymentAmount = paymentComplete.getFinalPaymentAmount();
		int pointSaveAmount = (int) (finalPaymentAmount * 0.01);
		paymentComplete.setPointSave(pointSaveAmount);
		paymentComplete.setProductOrderPointGroup("product_order");
		result = userPaymentCompleteMapper.updatePaymentConfirm(paymentComplete);
		
		//포인트 적립
		PointSave pointSave = new PointSave();
		pointSave.setPointSaveReason("구매 확정");
		pointSave.setUserId(paymentComplete.getUserId());
		pointSave.setPointSave(pointSaveAmount);
		pointSave.setPointSaveGroup(paymentComplete.getProductOrderPointGroup());
		pointService.addPointSave(pointSave);
		
		return result;
	}
}
