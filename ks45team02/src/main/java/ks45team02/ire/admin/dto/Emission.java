package ks45team02.ire.admin.dto;

public class Emission {

	private String raw_materials_co2_code;
	private String raw_materials_category;
	private String raw_materials_size;
	private float carbon_dioxide_emission_level;
	public String getRaw_materials_co2_code() {
		return raw_materials_co2_code;
	}
	public void setRaw_materials_co2_code(String raw_materials_co2_code) {
		this.raw_materials_co2_code = raw_materials_co2_code;
	}
	public String getRaw_materials_category() {
		return raw_materials_category;
	}
	public void setRaw_materials_category(String raw_materials_category) {
		this.raw_materials_category = raw_materials_category;
	}
	public String getRaw_materials_size() {
		return raw_materials_size;
	}
	public void setRaw_materials_size(String raw_materials_size) {
		this.raw_materials_size = raw_materials_size;
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
		builder.append("Emission [raw_materials_co2_code=");
		builder.append(raw_materials_co2_code);
		builder.append(", raw_materials_category=");
		builder.append(raw_materials_category);
		builder.append(", raw_materials_size=");
		builder.append(raw_materials_size);
		builder.append(", carbon_dioxide_emission_level=");
		builder.append(carbon_dioxide_emission_level);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
