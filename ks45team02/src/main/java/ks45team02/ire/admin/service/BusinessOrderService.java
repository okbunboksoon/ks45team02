package ks45team02.ire.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team02.ire.admin.controller.BusinessOrderController;
import ks45team02.ire.admin.dto.Business;
import ks45team02.ire.admin.dto.BusinessOrder;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.mapper.BusinessMapper;
import ks45team02.ire.admin.mapper.BusinessOrderMapper;
import ks45team02.ire.admin.mapper.GoodsMapper;

@Service
public class BusinessOrderService {

	private BusinessOrderMapper businessOrderMapper;
	private final GoodsMapper goodsMapper;
	private final BusinessMapper businessMapper;
	private final Sales_BuyingService sales_BuyingService;
	
	public BusinessOrderService(BusinessOrderMapper businessOrderMapper, GoodsMapper goodsMapper
							   ,BusinessMapper businessMapper, Sales_BuyingService sales_BuyingService) {
		
		this.businessOrderMapper = businessOrderMapper;
		this.goodsMapper = goodsMapper;
		this.businessMapper = businessMapper;
		this.sales_BuyingService = sales_BuyingService;
	}
	
	/**
	 * 발주 목록 전체 조회
	 * @return businessOrderList
	 */
	public List<BusinessOrder> getListBusinessOrder(){
		
		List<BusinessOrder> businessOrderList = businessOrderMapper.getListBusinessOrder();
		
		
		return businessOrderList;
	}
	
	public List<BusinessOrder> getListBusinessOrderRe(){
		
		List<BusinessOrder> businessOrderList = businessOrderMapper.getListBusinessOrderRe();
		
		
		return businessOrderList;
	}
	/**
	 * 상품 검색
	 * @param searchKey
	 * @param searchValue
	 * @return List<Goods>
	 */
	public List<Goods> searchGoods(String searchKey, String searchValue){
		
		if(searchKey != null && searchValue != null) {
			switch(searchKey) {
			case "goodsCode"
			: searchKey = "goods_code";
			break;
			case "goodsName"
			: searchKey = "goods_name";
			break;
			}
		}
		
		List<Goods> goodsList = goodsMapper.searchGoodsUnitprice(searchKey, searchValue);
		
		return goodsList;
	}
	
	/**
	 * 거래처 검색
	 * @param searchKey
	 * @param searchValue
	 * @return List<Goods>
	 */
	public List<Business> searchBusiness(String searchKey, String searchValue){
		
		if(searchKey != null && searchValue != null) {
			switch(searchKey) {
			case "businessCode"
			: searchKey = "business_code";
			
			break; 
			case "businessName"
			: searchKey = "business_name";
			break;
			}
		}
		
		List<Business> businessList = businessMapper.searchBusinessContract(searchKey, searchValue);
		
		return businessList;
	}
	
	/**
	 * 발주 등록 처리
	 * @param businessOrder
	 * @return result
	 */
	public int addBusinessOrder(BusinessOrder businessOrder) {
		
		int result = 0;
		result = businessOrderMapper.addBusinessOrder(businessOrder);
		
		return result;
	}
	
	/**
	 * 발주 삭제 처리
	 * @param businessOrderCode
	 * @return result
	 */
	public int deleteBusinessOrder(String businessOrderCode) {
		
		int result = 0;
		result = businessOrderMapper.deleteBusinessOrder(businessOrderCode);
		
		return result;
	}
	
	/**
	 * 발주 수정 화면
	 * @param businessOrderCode
	 * @return businessorderinfo
	 */
	public List<BusinessOrder> getListBusinessOrderByCode(String businessOrderCode){
		
		 List<BusinessOrder> businessorderinfo =  businessOrderMapper.getListBusinessOrderByCode(businessOrderCode);
		
		return businessorderinfo;
	}
	
	/**
	 * 발주 수정 처리
	 * @param businessOrder
	 * @return result
	 */
	public int modifyBusinessOrder(BusinessOrder businessOrder){
		
		int result = 0;
		result = businessOrderMapper.modifyBusinessOrder(businessOrder);
		
		  if(result == 1) { sales_BuyingService.addGoodsBuying(businessOrder); }
		 
		return result;
	}
}
