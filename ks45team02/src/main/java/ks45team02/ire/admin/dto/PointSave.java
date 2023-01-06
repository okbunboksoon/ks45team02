package ks45team02.ire.admin.dto;

public class PointSave {

	private String pointSaveCode;
	private String userId;
	private int pointSave;
	private int pointState;
	private String pointPaymentDate;
	private String pointSaveReason;
	private String pointSaveGroup;
	
	public String getPointSaveCode() {
		return pointSaveCode;
	}
	public void setPointSaveCode(String pointSaveCode) {
		this.pointSaveCode = pointSaveCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPointSave() {
		return pointSave;
	}
	public void setPointSave(int pointSave) {
		this.pointSave = pointSave;
	}
	public int getPointState() {
		return pointState;
	}
	public void setPointState(int pointState) {
		this.pointState = pointState;
	}
	public String getPointPaymentDate() {
		return pointPaymentDate;
	}
	public void setPointPaymentDate(String pointPaymentDate) {
		this.pointPaymentDate = pointPaymentDate;
	}
	public String getPointSaveReason() {
		return pointSaveReason;
	}
	public void setPointSaveReason(String pointSaveReason) {
		this.pointSaveReason = pointSaveReason;
	}
	public String getPointSaveGroup() {
		return pointSaveGroup;
	}
	public void setPointSaveGroup(String pointSaveGroup) {
		this.pointSaveGroup = pointSaveGroup;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PointSave [pointSaveCode=");
		builder.append(pointSaveCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", pointSave=");
		builder.append(pointSave);
		builder.append(", pointState=");
		builder.append(pointState);
		builder.append(", pointPaymentDate=");
		builder.append(pointPaymentDate);
		builder.append(", pointSaveReason=");
		builder.append(pointSaveReason);
		builder.append(", pointSaveGroup=");
		builder.append(pointSaveGroup);
		builder.append("]");
		return builder.toString();
	}
		
	
}
