package ks45team02.ire.admin.dto;

public class Donation {

	private String donationNum;
	private String userId;
	private String goodsC02Code;
	private String donationAmount;
	private String donationDate;
	private String donationStatus;
	
	public String getDonationNum() {
		return donationNum;
	}
	public void setDonationNum(String donationNum) {
		this.donationNum = donationNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoodsC02Code() {
		return goodsC02Code;
	}
	public void setGoodsC02Code(String goodsC02Code) {
		this.goodsC02Code = goodsC02Code;
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
		return "Donation [donationNum=" + donationNum + ", userId=" + userId + ", goodsC02Code=" + goodsC02Code
				+ ", donationAmount=" + donationAmount + ", donationDate=" + donationDate + ", donationStatus="
				+ donationStatus + "]";
	}
	
	
}
