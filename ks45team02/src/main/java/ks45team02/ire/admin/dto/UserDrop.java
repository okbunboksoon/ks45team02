package ks45team02.ire.admin.dto;

public class UserDrop {
    private String userDropId;
    private String userDropPw;
    private String userDropName;
    private String userDropNickName;
    private String userDropAddr;
    private String userDropPhone;
    private String userDropEmail;
    private String userDropBirth;
    private int pointState;
    private String userDropJoinDate;
    private String userDropDate;
    private String userDropState;

    @Override
    public String toString() {
        return "UserDrop{" +
                "userDropId='" + userDropId + '\'' +
                ", userDropPw='" + userDropPw + '\'' +
                ", userDropName='" + userDropName + '\'' +
                ", userDropNickName='" + userDropNickName + '\'' +
                ", userDropAddr='" + userDropAddr + '\'' +
                ", userDropPhone='" + userDropPhone + '\'' +
                ", userDropEmail='" + userDropEmail + '\'' +
                ", userDropBirth='" + userDropBirth + '\'' +
                ", pointState=" + pointState +
                ", userDropJoinDate='" + userDropJoinDate + '\'' +
                ", userDropDate='" + userDropDate + '\'' +
                ", userDropState='" + userDropState + '\'' +
                '}';
    }

    public String getUserDropId() {
        return userDropId;
    }

    public void setUserDropId(String userDropId) {
        this.userDropId = userDropId;
    }

    public String getUserDropPw() {
        return userDropPw;
    }

    public void setUserDropPw(String userDropPw) {
        this.userDropPw = userDropPw;
    }

    public String getUserDropName() {
        return userDropName;
    }

    public void setUserDropName(String userDropName) {
        this.userDropName = userDropName;
    }

    public String getUserDropNickName() {
        return userDropNickName;
    }

    public void setUserDropNickName(String userDropNickName) {
        this.userDropNickName = userDropNickName;
    }

    public String getUserDropAddr() {
        return userDropAddr;
    }

    public void setUserDropAddr(String userDropAddr) {
        this.userDropAddr = userDropAddr;
    }

    public String getUserDropPhone() {
        return userDropPhone;
    }

    public void setUserDropPhone(String userDropPhone) {
        this.userDropPhone = userDropPhone;
    }

    public String getUserDropEmail() {
        return userDropEmail;
    }

    public void setUserDropEmail(String userDropEmail) {
        this.userDropEmail = userDropEmail;
    }

    public String getUserDropBirth() {
        return userDropBirth;
    }

    public void setUserDropBirth(String userDropBirth) {
        this.userDropBirth = userDropBirth;
    }

    public int getPointState() {
        return pointState;
    }

    public void setPointState(int pointState) {
        this.pointState = pointState;
    }

    public String getUserDropJoinDate() {
        return userDropJoinDate;
    }

    public void setUserDropJoinDate(String userDropJoinDate) {
        this.userDropJoinDate = userDropJoinDate;
    }

    public String getUserDropDate() {
        return userDropDate;
    }

    public void setUserDropDate(String userDropDate) {
        this.userDropDate = userDropDate;
    }

    public String getUserDropState() {
        return userDropState;
    }

    public void setUserDropState(String userDropState) {
        this.userDropState = userDropState;
    }

}
