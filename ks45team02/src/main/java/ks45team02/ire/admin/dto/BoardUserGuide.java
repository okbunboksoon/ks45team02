package ks45team02.ire.admin.dto;

public class BoardUserGuide {

	private String guide_code;
	private String guide_title;
	private String guide_views;
	private String guide_reg_date;
	private String guide_contents;
	public String getGuide_code() {
		return guide_code;
	}
	public void setGuide_code(String guide_code) {
		this.guide_code = guide_code;
	}
	public String getGuide_title() {
		return guide_title;
	}
	public void setGuide_title(String guide_title) {
		this.guide_title = guide_title;
	}
	public String getGuide_views() {
		return guide_views;
	}
	public void setGuide_views(String guide_views) {
		this.guide_views = guide_views;
	}
	public String getGuide_reg_date() {
		return guide_reg_date;
	}
	public void setGuide_reg_date(String guide_reg_date) {
		this.guide_reg_date = guide_reg_date;
	}
	public String getGuide_contents() {
		return guide_contents;
	}
	public void setGuide_contents(String guide_contents) {
		this.guide_contents = guide_contents;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardUserGuide [guide_code=");
		builder.append(guide_code);
		builder.append(", guide_title=");
		builder.append(guide_title);
		builder.append(", guide_views=");
		builder.append(guide_views);
		builder.append(", guide_reg_date=");
		builder.append(guide_reg_date);
		builder.append(", guide_contents=");
		builder.append(guide_contents);
		builder.append("]");
		return builder.toString();
	}
	
	
}
