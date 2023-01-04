package ks45team02.ire.admin.dto;

public class CategoryBig {

	private String categoryBigCode;
	private String categoryBigName;
	
	public String getCategoryBigCode() {
		return categoryBigCode;
	}
	public void setCategoryBigCode(String categoryBigCode) {
		this.categoryBigCode = categoryBigCode;
	}
	public String getCategoryBigName() {
		return categoryBigName;
	}
	public void setCategoryBigName(String categoryBigName) {
		this.categoryBigName = categoryBigName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryBig [categoryBigCode=");
		builder.append(categoryBigCode);
		builder.append(", categoryBigName=");
		builder.append(categoryBigName);
		builder.append("]");
		return builder.toString();
	}
}
