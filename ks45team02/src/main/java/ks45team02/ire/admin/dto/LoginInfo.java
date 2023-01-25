package ks45team02.ire.admin.dto;

public class LoginInfo {
    //세션을 저장하기위한것
    private String loginId;
    private String loginName;
    public LoginInfo(){}

    public LoginInfo(String loginId,String loginName ){
        this.loginId=loginId;
        this.loginName=loginName;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "loginId='" + loginId + '\'' +
                ", loginName='" + loginName + '\'' +
                '}';
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
