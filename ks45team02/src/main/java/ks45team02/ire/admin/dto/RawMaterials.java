package ks45team02.ire.admin.dto;

public class RawMaterials {

	
	private String rawmaterialsIncomingDate;
	private String rawmaterialsOutcomingDate;
	private String rawmaterialsNum;
	private String goodsCo2Code;
	private int rawmaterialsAmount;
	public User user;
	@Override
	public String toString() {
		return "RawMaterials [rawmaterialsIncomingDate=" + rawmaterialsIncomingDate + ", rawmaterialsOutcomingDate="
				+ rawmaterialsOutcomingDate + ", rawmaterialsNum=" + rawmaterialsNum + ", goodsCo2Code=" + goodsCo2Code
				+ ", rawmaterialsAmount=" + rawmaterialsAmount + ", user=" + user + "]";
	}
	public String getRawmaterialsIncomingDate() {
		return rawmaterialsIncomingDate;
	}
	public void setRawmaterialsIncomingDate(String rawmaterialsIncomingDate) {
		this.rawmaterialsIncomingDate = rawmaterialsIncomingDate;
	}
	public String getRawmaterialsOutcomingDate() {
		return rawmaterialsOutcomingDate;
	}
	public void setRawmaterialsOutcomingDate(String rawmaterialsOutcomingDate) {
		this.rawmaterialsOutcomingDate = rawmaterialsOutcomingDate;
	}
	public String getRawmaterialsNum() {
		return rawmaterialsNum;
	}
	public void setRawmaterialsNum(String rawmaterialsNum) {
		this.rawmaterialsNum = rawmaterialsNum;
	}
	public String getGoodsCo2Code() {
		return goodsCo2Code;
	}
	public void setGoodsCo2Code(String goodsCo2Code) {
		this.goodsCo2Code = goodsCo2Code;
	}
	public int getRawmaterialsAmount() {
		return rawmaterialsAmount;
	}
	public void setRawmaterialsAmount(int rawmaterialsAmount) {
		this.rawmaterialsAmount = rawmaterialsAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}