package ks45team02.ire.admin.dto;

public class Contract {
    private String contractCode;
    private String userId;
    private String contractName;
    private String businessCode;
    private String contractContent;
    private String contractDate;
    private String contractExpirationDate;
    private String contractRegDate;
    private String contractState;

    @Override
    public String toString() {
        return "Contract{" +
                "contractCode='" + contractCode + '\'' +
                ", userId='" + userId + '\'' +
                ", contractName='" + contractName + '\'' +
                ", businessCode='" + businessCode + '\'' +
                ", contractContent='" + contractContent + '\'' +
                ", contractDate='" + contractDate + '\'' +
                ", contractExpirationDate='" + contractExpirationDate + '\'' +
                ", contractRegDate='" + contractRegDate + '\'' +
                ", contractState='" + contractState + '\'' +
                '}';
    }

    public String getContractState() {
        return contractState;
    }

    public void setContractState(String contractState) {
        this.contractState = contractState;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractExpirationDate() {
        return contractExpirationDate;
    }

    public void setContractExpirationDate(String contractExpirationDate) {
        this.contractExpirationDate = contractExpirationDate;
    }

    public String getContractRegDate() {
        return contractRegDate;
    }

    public void setContractRegDate(String contractRegDate) {
        this.contractRegDate = contractRegDate;
    }
}
