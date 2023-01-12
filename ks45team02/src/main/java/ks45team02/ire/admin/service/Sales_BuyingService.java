package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.Business;
import ks45team02.ire.admin.dto.BusinessOrder;
import ks45team02.ire.admin.dto.GoodsBuying;
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
		  
		  goodsBuying.setBusinessCode(Business.getBusinessCode());
		  goodsBuying.setBusinessName(Business.getBusinessName());
		  goodsBuying.setGoodsCode(businessOrder.getGoodsCode());
		  goodsBuying.setGoodsOrderAmount(getGoodsOrderAmount);
		  goodsBuying.setFactoryGoodsPrice(getFactoryGoodsPrice);
		  goodsBuying.setBuy_price(buy_price);
		  goodsBuying.setBuy_vat(buy_vat);
		  goodsBuying.setBuy_total(buy_total);	  
		  
		  sales_BuyingMapper.addGoodsBuying(goodsBuying);
		  }
				 

}
