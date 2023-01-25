package ks45team02.ire.user.dto;

public class UserOrder {
	
	private String orderCode;
	private String goodsName;
	private String goodsPrice;
	private int orderAmount;
	private int orderPaymentAmount;
	private int usePoint;
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
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getOrderPaymentAmount() {
		return orderPaymentAmount;
	}
	public void setOrderPaymentAmount(int orderPaymentAmount) {
		this.orderPaymentAmount = orderPaymentAmount;
	}
	public int getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
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
		builder.append(", goodsPrice=");
		builder.append(goodsPrice);
		builder.append(", orderAmount=");
		builder.append(orderAmount);
		builder.append(", orderPaymentAmount=");
		builder.append(orderPaymentAmount);
		builder.append(", usePoint=");
		builder.append(usePoint);
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
