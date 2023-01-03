package ks45team02.ire.admin.dto;

public class CategoryBig {

	private String CategoryBigCode;
	private String CategoryBigName;
	
	private CategoryMedium categoryMedium;

	public String getCategoryBigCode() {
		return CategoryBigCode;
	}

	public void setCategoryBigCode(String categoryBigCode) {
		CategoryBigCode = categoryBigCode;
	}

	public String getCategoryBigName() {
		return CategoryBigName;
	}

	public void setCategoryBigName(String categoryBigName) {
		CategoryBigName = categoryBigName;
	}

	public CategoryMedium getCategoryMedium() {
		return categoryMedium;
	}

	public void setCategoryMedium(CategoryMedium categoryMedium) {
		this.categoryMedium = categoryMedium;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryBig [CategoryBigCode=");
		builder.append(CategoryBigCode);
		builder.append(", CategoryBigName=");
		builder.append(CategoryBigName);
		builder.append(", categoryMedium=");
		builder.append(categoryMedium);
		builder.append("]");
		return builder.toString();
	}
}
