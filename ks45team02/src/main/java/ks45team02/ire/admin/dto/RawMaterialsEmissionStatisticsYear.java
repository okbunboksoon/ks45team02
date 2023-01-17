package ks45team02.ire.admin.dto;

public class RawMaterialsEmissionStatisticsYear {

	private String raw_materials_yeargroup;
	private String reg_date;
	private String user_id;
	private String year;
	private float Jan;
	private float Feb;
	private float Mar;
	private float Apr;
	private float May;
	private float Jun;
	private float Jul;
	private float Aug;
	private float Sept;
	private float Oct;
	private float Nov;
	private float Dec;
	public String getRaw_materials_yeargroup() {
		return raw_materials_yeargroup;
	}
	public void setRaw_materials_yeargroup(String raw_materials_yeargroup) {
		this.raw_materials_yeargroup = raw_materials_yeargroup;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public float getJan() {
		return Jan;
	}
	public void setJan(float jan) {
		Jan = jan;
	}
	public float getFeb() {
		return Feb;
	}
	public void setFeb(float feb) {
		Feb = feb;
	}
	public float getMar() {
		return Mar;
	}
	public void setMar(float mar) {
		Mar = mar;
	}
	public float getApr() {
		return Apr;
	}
	public void setApr(float apr) {
		Apr = apr;
	}
	public float getMay() {
		return May;
	}
	public void setMay(float may) {
		May = may;
	}
	public float getJun() {
		return Jun;
	}
	public void setJun(float jun) {
		Jun = jun;
	}
	public float getJul() {
		return Jul;
	}
	public void setJul(float jul) {
		Jul = jul;
	}
	public float getAug() {
		return Aug;
	}
	public void setAug(float aug) {
		Aug = aug;
	}
	public float getSept() {
		return Sept;
	}
	public void setSept(float sept) {
		Sept = sept;
	}
	public float getOct() {
		return Oct;
	}
	public void setOct(float oct) {
		Oct = oct;
	}
	public float getNov() {
		return Nov;
	}
	public void setNov(float nov) {
		Nov = nov;
	}
	public float getDec() {
		return Dec;
	}
	public void setDec(float dec) {
		Dec = dec;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RawMaterialsEmissionStatisticsYear [raw_materials_yeargroup=");
		builder.append(raw_materials_yeargroup);
		builder.append(", reg_date=");
		builder.append(reg_date);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", year=");
		builder.append(year);
		builder.append(", Jan=");
		builder.append(Jan);
		builder.append(", Feb=");
		builder.append(Feb);
		builder.append(", Mar=");
		builder.append(Mar);
		builder.append(", Apr=");
		builder.append(Apr);
		builder.append(", May=");
		builder.append(May);
		builder.append(", Jun=");
		builder.append(Jun);
		builder.append(", Jul=");
		builder.append(Jul);
		builder.append(", Aug=");
		builder.append(Aug);
		builder.append(", Sept=");
		builder.append(Sept);
		builder.append(", Oct=");
		builder.append(Oct);
		builder.append(", Nov=");
		builder.append(Nov);
		builder.append(", Dec=");
		builder.append(Dec);
		builder.append("]");
		return builder.toString();
	}

	
}
