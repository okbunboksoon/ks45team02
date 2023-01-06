package ks45team02.ire.admin.dto;

public class GoodsEmission {

	private String fabric;
	private float carbon_dioxide_emission_level;
	private float upcycling_carbon_dioxide_emission_level;
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsEmission [fabric=");
		builder.append(fabric);
		builder.append(", carbon_dioxide_emission_level=");
		builder.append(carbon_dioxide_emission_level);
		builder.append(", upcycling_carbon_dioxide_emission_level=");
		builder.append(upcycling_carbon_dioxide_emission_level);
		builder.append("]");
		return builder.toString();
	}

	
}
