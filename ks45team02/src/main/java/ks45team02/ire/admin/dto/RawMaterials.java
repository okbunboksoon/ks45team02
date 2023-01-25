package ks45team02.ire.admin.dto;


public class RawMaterials {

	private String userId;
	private String rawMaterialsIncomingDate;
	private String rawMaterialsOutgoingDate;
	private String rawMaterialsCode;
	private String goodsCo2Code;
	private int rawMaterialsAmount;
	private User user;

	@Override
	public String toString() {
		return "RawMaterials{" +
				"userId='" + userId + '\'' +
				", rawMaterialsIncomingDate='" + rawMaterialsIncomingDate + '\'' +
				", rawMaterialsOutgoingDate='" + rawMaterialsOutgoingDate + '\'' +
				", rawMaterialsCode='" + rawMaterialsCode + '\'' +
				", goodsCo2Code='" + goodsCo2Code + '\'' +
				", rawMaterialsAmount=" + rawMaterialsAmount +
				", user=" + user +
				'}';
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRawMaterialsIncomingDate() {
		return rawMaterialsIncomingDate;
	}

	public void setRawMaterialsIncomingDate(String rawMaterialsIncomingDate) {
		this.rawMaterialsIncomingDate = rawMaterialsIncomingDate;
	}

	public String getRawMaterialsOutgoingDate() {
		return rawMaterialsOutgoingDate;
	}

	public void setRawMaterialsOutgoingDate(String rawMaterialsOutgoingDate) {
		this.rawMaterialsOutgoingDate = rawMaterialsOutgoingDate;
	}

	public String getRawMaterialsCode() {
		return rawMaterialsCode;
	}

	public void setRawMaterialsCode(String rawMaterialsCode) {
		this.rawMaterialsCode = rawMaterialsCode;
	}

	public String getGoodsCo2Code() {
		return goodsCo2Code;
	}

	public void setGoodsCo2Code(String goodsCo2Code) {
		this.goodsCo2Code = goodsCo2Code;
	}

	public int getRawMaterialsAmount() {
		return rawMaterialsAmount;
	}

	public void setRawMaterialsAmount(int rawMaterialsAmount) {
		this.rawMaterialsAmount = rawMaterialsAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
