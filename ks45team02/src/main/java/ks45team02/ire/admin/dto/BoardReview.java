package ks45team02.ire.admin.dto;

public class BoardReview {
	private String reviewCode;
	private String userId;
	private String goodsCode;
	private int reviewStarCount;
	private String reviewContent;
	private String reviewImageName;
	private String reviewImagePath;
	private String reviewRegDate;
	private int reviewPointSave;
	private String reviewPointGroup;
	private char reviewDeleteState;
	
	private Goods goods;

	public String getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(String reviewCode) {
		this.reviewCode = reviewCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public int getReviewStarCount() {
		return reviewStarCount;
	}

	public void setReviewStarCount(int reviewStarCount) {
		this.reviewStarCount = reviewStarCount;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewImageName() {
		return reviewImageName;
	}

	public void setReviewImageName(String reviewImageName) {
		this.reviewImageName = reviewImageName;
	}

	public String getReviewImagePath() {
		return reviewImagePath;
	}

	public void setReviewImagePath(String reviewImagePath) {
		this.reviewImagePath = reviewImagePath;
	}

	public String getReviewRegDate() {
		return reviewRegDate;
	}

	public void setReviewRegDate(String reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}

	public int getReviewPointSave() {
		return reviewPointSave;
	}

	public void setReviewPointSave(int reviewPointSave) {
		this.reviewPointSave = reviewPointSave;
	}

	public String getReviewPointGroup() {
		return reviewPointGroup;
	}

	public void setReviewPointGroup(String reviewPointGroup) {
		this.reviewPointGroup = reviewPointGroup;
	}

	public char getReviewDeleteState() {
		return reviewDeleteState;
	}

	public void setReviewDeleteState(char reviewDeleteState) {
		this.reviewDeleteState = reviewDeleteState;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardReview [reviewCode=");
		builder.append(reviewCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", reviewStarCount=");
		builder.append(reviewStarCount);
		builder.append(", reviewContent=");
		builder.append(reviewContent);
		builder.append(", reviewImageName=");
		builder.append(reviewImageName);
		builder.append(", reviewImagePath=");
		builder.append(reviewImagePath);
		builder.append(", reviewRegDate=");
		builder.append(reviewRegDate);
		builder.append(", reviewPointSave=");
		builder.append(reviewPointSave);
		builder.append(", reviewPointGroup=");
		builder.append(reviewPointGroup);
		builder.append(", reviewDeleteState=");
		builder.append(reviewDeleteState);
		builder.append(", goods=");
		builder.append(goods);
		builder.append("]");
		return builder.toString();
	}

	

	
	
	
}
