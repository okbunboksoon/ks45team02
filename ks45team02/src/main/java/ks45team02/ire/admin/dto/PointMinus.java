package ks45team02.ire.admin.dto;

public class PointMinus {

	private String pointMinusCode;
	private String userId;
	private int pointMinus;
	private int pointState;
	private String pointMinusDate;
	private String pointMinusReason;
	private String pointMinusReasonEtc;
	private String pointMinusGroup;
	private String pointMinusDeleteState;
	
	public String getPointMinusCode() {
		return pointMinusCode;
	}
	public void setPointMinusCode(String pointMinusCode) {
		this.pointMinusCode = pointMinusCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPointMinus() {
		return pointMinus;
	}
	public void setPointMinus(int pointMinus) {
		this.pointMinus = pointMinus;
	}
	public int getPointState() {
		return pointState;
	}
	public void setPointState(int pointState) {
		this.pointState = pointState;
	}
	public String getPointMinusDate() {
		return pointMinusDate;
	}
	public void setPointMinusDate(String pointMinusDate) {
		this.pointMinusDate = pointMinusDate;
	}
	public String getPointMinusReason() {
		return pointMinusReason;
	}
	public void setPointMinusReason(String pointMinusReason) {
		this.pointMinusReason = pointMinusReason;
	}
	public String getPointMinusReasonEtc() {
		return pointMinusReasonEtc;
	}
	public void setPointMinusReasonEtc(String pointMinusReasonEtc) {
		this.pointMinusReasonEtc = pointMinusReasonEtc;
	}
	public String getPointMinusGroup() {
		return pointMinusGroup;
	}
	public void setPointMinusGroup(String pointMinusGroup) {
		this.pointMinusGroup = pointMinusGroup;
	}
	public String getPointMinusDeleteState() {
		return pointMinusDeleteState;
	}
	public void setPointMinusDeleteState(String pointMinusDeleteState) {
		this.pointMinusDeleteState = pointMinusDeleteState;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PointMinus [pointMinusCode=");
		builder.append(pointMinusCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", pointMinus=");
		builder.append(pointMinus);
		builder.append(", pointState=");
		builder.append(pointState);
		builder.append(", pointMinusDate=");
		builder.append(pointMinusDate);
		builder.append(", pointMinusReason=");
		builder.append(pointMinusReason);
		builder.append(", pointMinusReasonEtc=");
		builder.append(pointMinusReasonEtc);
		builder.append(", pointMinusGroup=");
		builder.append(pointMinusGroup);
		builder.append(", pointMinusDeleteState=");
		builder.append(pointMinusDeleteState);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
