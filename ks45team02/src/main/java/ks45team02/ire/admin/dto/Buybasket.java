package ks45team02.ire.admin.dto;

import java.util.List;

public class Buybasket {
	
	private String basketGroup;
	private String userId;
	private String basketCode;
	private int expectedAmount;
	private int usePoint;
	private int finalPaymentAmount;
	private String regDate;
	private char buybasketDeleteState;
	
	private List<Basket> basketList;

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

	public String getBasketCode() {
		return basketCode;
	}

	public void setBasketCode(String basketCode) {
		this.basketCode = basketCode;
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

	public char getBuybasketDeleteState() {
		return buybasketDeleteState;
	}

	public void setBuybasketDeleteState(char buybasketDeleteState) {
		this.buybasketDeleteState = buybasketDeleteState;
	}

	public List<Basket> getBasketList() {
		return basketList;
	}

	public void setBasketList(List<Basket> basketList) {
		this.basketList = basketList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buybasket [basketGroup=");
		builder.append(basketGroup);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", basketCode=");
		builder.append(basketCode);
		builder.append(", expectedAmount=");
		builder.append(expectedAmount);
		builder.append(", usePoint=");
		builder.append(usePoint);
		builder.append(", finalPaymentAmount=");
		builder.append(finalPaymentAmount);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", buybasketDeleteState=");
		builder.append(buybasketDeleteState);
		builder.append(", basketList=");
		builder.append(basketList);
		builder.append("]");
		return builder.toString();
	}

	
	

	
	
	
}
