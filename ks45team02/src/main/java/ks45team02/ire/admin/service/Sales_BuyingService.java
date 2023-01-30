package ks45team02.ire.admin.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.Business;
import ks45team02.ire.admin.dto.BusinessOrder;
import ks45team02.ire.admin.dto.GoodsBuying;
import ks45team02.ire.admin.dto.GoodsBuyingPayment;
import ks45team02.ire.admin.mapper.Sales_BuyingMapper;

@Service
public class Sales_BuyingService {

	private Sales_BuyingMapper sales_BuyingMapper;

	public Sales_BuyingService(Sales_BuyingMapper sales_BuyingMapper) {

		this.sales_BuyingMapper = sales_BuyingMapper;
	}

	
	private static final Logger log = LoggerFactory.getLogger(Sales_BuyingService.class);


	/**
	 * 상품매입 리스트
	 * 
	 * @return
	 */
	public List<GoodsBuying> getListGoodsBuying() {

		List<GoodsBuying> goodsBuyingList = sales_BuyingMapper.getListGoodsBuying();

		return goodsBuyingList;
	}

	
	/**
	 * 상품 매입 등록 처리
	 * 
	 * @param goodsBuying
	 * @return result
	 */
	public void addGoodsBuying(BusinessOrder businessOrder) {
	  GoodsBuying goodsBuying = new GoodsBuying();
	  Business Business = businessOrder.getBusiness();
	  
	  int getGoodsOrderAmount = businessOrder.getGoodsOrderAmount(); 
	  int getFactoryGoodsPrice = businessOrder.getFactoryGoodsPrice(); 
	  int buy_price = getGoodsOrderAmount * getFactoryGoodsPrice; 
	  int buy_vat = (int) ((getGoodsOrderAmount * getFactoryGoodsPrice) * 0.1); 
	  int buy_total = buy_price + buy_vat;
	  
	  log.info("businessOrder :{}", businessOrder);
	  log.info("getGoodsOrderAmount :{}", getGoodsOrderAmount);
	  log.info("getFactoryGoodsPrice :{}", getFactoryGoodsPrice);
	  log.info("buy_price :{}", buy_price);
	  log.info("buy_vat :{}", buy_vat);
	  log.info("buy_total :{}", buy_total);
	  
	  goodsBuying.setBusinessCode(Business.getBusinessCode());
	  goodsBuying.setBusinessName(Business.getBusinessName());
	  goodsBuying.setGoodsCode(businessOrder.getGoodsCode());
	  goodsBuying.setGoodsOrderAmount(getGoodsOrderAmount);
	  goodsBuying.setFactoryGoodsPrice(getFactoryGoodsPrice);
	  goodsBuying.setBuy_price(buy_price); 
	  goodsBuying.setBuy_vat(buy_vat);
	  goodsBuying.setBuy_total(buy_total);	  
	  
	  int checkadd = sales_BuyingMapper.addGoodsBuying(goodsBuying);
	  if(checkadd != 0) {
		  goodsBuyingPayment(goodsBuying);
	  }
	}
	
	/**
	 * 상품매입결제 등록 및 수정
	 * @param goodsBuying
	 */
	public void goodsBuyingPayment(GoodsBuying goodsBuying) {
	  GoodsBuyingPayment goodsBuyingPayment = new GoodsBuyingPayment();
	  goodsBuyingPayment.setBusiness_code(goodsBuying.getBusinessCode());
	  goodsBuyingPayment.setBusiness_name(goodsBuying.getBusinessName());
	  int SumBuySearchPrice = sales_BuyingMapper.getSumBuySearchPriceByBusinessCode(goodsBuying);
	  goodsBuyingPayment.setBuy_total(SumBuySearchPrice);
	  
	  log.info(" 매입목록결제  goodsBuying :{}", goodsBuying);
	  log.info(" 매입목록결제  goodsBuyingPayment :{}", goodsBuyingPayment);

	  int paymentCheck = sales_BuyingMapper.goodsBuyPaymentCheck(goodsBuying);
	  log.info(" 매입목록 등록 후 paymentCheck :{}", paymentCheck);
	  
	  
	  // 0이면 생성 1이면 업데이트
	  if(paymentCheck != 0) {
		 int price = sales_BuyingMapper.getPaymentByBusinessCode(goodsBuying);
		 int accountsPayable = SumBuySearchPrice - price;
		 goodsBuyingPayment.setAccounts_payable(accountsPayable);
		 sales_BuyingMapper.updateGoodsBuyingPayment(goodsBuyingPayment);
	  }else {  
		 sales_BuyingMapper.addGoodsBuyingPayment(goodsBuyingPayment);
	  }
	}
	
	/**
	 * 상품매입결제코드 특정 조회
	 * @param goods_buy_payment_code
	 * @return GoodsBuyingPayment
	 */
	public GoodsBuyingPayment getGoodsBuyingPaymentByCode(String goods_buy_payment_code) {
		
		GoodsBuyingPayment GoodsBuyingPayment = sales_BuyingMapper.getGoodsBuyingPaymentByCode(goods_buy_payment_code);
		
		return GoodsBuyingPayment;
	}
	
	/**
	 * 외상매입금 잔액 계산
	 * @param paymentValue
	 * @param goods_buy_payment_code, paymentValue
	 * @return reResult
	 */
	public HashMap<String, Integer> getPayment(int paymentValue, String goods_buy_payment_code) {
		HashMap<String, Integer> reResult = new HashMap<String, Integer>(); 
		
		int returnResult = 0;
		
		GoodsBuyingPayment payment = sales_BuyingMapper.getPayment(goods_buy_payment_code);
		
		int resultTotal = payment.getBuy_total();
		int paymentDB = payment.getPayment();
		int AccountsDB = payment.getAccounts_payable();
		int Sumresult = paymentValue + paymentDB;
		int result = resultTotal - Sumresult;
		int TotalAccounts = resultTotal - AccountsDB;
		
		if(result == 0) {
			reResult.put("value", result);
			reResult.put("result", 10);
			returnResult = result;
		}else if(result < 0){
			result = 0;
			reResult.put("value", result);
			reResult.put("payment", AccountsDB);
			reResult.put("result", 0);
		}else {
			reResult.put("value", result);
			reResult.put("result", 10);
		}
		
		log.info(" reResult :{}", reResult);
		return reResult;
	}
	
	/**
	 * 상품매입결제 수정
	 * @param goodsBuyingPayment
	 * @return result
	 */
	public int modifyGoodsBuyingPayment(GoodsBuyingPayment goodsBuyingPayment) {
		int result = 0;
		int resultPayment = sales_BuyingMapper.getPaymentCheck(goodsBuyingPayment.getGoods_buy_payment_code());

		int sumPayment = resultPayment + goodsBuyingPayment.getPayment();

		goodsBuyingPayment.setPayment(sumPayment);
		sales_BuyingMapper.modifyGoodsBuyingPayment(goodsBuyingPayment);
		
		return result;
	}
}
