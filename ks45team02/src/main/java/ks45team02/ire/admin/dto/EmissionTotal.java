package ks45team02.ire.admin.dto;

public class EmissionTotal {

	private String goods_code;
	private float carbon_dioxide_emission_level;
	private float upcycling_carbon_dioxide_emission_level;
	private String decrease_rate;
	private Goods goods;
	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	public float getCarbon_dioxide_emission_level() {
		return carbon_dioxide_emission_level;
	}
	public void setCarbon_dioxide_emission_level(float carbon_dioxide_emission_level) {
		this.carbon_dioxide_emission_level = carbon_dioxide_emission_level;
	}
	public float getUpcycling_carbon_dioxide_emission_level() {
		return upcycling_carbon_dioxide_emission_level;
	}
	public void setUpcycling_carbon_dioxide_emission_level(float upcycling_carbon_dioxide_emission_level) {
		this.upcycling_carbon_dioxide_emission_level = upcycling_carbon_dioxide_emission_level;
	}
	public String getDecrease_rate() {
		return decrease_rate;
	}
	public void setDecrease_rate(String decrease_rate) {
		this.decrease_rate = decrease_rate;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmissionTotal [goods_code=");
		builder.append(goods_code);
		builder.append(", carbon_dioxide_emission_level=");
		builder.append(carbon_dioxide_emission_level);
		builder.append(", upcycling_carbon_dioxide_emission_level=");
		builder.append(upcycling_carbon_dioxide_emission_level);
		builder.append(", decrease_rate=");
		builder.append(decrease_rate);
		builder.append(", goods=");
		builder.append(goods);
		builder.append("]");
		return builder.toString();
	}
	
	
}
