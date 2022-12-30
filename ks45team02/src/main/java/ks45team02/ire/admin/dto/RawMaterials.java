package ks45team02.ire.admin.dto;

public class RawMaterials {

	
	private int rawmaterialsIncomingDate;
	private int rawmaterialsOutcomingDate;
	private int rawmaterialsNum;
	public User user;
	
	
	@Override
	public String toString() {
		return "RawMaterials [rawmaterialsIncomingDate=" + rawmaterialsIncomingDate + ", rawmaterialsOutcomingDate="
				+ rawmaterialsOutcomingDate + ", rawmaterialsNum=" + rawmaterialsNum + ", user=" + user + "]";
	}
	
	public int getRawmaterialsIncomingDate() {
		return rawmaterialsIncomingDate;
	}
	public void setRawmaterialsIncomingDate(int rawmaterialsIncomingDate) {
		this.rawmaterialsIncomingDate = rawmaterialsIncomingDate;
	}
	public int getRawmaterialsOutcomingDate() {
		return rawmaterialsOutcomingDate;
	}
	public void setRawmaterialsOutcomingDate(int rawmaterialsOutcomingDate) {
		this.rawmaterialsOutcomingDate = rawmaterialsOutcomingDate;
	}
	public int getRawmaterialsNum() {
		return rawmaterialsNum;
	}
	public void setRawmaterialsNum(int rawmaterialsNum) {
		this.rawmaterialsNum = rawmaterialsNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
