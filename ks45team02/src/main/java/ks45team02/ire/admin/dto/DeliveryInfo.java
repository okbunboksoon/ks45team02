package ks45team02.ire.admin.dto;

public class DeliveryInfo {
	private String delInfoCode;
	private String buynowBasketTotalCode;
	private String buynowBasketCategory;
	private String userId;
	private int deliveryPostnumAddr;
	private String deliveryAddr;
	private String deliveryDetailAddr;
	private String recipientName;
	private String recipientPhone;
	
	public String getDelInfoCode() {
		return delInfoCode;
	}
	public void setDelInfoCode(String delInfoCode) {
		this.delInfoCode = delInfoCode;
	}
	public String getBuynowBasketTotalCode() {
		return buynowBasketTotalCode;
	}
	public void setBuynowBasketTotalCode(String buynowBasketTotalCode) {
		this.buynowBasketTotalCode = buynowBasketTotalCode;
	}
	public String getBuynowBasketCategory() {
		return buynowBasketCategory;
	}
	public void setBuynowBasketCategory(String buynowBasketCategory) {
		this.buynowBasketCategory = buynowBasketCategory;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getDeliveryPostnumAddr() {
		return deliveryPostnumAddr;
	}
	public void setDeliveryPostnumAddr(int deliveryPostnumAddr) {
		this.deliveryPostnumAddr = deliveryPostnumAddr;
	}
	public String getDeliveryAddr() {
		return deliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	public String getDeliveryDetailAddr() {
		return deliveryDetailAddr;
	}
	public void setDeliveryDetailAddr(String deliveryDetailAddr) {
		this.deliveryDetailAddr = deliveryDetailAddr;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeliveryInfo [delInfoCode=");
		builder.append(delInfoCode);
		builder.append(", buynowBasketTotalCode=");
		builder.append(buynowBasketTotalCode);
		builder.append(", buynowBasketCategory=");
		builder.append(buynowBasketCategory);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", deliveryPostnumAddr=");
		builder.append(deliveryPostnumAddr);
		builder.append(", deliveryAddr=");
		builder.append(deliveryAddr);
		builder.append(", deliveryDetailAddr=");
		builder.append(deliveryDetailAddr);
		builder.append(", recipientName=");
		builder.append(recipientName);
		builder.append(", recipientPhone=");
		builder.append(recipientPhone);
		builder.append("]");
		return builder.toString();
	}
	
}
