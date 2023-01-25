package ks45team02.ire.admin.dto;

public class BusinessOrder {

	private String businessOrderCode;
	private String userId;
	private String contractCode;
	private String businessCode;
	private int businessOrderAmount;
	private String businessOrderDate;
	private String businessOrderResult;
	private String businessManagerName;             
	private String goodsCode;
	private int goodsOrderAmount;
	private int factoryGoodsPrice;
	private String businessConfirmOrderDate;
	private String expectDate;
	
	private Business business;

	private GoodsBuying goodsBuying;
	
	public GoodsBuying getGoodsBuying() {
		return goodsBuying;
	}

	public void setGoodsBuying(GoodsBuying goodsBuying) {
		this.goodsBuying = goodsBuying;
	}

	public String getBusinessOrderCode() {
		return businessOrderCode;
	}

	public void setBusinessOrderCode(String businessOrderCode) {
		this.businessOrderCode = businessOrderCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public int getBusinessOrderAmount() {
		return businessOrderAmount;
	}

	public void setBusinessOrderAmount(int businessOrderAmount) {
		this.businessOrderAmount = businessOrderAmount;
	}

	public String getBusinessOrderDate() {
		return businessOrderDate;
	}

	public void setBusinessOrderDate(String businessOrderDate) {
		this.businessOrderDate = businessOrderDate;
	}

	public String getBusinessOrderResult() {
		return businessOrderResult;
	}

	public void setBusinessOrderResult(String businessOrderResult) {
		this.businessOrderResult = businessOrderResult;
	}

	public String getBusinessManagerName() {
		return businessManagerName;
	}

	public void setBusinessManagerName(String businessManagerName) {
		this.businessManagerName = businessManagerName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public int getGoodsOrderAmount() {
		return goodsOrderAmount;
	}

	public void setGoodsOrderAmount(int goodsOrderAmount) {
		this.goodsOrderAmount = goodsOrderAmount;
	}

	public int getFactoryGoodsPrice() {
		return factoryGoodsPrice;
	}

	public void setFactoryGoodsPrice(int factoryGoodsPrice) {
		this.factoryGoodsPrice = factoryGoodsPrice;
	}

	public String getBusinessConfirmOrderDate() {
		return businessConfirmOrderDate;
	}

	public void setBusinessConfirmOrderDate(String businessConfirmOrderDate) {
		this.businessConfirmOrderDate = businessConfirmOrderDate;
	}

	public String getExpectDate() {
		return expectDate;
	}

	public void setExpectDate(String expectDate) {
		this.expectDate = expectDate;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusinessOrder [businessOrderCode=");
		builder.append(businessOrderCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", contractCode=");
		builder.append(contractCode);
		builder.append(", businessCode=");
		builder.append(businessCode);
		builder.append(", businessOrderAmount=");
		builder.append(businessOrderAmount);
		builder.append(", businessOrderDate=");
		builder.append(businessOrderDate);
		builder.append(", businessOrderResult=");
		builder.append(businessOrderResult);
		builder.append(", businessManagerName=");
		builder.append(businessManagerName);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", goodsOrderAmount=");
		builder.append(goodsOrderAmount);
		builder.append(", factoryGoodsPrice=");
		builder.append(factoryGoodsPrice);
		builder.append(", businessConfirmOrderDate=");
		builder.append(businessConfirmOrderDate);
		builder.append(", expectDate=");
		builder.append(expectDate);
		builder.append(", business=");
		builder.append(business);
		builder.append(", goodsBuying=");
		builder.append(goodsBuying);
		builder.append("]");
		return builder.toString();
	}

}
