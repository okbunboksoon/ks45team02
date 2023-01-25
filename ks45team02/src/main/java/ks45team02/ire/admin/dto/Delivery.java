package ks45team02.ire.admin.dto;

public class Delivery {
    private String deliveryCode;
    private String delInfoCode;
    private String userId;
    private String deliveryNum;
    private String businessCode;
    private String deliveryState;
    private String paymentCompleteCode;

    private DeliveryInfo deliveryInfo;

	public String getDeliveryCode() {
		return deliveryCode;
	}

	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	public String getDelInfoCode() {
		return delInfoCode;
	}

	public void setDelInfoCode(String delInfoCode) {
		this.delInfoCode = delInfoCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeliveryNum() {
		return deliveryNum;
	}

	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getPaymentCompleteCode() {
		return paymentCompleteCode;
	}

	public void setPaymentCompleteCode(String paymentCompleteCode) {
		this.paymentCompleteCode = paymentCompleteCode;
	}

	public DeliveryInfo getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Delivery [deliveryCode=");
		builder.append(deliveryCode);
		builder.append(", delInfoCode=");
		builder.append(delInfoCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", deliveryNum=");
		builder.append(deliveryNum);
		builder.append(", businessCode=");
		builder.append(businessCode);
		builder.append(", deliveryState=");
		builder.append(deliveryState);
		builder.append(", paymentCompleteCode=");
		builder.append(paymentCompleteCode);
		builder.append(", deliveryInfo=");
		builder.append(deliveryInfo);
		builder.append("]");
		return builder.toString();
	}

}
