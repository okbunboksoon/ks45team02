package ks45team02.ire.admin.dto;

public class Business {
    private String businessCode;
    private String businessName;
    private String businessNum;
    private String businessType;
    private String sectors;
    private String businessManagerName;
    private String businessPhone;
    private String userId;

    @Override
    public String toString() {
        return "Business{" +
                "businessCode='" + businessCode + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessNum='" + businessNum + '\'' +
                ", businessType='" + businessType + '\'' +
                ", sectors='" + sectors + '\'' +
                ", businessManagerName='" + businessManagerName + '\'' +
                ", businessPhone='" + businessPhone + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getSectors() {
        return sectors;
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    public String getBusinessManagerName() {
        return businessManagerName;
    }

    public void setBusinessManagerName(String businessManagerName) {
        this.businessManagerName = businessManagerName;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
