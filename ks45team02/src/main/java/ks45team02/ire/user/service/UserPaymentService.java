package ks45team02.ire.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Buybasket;
import ks45team02.ire.admin.dto.Buynow;
import ks45team02.ire.admin.dto.PaymentComplete;
import ks45team02.ire.admin.dto.PointMinus;
import ks45team02.ire.admin.dto.PointSave;
import ks45team02.ire.admin.mapper.BuybasketMapper;
import ks45team02.ire.admin.mapper.BuynowMapper;
import ks45team02.ire.admin.mapper.PaymentCompleteMapper;
import ks45team02.ire.admin.mapper.PointMapper;
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
	private final BuynowMapper buynowMapper;
	private final BuybasketMapper buybasketMapper;
	private final PointMapper pointMapper;
	
	public UserPaymentService(UserPaymentMapper userPaymentCompleteMapper, PaymentCompleteMapper paymentCompleteMapper, 
							  PointService pointService, PaymentCompleteService paymentCompleteService, BuynowMapper buynowMapper,
							  BuybasketMapper buybasketMapper, PointMapper pointMapper) {
		this.userPaymentCompleteMapper = userPaymentCompleteMapper;
		this.paymentCompleteMapper = paymentCompleteMapper;
		this.pointService = pointService;
		this.paymentCompleteService = paymentCompleteService;
		this.buynowMapper = buynowMapper;
		this.buybasketMapper = buybasketMapper;
		this.pointMapper = pointMapper;
	}
	
	/**
	 * 결제 완료 후 등록
	 * @param orderCode
	 * @return int
	 */
	public int addPaymentComplete(String orderCode) {
		
		int result = 0;
		PaymentComplete paymentComplete = new PaymentComplete();
		
		int usePoint = 0;
		
		String buynowOrBuybasket = orderCode.substring(0, 6);
		if("buynow".equals(buynowOrBuybasket)) {
			Buynow buynowInfo = buynowMapper.getBuynowInfo(orderCode);
			paymentComplete.setBuynowBasketTotalCode(orderCode);
			paymentComplete.setBuynowBasket("즉시구매");
			paymentComplete.setUserId(buynowInfo.getUserId());
			paymentComplete.setFinalPaymentAmount(buynowInfo.getFinalPaymentAmount());
			paymentComplete.setOrderDate(buynowInfo.getRegDate());
			paymentComplete.setProductOrderState("결제완료");
			paymentComplete.setPointSave(0);
			usePoint = buynowInfo.getUsePoint();
		}else {
			Buybasket buybasketInfo = buybasketMapper.getBuybasketInfo(orderCode);
			paymentComplete.setBuynowBasketTotalCode(orderCode);
			paymentComplete.setBuynowBasket("장바구니");
			paymentComplete.setUserId(buybasketInfo.getUserId());
			paymentComplete.setFinalPaymentAmount(buybasketInfo.getFinalPaymentAmount());
			paymentComplete.setOrderDate(buybasketInfo.getRegDate());
			paymentComplete.setProductOrderState("결제완료");
			paymentComplete.setPointSave(0);
			usePoint = buybasketInfo.getUsePoint();
		}
		
		result = paymentCompleteMapper.addPayment(paymentComplete);
		
		//포인트 차감 사유 변경
		if(usePoint != 0) {
			PaymentComplete addedPaymentComplete = paymentCompleteMapper.getPaymentCompleteInfoByBuynowBasketTotalCode(paymentComplete.getBuynowBasketTotalCode());
			String addedPointUseGroup = addedPaymentComplete.getPointUseGroup();
			PointMinus pointMinus = new PointMinus();
			pointMinus.setPointMinusGroup(addedPointUseGroup);
			pointMinus.setUserId(paymentComplete.getUserId());
			pointMinus.setPointMinus(usePoint);
			pointMinus.setPointMinusDate(paymentComplete.getOrderDate());
			pointMapper.modifyPointMinusGroup(pointMinus);
		}
		
		return result;
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
