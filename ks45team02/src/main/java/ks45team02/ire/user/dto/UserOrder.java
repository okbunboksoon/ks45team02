package ks45team02.ire.user.dto;

public class UserOrder {
	
	private String orderCode;
	private String goodsName;
	private int orderPaymentAmount;
	private String orderDate;
	private String orderCount;
	private String orderState;
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getOrderPaymentAmount() {
		return orderPaymentAmount;
	}
	public void setOrderPaymentAmount(int orderPaymentAmount) {
		this.orderPaymentAmount = orderPaymentAmount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserOrder [orderCode=");
		builder.append(orderCode);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", orderPaymentAmount=");
		builder.append(orderPaymentAmount);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", orderCount=");
		builder.append(orderCount);
		builder.append(", orderState=");
		builder.append(orderState);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
