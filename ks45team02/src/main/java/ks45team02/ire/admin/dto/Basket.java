package ks45team02.ire.admin.dto;

public class Basket {

	private String basketCode;
	private String goodsCode;
	private String basketGroup;
	private String userId;
	private String goodsName;
	private String categoryMediumCode;
	private int goodsPrice;
	private int basketAmount;
	private int eachPaymentAmount;
	private String regDate;
	private String basketState;
	
	public String getBasketCode() {
		return basketCode;
	}
	public void setBasketCode(String basketCode) {
		this.basketCode = basketCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getBasketGroup() {
		return basketGroup;
	}
	public void setBasketGroup(String basketGroup) {
		this.basketGroup = basketGroup;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getBasketAmount() {
		return basketAmount;
	}
	public void setBasketAmount(int basketAmount) {
		this.basketAmount = basketAmount;
	}
	public int getEachPaymentAmount() {
		return eachPaymentAmount;
	}
	public void setEachPaymentAmount(int eachPaymentAmount) {
		this.eachPaymentAmount = eachPaymentAmount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getBasketState() {
		return basketState;
	}
	public void setBasketState(String basketState) {
		this.basketState = basketState;
	}
	@Override
	public String toString() {
		return "Basket [basketCode=" + basketCode + ", goodsCode=" + goodsCode + ", basketGroup=" + basketGroup
				+ ", userId=" + userId + ", goodsName=" + goodsName + ", categoryMediumCode=" + categoryMediumCode
				+ ", goodsPrice=" + goodsPrice + ", basketAmount=" + basketAmount + ", eachPaymentAmount="
				+ eachPaymentAmount + ", regDate=" + regDate + ", basketState=" + basketState + "]";
	}
	
	
}
