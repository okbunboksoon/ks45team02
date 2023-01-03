package ks45team02.ire.admin.dto;

public class CategoryMedium {

	private String categoryMediumCode;
	private String categoryBigCode;
	private String categoryMediumName;
	
	public String getCategoryMediumCode() {
		return categoryMediumCode;
	}
	public void setCategoryMediumCode(String categoryMediumCode) {
		this.categoryMediumCode = categoryMediumCode;
	}
	public String getCategoryBigCode() {
		return categoryBigCode;
	}
	public void setCategoryBigCode(String categoryBigCode) {
		this.categoryBigCode = categoryBigCode;
	}
	public String getCategoryMediumName() {
		return categoryMediumName;
	}
	public void setCategoryMediumName(String categoryMediumName) {
		this.categoryMediumName = categoryMediumName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryMedium [categoryMediumCode=");
		builder.append(categoryMediumCode);
		builder.append(", categoryBigCode=");
		builder.append(categoryBigCode);
		builder.append(", categoryMediumName=");
		builder.append(categoryMediumName);
		builder.append("]");
		return builder.toString();
	}
}
