package ks45team02.ire.admin.dto;

public class User {

	 private String user_id;
	 private String user_pw;
	 private String user_name;
	 private String user_nickname;
	 private String user_addr;
	 private String user_phone;
	 @Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_nickname="
				+ user_nickname + ", user_addr=" + user_addr + ", user_phone=" + user_phone + ", user_email="
				+ user_email + ", user_birth=" + user_birth + ", point_state=" + point_state + ", user_join_date="
				+ user_join_date + "]";
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public int getPoint_state() {
		return point_state;
	}
	public void setPoint_state(int point_state) {
		this.point_state = point_state;
	}
	public String getUser_join_date() {
		return user_join_date;
	}
	public void setUser_join_date(String user_join_date) {
		this.user_join_date = user_join_date;
	}
	private String user_email;
	 private String user_birth;
	 private int point_state;
	 private String user_join_date;

}
