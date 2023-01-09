package ks45team02.ire.admin.dto;

public class Outgoing {
    private String outgoingCode;
    private String goodsCode;
    private int outgoingAmount;
    private int stockAmount;
    private String outgoingDate;
    private String paymentCompleteCode;
    private String deliveryCode;


    @Override
    public String toString() {
        return "Outgoing{" +
                "outgoingCode='" + outgoingCode + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", outgoingAmount=" + outgoingAmount +
                ", stockAmount=" + stockAmount +
                ", outgoingDate='" + outgoingDate + '\'' +
                ", paymentCompleteCode='" + paymentCompleteCode + '\'' +
                ", deliveryCode='" + deliveryCode + '\'' +
                '}';
    }

    public String getOutgoingCode() {
        return outgoingCode;
    }

    public void setOutgoingCode(String outgoingCode) {
        this.outgoingCode = outgoingCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getOutgoingAmount() {
        return outgoingAmount;
    }

    public void setOutgoingAmount(int outgoingAmount) {
        this.outgoingAmount = outgoingAmount;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getOutgoingDate() {
        return outgoingDate;
    }

    public void setOutgoingDate(String outgoingDate) {
        this.outgoingDate = outgoingDate;
    }

    public String getPaymentCompleteCode() {
        return paymentCompleteCode;
    }

    public void setPaymentCompleteCode(String paymentCompleteCode) {
        this.paymentCompleteCode = paymentCompleteCode;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }
}
