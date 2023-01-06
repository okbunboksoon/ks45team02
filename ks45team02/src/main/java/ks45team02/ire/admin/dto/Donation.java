package ks45team02.ire.admin.dto;

public class Donation {

	private String donationCode;
	private String userId;
	private String rawMaterialsCo2Code;
	private String donationAmount;
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
	public String getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(String donationAmount) {
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
		return "Donation [donationCode=" + donationCode + ", userId=" + userId + ", rawMaterialsCo2Code="
				+ rawMaterialsCo2Code + ", donationAmount=" + donationAmount + ", donationDate=" + donationDate
				+ ", donationStatus=" + donationStatus + "]";
	}

	
	
}
