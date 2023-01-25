package ks45team02.ire.admin.dto;

public class GoodsRefund {
    private String goodsRefundCode;
    private String RefundStandardCode;
    private String paymentCompleteCode;
    private String userId;
    private String goodsCode;
    private int goodsRefundCount;
    private int goodsRefundPrice;
    private String goodsRefundDate;
    private String goodsRefundContent;
    private String RefundProcessState;
    private String managerId;
    private String RefundDate;
    private String RefundReject;
    private String RefundApproval;

    @Override
    public String toString() {
        return "GoodsRefund{" +
                "goodsRefundCode='" + goodsRefundCode + '\'' +
                ", RefundStandardCode='" + RefundStandardCode + '\'' +
                ", paymentCompleteCode='" + paymentCompleteCode + '\'' +
                ", userId='" + userId + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", goodsRefundCount=" + goodsRefundCount +
                ", goodsRefundPrice=" + goodsRefundPrice +
                ", goodsRefundDate='" + goodsRefundDate + '\'' +
                ", goodsRefundContent='" + goodsRefundContent + '\'' +
                ", RefundProcessState='" + RefundProcessState + '\'' +
                ", managerId='" + managerId + '\'' +
                ", RefundDate='" + RefundDate + '\'' +
                ", RefundReject='" + RefundReject + '\'' +
                ", RefundApproval='" + RefundApproval + '\'' +
                '}';
    }

    public String getGoodsRefundCode() {
        return goodsRefundCode;
    }

    public void setGoodsRefundCode(String goodsRefundCode) {
        this.goodsRefundCode = goodsRefundCode;
    }

    public String getRefundStandardCode() {
        return RefundStandardCode;
    }

    public void setRefundStandardCode(String refundStandardCode) {
        RefundStandardCode = refundStandardCode;
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

    public int getGoodsRefundCount() {
        return goodsRefundCount;
    }

    public void setGoodsRefundCount(int goodsRefundCount) {
        this.goodsRefundCount = goodsRefundCount;
    }

    public int getGoodsRefundPrice() {
        return goodsRefundPrice;
    }

    public void setGoodsRefundPrice(int goodsRefundPrice) {
        this.goodsRefundPrice = goodsRefundPrice;
    }

    public String getGoodsRefundDate() {
        return goodsRefundDate;
    }

    public void setGoodsRefundDate(String goodsRefundDate) {
        this.goodsRefundDate = goodsRefundDate;
    }

    public String getGoodsRefundContent() {
        return goodsRefundContent;
    }

    public void setGoodsRefundContent(String goodsRefundContent) {
        this.goodsRefundContent = goodsRefundContent;
    }

    public String getRefundProcessState() {
        return RefundProcessState;
    }

    public void setRefundProcessState(String refundProcessState) {
        RefundProcessState = refundProcessState;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getRefundDate() {
        return RefundDate;
    }

    public void setRefundDate(String refundDate) {
        RefundDate = refundDate;
    }

    public String getRefundReject() {
        return RefundReject;
    }

    public void setRefundReject(String refundReject) {
        RefundReject = refundReject;
    }

    public String getRefundApproval() {
        return RefundApproval;
    }

    public void setRefundApproval(String refundApproval) {
        RefundApproval = refundApproval;
    }
}
