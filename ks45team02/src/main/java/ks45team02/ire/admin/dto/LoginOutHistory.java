package ks45team02.ire.admin.dto;

public class LoginOutHistory {
    private String userId;
    private String loginTime;
    private String logoutTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    @Override
    public String toString() {
        return "LoginOutHistory{" +
                "userId='" + userId + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", logoutTime='" + logoutTime + '\'' +
                '}';
    }
}
