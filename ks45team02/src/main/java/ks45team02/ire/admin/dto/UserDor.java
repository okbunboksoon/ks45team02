package ks45team02.ire.admin.dto;

public class UserDor {
    private String userDorId;
    private String userDorPw;
    private String userDorName;
    private String userDorNickName;
    private String userDorAddr;
    private String userDorPhone;
    private String userDorEmail;
    private String userDorBirth;
    private int pointState;
    private String userDorJoinDate;
    private String userDorDate;
    private String userDropState;

    public String getUserDorId() {
        return userDorId;
    }

    public void setUserDorId(String userDorId) {
        this.userDorId = userDorId;
    }

    public String getUserDorPw() {
        return userDorPw;
    }

    public void setUserDorPw(String userDorPw) {
        this.userDorPw = userDorPw;
    }

    public String getUserDorName() {
        return userDorName;
    }

    public void setUserDorName(String userDorName) {
        this.userDorName = userDorName;
    }

    public String getUserDorNickName() {
        return userDorNickName;
    }

    public void setUserDorNickName(String userDorNickName) {
        this.userDorNickName = userDorNickName;
    }

    public String getUserDorAddr() {
        return userDorAddr;
    }

    public void setUserDorAddr(String userDorAddr) {
        this.userDorAddr = userDorAddr;
    }

    public String getUserDorPhone() {
        return userDorPhone;
    }

    public void setUserDorPhone(String userDorPhone) {
        this.userDorPhone = userDorPhone;
    }

    public String getUserDorEmail() {
        return userDorEmail;
    }

    public void setUserDorEmail(String userDorEmail) {
        this.userDorEmail = userDorEmail;
    }

    public String getUserDorBirth() {
        return userDorBirth;
    }

    public void setUserDorBirth(String userDorBirth) {
        this.userDorBirth = userDorBirth;
    }

    public int getPointState() {
        return pointState;
    }

    public void setPointState(int pointState) {
        this.pointState = pointState;
    }

    public String getUserDorJoinDate() {
        return userDorJoinDate;
    }

    public void setUserDorJoinDate(String userDorJoinDate) {
        this.userDorJoinDate = userDorJoinDate;
    }

    public String getUserDorDate() {
        return userDorDate;
    }

    public void setUserDorDate(String userDorDate) {
        this.userDorDate = userDorDate;
    }

    public String getUserDropState() {
        return userDropState;
    }

    public void setUserDropState(String userDropState) {
        this.userDropState = userDropState;
    }

    @Override
    public String toString() {
        return "UserDor{" +
                "userDorId='" + userDorId + '\'' +
                ", userDorPw='" + userDorPw + '\'' +
                ", userDorName='" + userDorName + '\'' +
                ", userDorNickName='" + userDorNickName + '\'' +
                ", userDorAddr='" + userDorAddr + '\'' +
                ", userDorPhone='" + userDorPhone + '\'' +
                ", userDorEmail='" + userDorEmail + '\'' +
                ", userDorBirth='" + userDorBirth + '\'' +
                ", pointState=" + pointState +
                ", userDorJoinDate='" + userDorJoinDate + '\'' +
                ", userDorDate='" + userDorDate + '\'' +
                ", userDropState='" + userDropState + '\'' +
                '}';
    }
}
