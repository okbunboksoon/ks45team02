package ks45team02.ire.admin.dto;

public class GoodsBuying {

	private String goods_buying_code;
	private String businessCode;
	private String businessName;
	private String goodsCode;
	private int goodsOrderAmount;
	private int factoryGoodsPrice;
	private int buy_price;
	private int buy_vat;
	private int buy_total;
	private BusinessOrder businessOrder;
	
	public String getGoods_buying_code() {
		return goods_buying_code;
	}
	public void setGoods_buying_code(String goods_buying_code) {
		this.goods_buying_code = goods_buying_code;
	}
	public String getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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
	public int getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
	}
	public int getBuy_vat() {
		return buy_vat;
	}
	public void setBuy_vat(int buy_vat) {
		this.buy_vat = buy_vat;
	}
	public int getBuy_total() {
		return buy_total;
	}
	public void setBuy_total(int buy_total) {
		this.buy_total = buy_total;
	}
	public BusinessOrder getBusinessOrder() {
		return businessOrder;
	}
	public void setBusinessOrder(BusinessOrder businessOrder) {
		this.businessOrder = businessOrder;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsBuying [goods_buying_code=");
		builder.append(goods_buying_code);
		builder.append(", businessCode=");
		builder.append(businessCode);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", goodsOrderAmount=");
		builder.append(goodsOrderAmount);
		builder.append(", factoryGoodsPrice=");
		builder.append(factoryGoodsPrice);
		builder.append(", buy_price=");
		builder.append(buy_price);
		builder.append(", buy_vat=");
		builder.append(buy_vat);
		builder.append(", buy_total=");
		builder.append(buy_total);
		builder.append(", businessOrder=");
		builder.append(businessOrder);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
