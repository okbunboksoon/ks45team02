package ks45team02.ire.admin.dto;

public class User {

	 private String userId;
	 private String userPw;
	 private String userName;
	 private String userNickName;
	 private String userAddr;
	 private String userPhone;
	 @Override
		public String toString() {
			return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userNickName="
					+ userNickName + ", userAddr=" + userAddr + ", userPhone=" + userPhone + "]";
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
	
	
}
