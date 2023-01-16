package ks45team02.ire.admin.dto;

public class RawMaterialsEmissionStatisticsMonth {

	private String raw_materials_monthgroup;
	private Float carbon_dioxide_emission_sum;
	private String user_id;
	private String reg_date;
	private String year_and_month;
	private String raw_materials_yeargroup;
	public String getRaw_materials_monthgroup() {
		return raw_materials_monthgroup;
	}
	public void setRaw_materials_monthgroup(String raw_materials_monthgroup) {
		this.raw_materials_monthgroup = raw_materials_monthgroup;
	}
	public Float getCarbon_dioxide_emission_sum() {
		return carbon_dioxide_emission_sum;
	}
	public void setCarbon_dioxide_emission_sum(Float carbon_dioxide_emission_sum) {
		this.carbon_dioxide_emission_sum = carbon_dioxide_emission_sum;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getYear_and_month() {
		return year_and_month;
	}
	public void setYear_and_month(String year_and_month) {
		this.year_and_month = year_and_month;
	}
	public String getRaw_materials_yeargroup() {
		return raw_materials_yeargroup;
	}
	public void setRaw_materials_yeargroup(String raw_materials_yeargroup) {
		this.raw_materials_yeargroup = raw_materials_yeargroup;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RawMaterialsEmissionStatisticsMonth [raw_materials_monthgroup=");
		builder.append(raw_materials_monthgroup);
		builder.append(", carbon_dioxide_emission_sum=");
		builder.append(carbon_dioxide_emission_sum);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", reg_date=");
		builder.append(reg_date);
		builder.append(", year_and_month=");
		builder.append(year_and_month);
		builder.append(", raw_materials_yeargroup=");
		builder.append(raw_materials_yeargroup);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
