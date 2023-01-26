package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.GoodsBuying;
import ks45team02.ire.admin.dto.GoodsBuyingPayment;
import ks45team02.ire.admin.dto.SalesBuying;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Sales_BuyingMapper {


	/**일단위 매입매출 조회
	 *
	 * @return
	 */
	List<SalesBuying> goodsSalesBuyingGroup();

	/**
	 * 상품 매입 전체 조회
	 */
	public List<GoodsBuying> getListGoodsBuying();
	
	/**
	 * 상품 매입 등록 처리
	 */
	public int addGoodsBuying(GoodsBuying goodsBuying);
	
	/**
	 * 비즈니스코드로 상품매입결제 조회
	 */
	public int goodsBuyPaymentCheck(GoodsBuying goodsBuying);
	
	/**
	 * 비니즈니스코드로 상품매입 합계 
	 */
	public int getSumBuySearchPriceByBusinessCode(GoodsBuying goodsBuying);
	
	/**
	 * 상품매입결제 등록
	 */
	public int addGoodsBuyingPayment(GoodsBuyingPayment goodsBuyingPayment);
	
	/**
	 * 상품매입결제 코드있을 시 업데이트
	 */
	public int updateGoodsBuyingPayment(GoodsBuyingPayment goodsBuyingPayment);
	
	/**
	 * 비즈니스코드 외상 조회
	 */
	public int getPaymentByBusinessCode(GoodsBuying goodsBuying);
	
	/**
	 * 상품매입결제코드 특정 조회
	 */
	public GoodsBuyingPayment getGoodsBuyingPaymentByCode(String goods_buy_payment_code);
	
	/**
	 * 특정코드 외상조회
	 */
	public GoodsBuyingPayment getPayment(String goods_buy_payment_code);
	
	/**
	 * 특정코드 금액조회
	 */
	public int getPaymentCheck(String goods_buy_payment_code);
	
	/**
	 * 상품매입결제 수정
	 */
	public int modifyGoodsBuyingPayment(GoodsBuyingPayment goodsBuyingPayment);
}
