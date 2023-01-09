package ks45team02.ire.admin.dto;

public class PaymentComplete {
    private String paymentCompleteCode;
    private String buynowBasketTotalCode;
    private String buynowBasket;
    private String userId;
    private int finalPaymentAmount;
    private String deliCode;
    private String orderDate;
    private String paymentTypeCode;
    private String paymentDate;
    private String pointUseGroup;
    private String productOrderState;
    private int pointSave;
    private String productOrderPointGroup;

    @Override
    public String toString() {
        return "PaymentComplete{" +
                "paymentCompleteCode='" + paymentCompleteCode + '\'' +
                ", buynowBasketTotalCode='" + buynowBasketTotalCode + '\'' +
                ", buynowBasket='" + buynowBasket + '\'' +
                ", userId='" + userId + '\'' +
                ", finalPaymentAmount=" + finalPaymentAmount +
                ", deliCode='" + deliCode + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", paymentTypeCode='" + paymentTypeCode + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", pointUseGroup='" + pointUseGroup + '\'' +
                ", productOrderState='" + productOrderState + '\'' +
                ", pointSave=" + pointSave +
                ", productOrderPointGroup='" + productOrderPointGroup + '\'' +
                '}';
    }

    public String getPaymentCompleteCode() {
        return paymentCompleteCode;
    }

    public void setPaymentCompleteCode(String paymentCompleteCode) {
        this.paymentCompleteCode = paymentCompleteCode;
    }

    public String getBuynowBasketTotalCode() {
        return buynowBasketTotalCode;
    }

    public void setBuynowBasketTotalCode(String buynowBasketTotalCode) {
        this.buynowBasketTotalCode = buynowBasketTotalCode;
    }

    public String getBuynowBasket() {
        return buynowBasket;
    }

    public void setBuynowBasket(String buynowBasket) {
        this.buynowBasket = buynowBasket;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getFinalPaymentAmount() {
        return finalPaymentAmount;
    }

    public void setFinalPaymentAmount(int finalPaymentAmount) {
        this.finalPaymentAmount = finalPaymentAmount;
    }

    public String getDeliCode() {
        return deliCode;
    }

    public void setDeliCode(String deliCode) {
        this.deliCode = deliCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPointUseGroup() {
        return pointUseGroup;
    }

    public void setPointUseGroup(String pointUseGroup) {
        this.pointUseGroup = pointUseGroup;
    }

    public String getProductOrderState() {
        return productOrderState;
    }

    public void setProductOrderState(String productOrderState) {
        this.productOrderState = productOrderState;
    }

    public int getPointSave() {
        return pointSave;
    }

    public void setPointSave(int pointSave) {
        this.pointSave = pointSave;
    }

    public String getProductOrderPointGroup() {
        return productOrderPointGroup;
    }

    public void setProductOrderPointGroup(String productOrderPointGroup) {
        this.productOrderPointGroup = productOrderPointGroup;
    }
}
