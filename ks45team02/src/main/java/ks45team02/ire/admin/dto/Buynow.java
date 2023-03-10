package ks45team02.ire.admin.dto;

public class Buynow {
	private String buynowCode;
	private String userId;
	private String goodsCode;
	private String goodsName;
	private String categoryMediumCode;
	private String categoryMediumName;
	private int goodsPrice;
	private int buynowAmount;
	private int expectedAmount;
	private int usePoint;
	private int finalPaymentAmount;
	private String regDate;
	private char buynowDeleteState;
	
	public String getBuynowCode() {
		return buynowCode;
	}
	public void setBuynowCode(String buynowCode) {
		this.buynowCode = buynowCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getCategoryMediumCode() {
		return categoryMediumCode;
	}
	public void setCategoryMediumCode(String categoryMediumCode) {
		this.categoryMediumCode = categoryMediumCode;
	}
	public String getCategoryMediumName() {
		return categoryMediumName;
	}
	public void setCategoryMediumName(String categoryMediumName) {
		this.categoryMediumName = categoryMediumName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getBuynowAmount() {
		return buynowAmount;
	}
	public void setBuynowAmount(int buynowAmount) {
		this.buynowAmount = buynowAmount;
	}
	public int getExpectedAmount() {
		return expectedAmount;
	}
	public void setExpectedAmount(int expectedAmount) {
		this.expectedAmount = expectedAmount;
	}
	public int getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}
	public int getFinalPaymentAmount() {
		return finalPaymentAmount;
	}
	public void setFinalPaymentAmount(int finalPaymentAmount) {
		this.finalPaymentAmount = finalPaymentAmount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public char getBuynowDeleteState() {
		return buynowDeleteState;
	}
	public void setBuynowDeleteState(char buynowDeleteState) {
		this.buynowDeleteState = buynowDeleteState;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buynow [buynowCode=");
		builder.append(buynowCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", categoryMediumCode=");
		builder.append(categoryMediumCode);
		builder.append(", categoryMediumName=");
		builder.append(categoryMediumName);
		builder.append(", goodsPrice=");
		builder.append(goodsPrice);
		builder.append(", buynowAmount=");
		builder.append(buynowAmount);
		builder.append(", expectedAmount=");
		builder.append(expectedAmount);
		builder.append(", usePoint=");
		builder.append(usePoint);
		builder.append(", finalPaymentAmount=");
		builder.append(finalPaymentAmount);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", buynowDeleteState=");
		builder.append(buynowDeleteState);
		builder.append("]");
		return builder.toString();
	}
	
	
}

