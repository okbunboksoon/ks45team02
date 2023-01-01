package ks45team02.ire.admin.dto;

public class BoardFAQ {
	
	private String FAQ_num;
	private String FAQ_title;
	private String FAQ_contents;
	private String FAQ_file;
	private int FAQ_views;
	private String FAQ_reg_date;
	public String getFAQ_num() {
		return FAQ_num;
	}
	public void setFAQ_num(String FAQ_num) {
		FAQ_num = FAQ_num;
	}
	public String getFAQ_title() {
		return FAQ_title;
	}
	public void setFAQ_title(String FAQ_title) {
		FAQ_title = FAQ_title;
	}
	public String getFAQ_contents() {
		return FAQ_contents;
	}
	public void setFAQ_contents(String FAQ_contents) {
		FAQ_contents = FAQ_contents;
	}
	public String getFAQ_file() {
		return FAQ_file;
	}
	public void setFAQ_file(String FAQ_file) {
		FAQ_file = FAQ_file;
	}
	public int getFAQ_views() {
		return FAQ_views;
	}
	public void setFAQ_views(int FAQ_views) {
		FAQ_views = FAQ_views;
	}
	public String getFAQ_reg_date() {
		return FAQ_reg_date;
	}
	public void setFAQ_reg_date(String FAQ_reg_date) {
		FAQ_reg_date = FAQ_reg_date;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardFAQ [FAQ_num=");
		builder.append(FAQ_num);
		builder.append(", FAQ_title=");
		builder.append(FAQ_title);
		builder.append(", FAQ_contents=");
		builder.append(FAQ_contents);
		builder.append(", FAQ_file=");
		builder.append(FAQ_file);
		builder.append(", FAQ_views=");
		builder.append(FAQ_views);
		builder.append(", FAQ_reg_date=");
		builder.append(FAQ_reg_date);
		builder.append("]");
		return builder.toString();
	}
	
	
}
