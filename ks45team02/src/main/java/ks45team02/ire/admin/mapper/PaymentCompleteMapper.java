package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.PaymentComplete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentCompleteMapper {
	
	//결제완료 후 상황 수정
	public int modifyProductOrderState(String paymentCompleteCode, String productOrderState);
	
	//결제내역 수정
	public int modifyPaymentComplete(PaymentComplete paymentComplete);
	
	//즉시구매 코드/장바구니 그룹으로 결제내역 조회
	public PaymentComplete getPaymentCompleteInfoByBuynowBasketTotalCode(String buynowBasketTotalCode);
	
	//결제내역 등록
	public int addPayment(PaymentComplete paymentComplete);
	
	//장바구니 구매와 즉시구매 함께 검색
	public List<PaymentComplete> searchBuybasketAndBuynow(String searchKey, String searchValue);
	
	//결제내역 조회
    public List<PaymentComplete> listPaymentComplete();
    
    //결제내역 코드로 결제내역 조회
    public PaymentComplete getPaymentCompleteInfo(String paymentCompleteCode);
}
