package ks45team02.ire.admin.dto;

public class Goods {

	private String goods_code;
	private String goods_name;
	private String category_medium_num;
	private int goods_price;
	private String goods_color;
	private String goods_size;
	private String goods_reg_date;
	private String goods_sangse;
	private String goods_image;
	private String fabric;
	private String rate;
	private float upcycling_carbon_dioxide_emission_level;
	
	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getCategory_medium_num() {
		return category_medium_num;
	}
	public void setCategory_medium_num(String category_medium_num) {
		this.category_medium_num = category_medium_num;
	}
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_color() {
		return goods_color;
	}
	public void setGoods_color(String goods_color) {
		this.goods_color = goods_color;
	}
	public String getGoods_size() {
		return goods_size;
	}
	public void setGoods_size(String goods_size) {
		this.goods_size = goods_size;
	}
	public String getGoods_reg_date() {
		return goods_reg_date;
	}
	public void setGoods_reg_date(String goods_reg_date) {
		this.goods_reg_date = goods_reg_date;
	}
	public String getGoods_sangse() {
		return goods_sangse;
	}
	public void setGoods_sangse(String goods_sangse) {
		this.goods_sangse = goods_sangse;
	}
	public String getGoods_image() {
		return goods_image;
	}
	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public float getUpcycling_carbon_dioxide_emission_level() {
		return upcycling_carbon_dioxide_emission_level;
	}
	public void setUpcycling_carbon_dioxide_emission_level(float upcycling_carbon_dioxide_emission_level) {
		this.upcycling_carbon_dioxide_emission_level = upcycling_carbon_dioxide_emission_level;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [goods_code=");
		builder.append(goods_code);
		builder.append(", goods_name=");
		builder.append(goods_name);
		builder.append(", category_medium_num=");
		builder.append(category_medium_num);
		builder.append(", goods_price=");
		builder.append(goods_price);
		builder.append(", goods_color=");
		builder.append(goods_color);
		builder.append(", goods_size=");
		builder.append(goods_size);
		builder.append(", goods_reg_date=");
		builder.append(goods_reg_date);
		builder.append(", goods_sangse=");
		builder.append(goods_sangse);
		builder.append(", goods_image=");
		builder.append(goods_image);
		builder.append(", fabric=");
		builder.append(fabric);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", upcycling_carbon_dioxide_emission_level=");
		builder.append(upcycling_carbon_dioxide_emission_level);
		builder.append("]");
		return builder.toString();
	}
	
	

}
