package ks45team02.ire.user.dto;

public class UserDonation {
	
	private String donationCode;
	private String userId;
	private String rawMaterialsCo2Code;
	private String rawMaterialsCategory;
	private String rawMaterialsSize;
	private int donationAmount;
	private String donationDate;
	private String donationStatus;
	
	public String getDonationCode() {
		return donationCode;
	}
	public void setDonationCode(String donationCode) {
		this.donationCode = donationCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRawMaterialsCo2Code() {
		return rawMaterialsCo2Code;
	}
	public void setRawMaterialsCo2Code(String rawMaterialsCo2Code) {
		this.rawMaterialsCo2Code = rawMaterialsCo2Code;
	}
	public String getRawMaterialsCategory() {
		return rawMaterialsCategory;
	}
	public void setRawMaterialsCategory(String rawMaterialsCategory) {
		this.rawMaterialsCategory = rawMaterialsCategory;
	}
	public String getRawMaterialsSize() {
		return rawMaterialsSize;
	}
	public void setRawMaterialsSize(String rawMaterialsSize) {
		this.rawMaterialsSize = rawMaterialsSize;
	}
	public int getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(int donationAmount) {
		this.donationAmount = donationAmount;
	}
	public String getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}
	public String getDonationStatus() {
		return donationStatus;
	}
	public void setDonationStatus(String donationStatus) {
		this.donationStatus = donationStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDonation [donationCode=");
		builder.append(donationCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", rawMaterialsCo2Code=");
		builder.append(rawMaterialsCo2Code);
		builder.append(", rawMaterialsCategory=");
		builder.append(rawMaterialsCategory);
		builder.append(", rawMaterialsSize=");
		builder.append(rawMaterialsSize);
		builder.append(", donationAmount=");
		builder.append(donationAmount);
		builder.append(", donationDate=");
		builder.append(donationDate);
		builder.append(", donationStatus=");
		builder.append(donationStatus);
		builder.append("]");
		return builder.toString();
	}
	
	
}
