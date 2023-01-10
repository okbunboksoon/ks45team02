package ks45team02.ire.admin.dto;

public class CashReceipts {
	
	private String cashCode;
	private String userId;
	private String cashReceiptType;
	private String cashReceiptCode;
	private String paymentTypeCode;
	
	public String getCashCode() {
		return cashCode;
	}
	public void setCashCode(String cashCode) {
		this.cashCode = cashCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCashReceiptType() {
		return cashReceiptType;
	}
	public void setCashReceiptType(String cashReceiptType) {
		this.cashReceiptType = cashReceiptType;
	}
	public String getCashReceiptCode() {
		return cashReceiptCode;
	}
	public void setCashReceiptCode(String cashReceiptCode) {
		this.cashReceiptCode = cashReceiptCode;
	}
	public String getPaymentTypeCode() {
		return paymentTypeCode;
	}
	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CashReceipts [cashCode=");
		builder.append(cashCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", cashReceiptType=");
		builder.append(cashReceiptType);
		builder.append(", cashReceiptCode=");
		builder.append(cashReceiptCode);
		builder.append(", paymentTypeCode=");
		builder.append(paymentTypeCode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
