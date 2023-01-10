package ks45team02.ire.admin.dto;

public class GoodsExchange {
    private String goodsExchangeCode;
    private String exchangeStandardCode;
    private String paymentCompleteCode;
    private String userId;
    private String goodsCode;
    private int goodsExchangeCount;
    private int goodsExchangePrice;
    private String goodsExchangeDate;
    private String goodsExchangeContent;
    private String exchangeProcessState;
    private String managerId;
    private String exchangeDate;
    private String exchangeReject;
    private String exchangeApproval;

    @Override
    public String toString() {
        return "GoodsExchange{" +
                "goodsExchangeCode='" + goodsExchangeCode + '\'' +
                ", exchangeStandardCode='" + exchangeStandardCode + '\'' +
                ", paymentCompleteCode='" + paymentCompleteCode + '\'' +
                ", userId='" + userId + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", goodsExchangeCount=" + goodsExchangeCount +
                ", goodsExchangePrice=" + goodsExchangePrice +
                ", goodsExchangeDate='" + goodsExchangeDate + '\'' +
                ", goodsExchangeContent='" + goodsExchangeContent + '\'' +
                ", exchangeProcessState='" + exchangeProcessState + '\'' +
                ", managerId='" + managerId + '\'' +
                ", exchangeDate='" + exchangeDate + '\'' +
                ", exchangeReject='" + exchangeReject + '\'' +
                ", exchangeApproval='" + exchangeApproval + '\'' +
                '}';
    }

    public String getGoodsExchangeCode() {
        return goodsExchangeCode;
    }

    public void setGoodsExchangeCode(String goodsExchangeCode) {
        this.goodsExchangeCode = goodsExchangeCode;
    }

    public String getExchangeStandardCode() {
        return exchangeStandardCode;
    }

    public void setExchangeStandardCode(String exchangeStandardCode) {
        this.exchangeStandardCode = exchangeStandardCode;
    }

    public String getPaymentCompleteCode() {
        return paymentCompleteCode;
    }

    public void setPaymentCompleteCode(String paymentCompleteCode) {
        this.paymentCompleteCode = paymentCompleteCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getGoodsExchangeCount() {
        return goodsExchangeCount;
    }

    public void setGoodsExchangeCount(int goodsExchangeCount) {
        this.goodsExchangeCount = goodsExchangeCount;
    }

    public int getGoodsExchangePrice() {
        return goodsExchangePrice;
    }

    public void setGoodsExchangePrice(int goodsExchangePrice) {
        this.goodsExchangePrice = goodsExchangePrice;
    }

    public String getGoodsExchangeDate() {
        return goodsExchangeDate;
    }

    public void setGoodsExchangeDate(String goodsExchangeDate) {
        this.goodsExchangeDate = goodsExchangeDate;
    }

    public String getGoodsExchangeContent() {
        return goodsExchangeContent;
    }

    public void setGoodsExchangeContent(String goodsExchangeContent) {
        this.goodsExchangeContent = goodsExchangeContent;
    }

    public String getExchangeProcessState() {
        return exchangeProcessState;
    }

    public void setExchangeProcessState(String exchangeProcessState) {
        this.exchangeProcessState = exchangeProcessState;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public String getExchangeReject() {
        return exchangeReject;
    }

    public void setExchangeReject(String exchangeReject) {
        this.exchangeReject = exchangeReject;
    }

    public String getExchangeApproval() {
        return exchangeApproval;
    }

    public void setExchangeApproval(String exchangeApproval) {
        this.exchangeApproval = exchangeApproval;
    }
}
