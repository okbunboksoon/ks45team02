package ks45team02.ire.user.dto;

import ks45team02.ire.admin.dto.FileDto;

public class UserGoods {

	private String goodsCode;
	private String goodsName;
	private String categoryMediumCode;
	private String categoryMediumName;
	private int goodsPrice;
	private String goodsColor;
	private String goodsSize;
	private String goodsRegDate;
	private String goodsSangse;
	private String fabric;
	private String rate;
	private float upcyclingCarbonDioxideEmissionLevel;
	private String fileIdx;
	private String fileSangseIdx;
	private String fileSangse;
	
	
	private FileDto fileDto;

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

	public String getFileIdx() {
		return fileIdx;
	}

	public void setFileIdx(String fileIdx) {
		this.fileIdx = fileIdx;
	}

	public String getFileSangseIdx() {
		return fileSangseIdx;
	}

	public void setFileSangseIdx(String fileSangseIdx) {
		this.fileSangseIdx = fileSangseIdx;
	}

	public FileDto getFileDto() {
		return fileDto;
	}

	public void setFileDto(FileDto fileDto) {
		this.fileDto = fileDto;
	}

	
	public String getFileSangse() {
		return fileSangse;
	}

	public void setFileSangse(String fileSangse) {
		this.fileSangse = fileSangse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserGoods [goodsCode=");
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
		builder.append(", fabric=");
		builder.append(fabric);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", upcyclingCarbonDioxideEmissionLevel=");
		builder.append(upcyclingCarbonDioxideEmissionLevel);
		builder.append(", fileIdx=");
		builder.append(fileIdx);
		builder.append(", fileSangseIdx=");
		builder.append(fileSangseIdx);
		builder.append(", fileSangse=");
		builder.append(fileSangse);
		builder.append(", fileDto=");
		builder.append(fileDto);
		builder.append("]");
		return builder.toString();
	}



	
}
