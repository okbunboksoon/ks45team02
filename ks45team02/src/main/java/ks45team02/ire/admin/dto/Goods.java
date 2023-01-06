package ks45team02.ire.admin.dto;

public class Goods {

	private String goodsCode;
	private String goodsName;
	private String categoryMediumCode;
	private String categoryMediumName;
	private int goodsPrice;
	private String goodsColor;
	private String goodsSize;
	private String goodsRegDate;
	private String goodsSangse;
	private String goodsImage;
	private String fabric;
	private String rate;
	private float upcyclingCarbonDioxideEmissionLevel;
	
	private UnitPrice unitPrice;

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getCategoryMediumCode() {
		return categoryMediumCode;
	}

	public void setCategoryMediumCode(String categoryMediumCode) {
		this.categoryMediumCode = categoryMediumCode;
	}

	public String getCategoryMediumName() {
		return categoryMediumName;
	}

	public void setCategoryMediumName(String categoryMediumName) {
		this.categoryMediumName = categoryMediumName;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}

	public String getGoodsSize() {
		return goodsSize;
	}

	public void setGoodsSize(String goodsSize) {
		this.goodsSize = goodsSize;
	}

	public String getGoodsRegDate() {
		return goodsRegDate;
	}

	public void setGoodsRegDate(String goodsRegDate) {
		this.goodsRegDate = goodsRegDate;
	}

	public String getGoodsSangse() {
		return goodsSangse;
	}

	public void setGoodsSangse(String goodsSangse) {
		this.goodsSangse = goodsSangse;
	}

	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public float getUpcyclingCarbonDioxideEmissionLevel() {
		return upcyclingCarbonDioxideEmissionLevel;
	}

	public void setUpcyclingCarbonDioxideEmissionLevel(float upcyclingCarbonDioxideEmissionLevel) {
		this.upcyclingCarbonDioxideEmissionLevel = upcyclingCarbonDioxideEmissionLevel;
	}

	public UnitPrice getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(UnitPrice unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [goodsCode=");
		builder.append(goodsCode);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", categoryMediumCode=");
		builder.append(categoryMediumCode);
		builder.append(", categoryMediumName=");
		builder.append(categoryMediumName);
		builder.append(", goodsPrice=");
		builder.append(goodsPrice);
		builder.append(", goodsColor=");
		builder.append(goodsColor);
		builder.append(", goodsSize=");
		builder.append(goodsSize);
		builder.append(", goodsRegDate=");
		builder.append(goodsRegDate);
		builder.append(", goodsSangse=");
		builder.append(goodsSangse);
		builder.append(", goodsImage=");
		builder.append(goodsImage);
		builder.append(", fabric=");
		builder.append(fabric);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", upcyclingCarbonDioxideEmissionLevel=");
		builder.append(upcyclingCarbonDioxideEmissionLevel);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append("]");
		return builder.toString();
	}	
}
