package ks45team02.ire.admin.dto;

import java.util.List;

public class User {


	 private String userId;
	 private String userPw;
	 private String userName;
	 private String userNickName;
	 private String userAddr;
	 private String userPhone;
	 private String userEmail;
	 private String userBirth;
	 private int pointState;
	 private String userJoinDate;
	 private String userDropState;
	private List<LoginOutHistory> loginOutHistoryList;

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", userPw='" + userPw + '\'' +
				", userName='" + userName + '\'' +
				", userNickName='" + userNickName + '\'' +
				", userAddr='" + userAddr + '\'' +
				", userPhone='" + userPhone + '\'' +
				", userEmail='" + userEmail + '\'' +
				", userBirth='" + userBirth + '\'' +
				", pointState=" + pointState +
				", userJoinDate='" + userJoinDate + '\'' +
				", userDropState='" + userDropState + '\'' +
				", loginOutHistoryList=" + loginOutHistoryList +
				'}';
	}

	public String getUserDropState() {
		return userDropState;
	}

	public void setUserDropState(String userDropState) {
		this.userDropState = userDropState;
	}

	public List<LoginOutHistory> getLoginOutHistoryList() {
		return loginOutHistoryList;
	}

	public void setLoginOutHistoryList(List<LoginOutHistory> loginOutHistoryList) {
		this.loginOutHistoryList = loginOutHistoryList;
	}


	 
	 
	 
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public int getPointState() {
		return pointState;
	}
	public void setPointState(int pointState) {
		this.pointState = pointState;
	}
	public String getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}


}
