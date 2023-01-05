package ks45team02.ire.admin.dto;

public class UnitPrice {

	private String goodsCode;
	private int factoryGoodsPrice;
	private int goodsPrice;
	
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public int getFactoryGoodsPrice() {
		return factoryGoodsPrice;
	}
	public void setFactoryGoodsPrice(int factoryGoodsPrice) {
		this.factoryGoodsPrice = factoryGoodsPrice;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnitPrice [goodsCode=");
		builder.append(goodsCode);
		builder.append(", factoryGoodsPrice=");
		builder.append(factoryGoodsPrice);
		builder.append(", goodsPrice=");
		builder.append(goodsPrice);
		builder.append("]");
		return builder.toString();
	}	
}
