package ks45team02.ire.admin.dto;

public class PointSaveStandard {

	private String pointSaveStandardCode;
	private String pointSaveStandardDetail;
	private int pointSave;
	
	public String getPointSaveStandardCode() {
		return pointSaveStandardCode;
	}
	public void setPointSaveStandardCode(String pointSaveStandardCode) {
		this.pointSaveStandardCode = pointSaveStandardCode;
	}
	public String getPointSaveStandardDetail() {
		return pointSaveStandardDetail;
	}
	public void setPointSaveStandardDetail(String pointSaveStandardDetail) {
		this.pointSaveStandardDetail = pointSaveStandardDetail;
	}
	public int getPointSave() {
		return pointSave;
	}
	public void setPointSave(int pointSave) {
		this.pointSave = pointSave;
	}
	@Override
	public String toString() {
		return "PointSaveStandard [pointSaveStandardCode=" + pointSaveStandardCode + ", pointSaveStandardDetail="
				+ pointSaveStandardDetail + ", pointSave=" + pointSave + "]";
	}
	
	
	
}
