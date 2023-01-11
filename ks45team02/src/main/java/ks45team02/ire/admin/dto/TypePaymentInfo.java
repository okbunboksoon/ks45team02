package ks45team02.ire.admin.dto;

public class TypePaymentInfo {

	private String paymentTypeCode;
	private String userId;
	private String paymentType;
	private String paymentBank;
	private String paymentCardNumber;
	private String paymentAccountCode;
	private String paymentPhoneTelco;
	private String paymentPhoneNum;
	private char paymentTypeDeleteState;
	
	public String getPaymentTypeCode() {
		return paymentTypeCode;
	}
	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentBank() {
		return paymentBank;
	}
	public void setPaymentBank(String paymentBank) {
		this.paymentBank = paymentBank;
	}
	public String getPaymentCardNumber() {
		return paymentCardNumber;
	}
	public void setPaymentCardNumber(String paymentCardNumber) {
		this.paymentCardNumber = paymentCardNumber;
	}
	public String getPaymentAccountCode() {
		return paymentAccountCode;
	}
	public void setPaymentAccountCode(String paymentAccountCode) {
		this.paymentAccountCode = paymentAccountCode;
	}
	public String getPaymentPhoneTelco() {
		return paymentPhoneTelco;
	}
	public void setPaymentPhoneTelco(String paymentPhoneTelco) {
		this.paymentPhoneTelco = paymentPhoneTelco;
	}
	public String getPaymentPhoneNum() {
		return paymentPhoneNum;
	}
	public void setPaymentPhoneNum(String paymentPhoneNum) {
		this.paymentPhoneNum = paymentPhoneNum;
	}
	public char getPaymentTypeDeleteState() {
		return paymentTypeDeleteState;
	}
	public void setPaymentTypeDeleteState(char paymentTypeDeleteState) {
		this.paymentTypeDeleteState = paymentTypeDeleteState;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TypePaymentInfo [paymentTypeCode=");
		builder.append(paymentTypeCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", paymentType=");
		builder.append(paymentType);
		builder.append(", paymentBank=");
		builder.append(paymentBank);
		builder.append(", paymentCardNumber=");
		builder.append(paymentCardNumber);
		builder.append(", paymentAccountCode=");
		builder.append(paymentAccountCode);
		builder.append(", paymentPhoneTelco=");
		builder.append(paymentPhoneTelco);
		builder.append(", paymentPhoneNum=");
		builder.append(paymentPhoneNum);
		builder.append(", paymentTypeDeleteState=");
		builder.append(paymentTypeDeleteState);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
