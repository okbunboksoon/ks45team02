package ks45team02.ire.admin.dto;

public class GoodsBuying {

	private String goods_buying_code;
	private String business_code;
	private String business_name;
	private String goods_code;
	private int buy_count;
	private int goods_price;
	private int buy_price;
	private int buy_vat;
	private int buy_total;
	public String getGoods_buying_code() {
		return goods_buying_code;
	}
	public void setGoods_buying_code(String goods_buying_code) {
		this.goods_buying_code = goods_buying_code;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	public int getBuy_count() {
		return buy_count;
	}
	public void setBuy_count(int buy_count) {
		this.buy_count = buy_count;
	}
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sales_Buying [goods_buying_code=");
		builder.append(goods_buying_code);
		builder.append(", business_code=");
		builder.append(business_code);
		builder.append(", business_name=");
		builder.append(business_name);
		builder.append(", goods_code=");
		builder.append(goods_code);
		builder.append(", buy_count=");
		builder.append(buy_count);
		builder.append(", goods_price=");
		builder.append(goods_price);
		builder.append(", buy_price=");
		builder.append(buy_price);
		builder.append(", buy_vat=");
		builder.append(buy_vat);
		builder.append(", buy_total=");
		builder.append(buy_total);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
