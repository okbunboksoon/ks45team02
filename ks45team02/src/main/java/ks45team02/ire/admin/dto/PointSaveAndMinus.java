package ks45team02.ire.admin.dto;

public class PointSaveAndMinus {

	private String pointCode;
	private String userId;
	private int pointAmount;
	private int pointState;
	private String pointDate;
	private String pointReason;
	private String pointGroup;
	private String pointSaveOrMinus;
	private String pointDeleteState;
	public String getPointCode() {
		return pointCode;
	}
	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPointAmount() {
		return pointAmount;
	}
	public void setPointAmount(int pointAmount) {
		this.pointAmount = pointAmount;
	}
	public int getPointState() {
		return pointState;
	}
	public void setPointState(int pointState) {
		this.pointState = pointState;
	}
	public String getPointDate() {
		return pointDate;
	}
	public void setPointDate(String pointDate) {
		this.pointDate = pointDate;
	}
	public String getPointReason() {
		return pointReason;
	}
	public void setPointReason(String pointReason) {
		this.pointReason = pointReason;
	}
	public String getPointGroup() {
		return pointGroup;
	}
	public void setPointGroup(String pointGroup) {
		this.pointGroup = pointGroup;
	}
	public String getPointSaveOrMinus() {
		return pointSaveOrMinus;
	}
	public void setPointSaveOrMinus(String pointSaveOrMinus) {
		this.pointSaveOrMinus = pointSaveOrMinus;
	}
	public String getPointDeleteState() {
		return pointDeleteState;
	}
	public void setPointDeleteState(String pointDeleteState) {
		this.pointDeleteState = pointDeleteState;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PointSaveAndMinus [pointCode=");
		builder.append(pointCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", pointAmount=");
		builder.append(pointAmount);
		builder.append(", pointState=");
		builder.append(pointState);
		builder.append(", pointDate=");
		builder.append(pointDate);
		builder.append(", pointReason=");
		builder.append(pointReason);
		builder.append(", pointGroup=");
		builder.append(pointGroup);
		builder.append(", pointSaveOrMinus=");
		builder.append(pointSaveOrMinus);
		builder.append(", pointDeleteState=");
		builder.append(pointDeleteState);
		builder.append("]");
		return builder.toString();
	}
	

	
}
