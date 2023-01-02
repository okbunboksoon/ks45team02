package ks45team02.ire.admin.dto;

public class BoardNotice {

	private String noticeCode;
	private String userId;
	private String noticeTitle;
	private String noticeCate;
	private String noticeDate;
	private String noticeContents;
	private String noticeImage;
	
	private User user;

	public String getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeCate() {
		return noticeCate;
	}

	public void setNoticeCate(String noticeCate) {
		this.noticeCate = noticeCate;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}

	public String getNoticeImage() {
		return noticeImage;
	}

	public void setNoticeImage(String noticeImage) {
		this.noticeImage = noticeImage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardNotice [noticeCode=");
		builder.append(noticeCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", noticeTitle=");
		builder.append(noticeTitle);
		builder.append(", noticeCate=");
		builder.append(noticeCate);
		builder.append(", noticeDate=");
		builder.append(noticeDate);
		builder.append(", noticeContents=");
		builder.append(noticeContents);
		builder.append(", noticeImage=");
		builder.append(noticeImage);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
}
