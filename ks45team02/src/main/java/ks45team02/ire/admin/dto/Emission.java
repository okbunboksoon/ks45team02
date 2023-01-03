package ks45team02.ire.admin.dto;

public class Emission {

	private String goods_co2_code;
	private String goods_category;
	private String goods_size;
	private float carbon_dioxide_emission_level;
	public String getGoods_co2_code() {
		return goods_co2_code;
	}
	public void setGoods_co2_code(String goods_co2_code) {
		this.goods_co2_code = goods_co2_code;
	}
	public String getGoods_category() {
		return goods_category;
	}
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}
	public String getGoods_size() {
		return goods_size;
	}
	public void setGoods_size(String goods_size) {
		this.goods_size = goods_size;
	}
	public float getCarbon_dioxide_emission_level() {
		return carbon_dioxide_emission_level;
	}
	public void setCarbon_dioxide_emission_level(float carbon_dioxide_emission_level) {
		this.carbon_dioxide_emission_level = carbon_dioxide_emission_level;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emission [goods_co2_code=");
		builder.append(goods_co2_code);
		builder.append(", goods_category=");
		builder.append(goods_category);
		builder.append(", goods_size=");
		builder.append(goods_size);
		builder.append(", carbon_dioxide_emission_level=");
		builder.append(carbon_dioxide_emission_level);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
