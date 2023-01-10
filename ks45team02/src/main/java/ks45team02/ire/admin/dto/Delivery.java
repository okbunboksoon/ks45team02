package ks45team02.ire.admin.dto;

public class Delivery {
    private String deliveryCode;
    private String delInfoCode;
    private String userId;
    private String deliveryNum;
    private String businessCode;
    private String deliveryState;
    private String paymentCompleteCode;

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryCode='" + deliveryCode + '\'' +
                ", delInfoCode='" + delInfoCode + '\'' +
                ", userId='" + userId + '\'' +
                ", deliveryNum='" + deliveryNum + '\'' +
                ", businessCode='" + businessCode + '\'' +
                ", deliveryState='" + deliveryState + '\'' +
                ", paymentCompleteCode='" + paymentCompleteCode + '\'' +
                '}';
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getDelInfoCode() {
        return delInfoCode;
    }

    public void setDelInfoCode(String delInfoCode) {
        this.delInfoCode = delInfoCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeliveryNum() {
        return deliveryNum;
    }

    public void setDeliveryNum(String deliveryNum) {
        this.deliveryNum = deliveryNum;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public String getPaymentCompleteCode() {
        return paymentCompleteCode;
    }

    public void setPaymentCompleteCode(String paymentCompleteCode) {
        this.paymentCompleteCode = paymentCompleteCode;
    }
}
