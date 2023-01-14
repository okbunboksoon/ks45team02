package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Buybasket;
import ks45team02.ire.admin.dto.Buynow;
import ks45team02.ire.admin.dto.PaymentComplete;
import ks45team02.ire.admin.dto.PointMinus;
import ks45team02.ire.admin.dto.PointSave;
import ks45team02.ire.admin.mapper.BuybasketMapper;
import ks45team02.ire.admin.mapper.BuynowMapper;
import ks45team02.ire.admin.mapper.DeliveryMapper;
import ks45team02.ire.admin.mapper.PaymentCompleteMapper;
import ks45team02.ire.admin.mapper.PointMapper;
import ks45team02.ire.admin.mapper.TypePaymentInfoMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
@Transactional
public class PaymentCompleteService {

	private static final Logger log = LoggerFactory.getLogger(PaymentCompleteService.class);
	
	private final PaymentCompleteMapper paymentCompleteMapper;
	private final BuybasketMapper buybasketMapper;
	private final BuynowMapper buynowMapper;
	private final DeliveryMapper deliveryMapper;
	private final TypePaymentInfoMapper typePaymentInfoMapper;
	private final PointMapper pointMapper;
	private final PointService pointService;
	
	public PaymentCompleteService(PaymentCompleteMapper paymentCompleteMapper, BuybasketMapper buybasketMapper, BuynowMapper buynowMapper, 
								  DeliveryMapper deliveryMapper, TypePaymentInfoMapper typePaymentInfoMapper, PointMapper pointMapper, 
								  PointService pointService) {
		this.paymentCompleteMapper = paymentCompleteMapper;
		this.buybasketMapper = buybasketMapper;
		this.buynowMapper = buynowMapper;
		this.deliveryMapper = deliveryMapper;
		this.typePaymentInfoMapper = typePaymentInfoMapper;
		this.pointMapper = pointMapper;
		this.pointService = pointService;
	}
	
	public int cancelPaymentComplete(PaymentComplete paymentComplete) {
		
		int result = 0;
		
		//결제 취소 상태로 변경
		result = paymentCompleteMapper.modifyProductOrderState(paymentComplete.getPaymentCompleteCode(), "결제취소");
		
		//포인트 사용 확인
		String pointUseGroup = paymentComplete.getPointUseGroup();
		PointMinus pointMinusInfo = pointMapper.getPointMinusInfoByPointMinusGroup(pointUseGroup);
		if(pointMinusInfo != null) {
			int pointMinusAmount = pointMinusInfo.getPointMinus();

			//차감했던 포인트 지급
			PointSave pointSave = new PointSave();
			pointSave.setUserId(paymentComplete.getUserId());
			pointSave.setPointSave(pointMinusAmount);
			pointSave.setPointSaveReason("결제 취소");
			pointService.addPointSave(pointSave);
		}
		
		return result;
	}
	
	/**
	 * 결제내역 수정
	 * @param paymentComplete
	 * @return int
	 */
	public int modifyPayment(PaymentComplete paymentComplete) {
		
		int result = 0;
		
		//deliveryCode와 UserId 일치 확인
		if(paymentComplete.getDeliCode() != null && paymentComplete.getDeliCode().isEmpty() == false) {
			int checkDeliveryCodeAndUserId = deliveryMapper.checkDeliveryCodeAndUserId(paymentComplete.getDeliCode(), paymentComplete.getUserId());
			if(checkDeliveryCodeAndUserId == 0) {
				return 30;
			}
		}
				
		//paymentTypeCode와 UserId 일치 확인
		int checkPaymentTypeCodeAndUserId = typePaymentInfoMapper.checkPaymentTypeCodeAndUserId(paymentComplete.getPaymentTypeCode(), paymentComplete.getUserId());
		if(checkPaymentTypeCodeAndUserId == 0) {
			return 40;
		}
				
		result = paymentCompleteMapper.modifyPaymentComplete(paymentComplete);
		
		return result;
	}
	
	/**
	 * 결제내역 등록
	 * @param paymentComplete
	 * @return int
	 */
	public int addPayment(PaymentComplete paymentComplete) {
		
		int result = 0;
		int usePoint = 0;
		
		//포인트 사용 확인
		String buynowBasket = paymentComplete.getBuynowBasket();
		if(buynowBasket.equals("장바구니")) {
			Buybasket buybasketInfo = buybasketMapper.getBuybasketInfo(paymentComplete.getBuynowBasketTotalCode());
			usePoint = buybasketInfo.getUsePoint();
		}else if(buynowBasket.equals("즉시구매")) {
			Buynow buynowInfo = buynowMapper.getBuynowInfo(paymentComplete.getBuynowBasketTotalCode());
			usePoint = buynowInfo.getUsePoint();
		}
		if(usePoint != 0) {
			paymentComplete.setPointUseGroup("point_use");
		}
		
		//deliveryCode와 UserId 일치 확인
		if(paymentComplete.getDeliCode() != null && paymentComplete.getDeliCode().isEmpty() == false) {
			int checkDeliveryCodeAndUserId = deliveryMapper.checkDeliveryCodeAndUserId(paymentComplete.getDeliCode(), paymentComplete.getUserId());
			if(checkDeliveryCodeAndUserId == 0) {
				return 30;
			}
		}
		
		//paymentTypeCode와 UserId 일치 확인
		int checkPaymentTypeCodeAndUserId = typePaymentInfoMapper.checkPaymentTypeCodeAndUserId(paymentComplete.getPaymentTypeCode(), paymentComplete.getUserId());
		if(checkPaymentTypeCodeAndUserId == 0) {
			return 40;
		}
		
		result = paymentCompleteMapper.addPayment(paymentComplete);
		
		//포인트 차감 그룹 수정
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
	 * 장바구니 구매와 즉시구매 검색
	 * @param searchKey
	 * @param searchValue
	 * @return List<PaymentComplete>
	 */
	public List<PaymentComplete> searchBuybasketAndBuynow(String searchKey, String searchValue){
		
		List<PaymentComplete> buybasketAndBuynowList = paymentCompleteMapper.searchBuybasketAndBuynow(searchKey, searchValue);
		
		return buybasketAndBuynowList;
	}
	
	/**
	 * 결제내역 조회
	 * @return List<PaymentComplete>
	 */
	public List<PaymentComplete> getPaymentCompleteList(){
		
		List<PaymentComplete> PaymentCompleteList = paymentCompleteMapper.listPaymentComplete();
		
		return PaymentCompleteList;
	}
}
