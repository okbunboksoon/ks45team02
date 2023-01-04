package ks45team02.ire.admin.dto;

public class CategoryMedium {

	private String categoryMediumCode;
	private String mediumCategoryBigCode;
	private String categoryMediumName;
	
	private CategoryBig categoryBig;

	public String getCategoryMediumCode() {
		return categoryMediumCode;
	}

	public void setCategoryMediumCode(String categoryMediumCode) {
		this.categoryMediumCode = categoryMediumCode;
	}

	public String getMediumCategoryBigCode() {
		return mediumCategoryBigCode;
	}

	public void setMediumCategoryBigCode(String mediumCategoryBigCode) {
		this.mediumCategoryBigCode = mediumCategoryBigCode;
	}

	public String getCategoryMediumName() {
		return categoryMediumName;
	}

	public void setCategoryMediumName(String categoryMediumName) {
		this.categoryMediumName = categoryMediumName;
	}

	public CategoryBig getCategoryBig() {
		return categoryBig;
	}

	public void setCategoryBig(CategoryBig categoryBig) {
		this.categoryBig = categoryBig;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryMedium [categoryMediumCode=");
		builder.append(categoryMediumCode);
		builder.append(", mediumCategoryBigCode=");
		builder.append(mediumCategoryBigCode);
		builder.append(", categoryMediumName=");
		builder.append(categoryMediumName);
		builder.append(", categoryBig=");
		builder.append(categoryBig);
		builder.append("]");
		return builder.toString();
	}
}
