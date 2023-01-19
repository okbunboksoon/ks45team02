package ks45team02.ire.admin.dto;

public class RawMaterialsEmissionStatisticsDay {
	private String raw_materials_daygroup;
	private String rm_incoming_date;
	private float carbon_dioxide_emission_sum;
	private String user_id;
	private String reg_date;
	private String year_and_month;
	private String raw_materials_monthgroup;
	private RawMaterialsIncoming rawMaterialsIncoming;
	public String getRaw_materials_daygroup() {
		return raw_materials_daygroup;
	}
	public void setRaw_materials_daygroup(String raw_materials_daygroup) {
		this.raw_materials_daygroup = raw_materials_daygroup;
	}
	public String getRm_incoming_date() {
		return rm_incoming_date;
	}
	public void setRm_incoming_date(String rm_incoming_date) {
		this.rm_incoming_date = rm_incoming_date;
	}
	public float getCarbon_dioxide_emission_sum() {
		return carbon_dioxide_emission_sum;
	}
	public void setCarbon_dioxide_emission_sum(float carbon_dioxide_emission_sum) {
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
	public String getRaw_materials_monthgroup() {
		return raw_materials_monthgroup;
	}
	public void setRaw_materials_monthgroup(String raw_materials_monthgroup) {
		this.raw_materials_monthgroup = raw_materials_monthgroup;
	}
	public RawMaterialsIncoming getRawMaterialsIncoming() {
		return rawMaterialsIncoming;
	}
	public void setRawMaterialsIncoming(RawMaterialsIncoming rawMaterialsIncoming) {
		this.rawMaterialsIncoming = rawMaterialsIncoming;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RawMaterialsEmissionStatisticsDay [raw_materials_daygroup=");
		builder.append(raw_materials_daygroup);
		builder.append(", rm_incoming_date=");
		builder.append(rm_incoming_date);
		builder.append(", carbon_dioxide_emission_sum=");
		builder.append(carbon_dioxide_emission_sum);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", reg_date=");
		builder.append(reg_date);
		builder.append(", year_and_month=");
		builder.append(year_and_month);
		builder.append(", raw_materials_monthgroup=");
		builder.append(raw_materials_monthgroup);
		builder.append(", rawMaterialsIncoming=");
		builder.append(rawMaterialsIncoming);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
