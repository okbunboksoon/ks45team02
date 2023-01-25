package ks45team02.ire.admin.dto;

public class Incoming {
    private String incomingCode;
    private String goodsCode;
    private int incomingAmount;

    private String incomingDate;
    private float upcyclingCarbonDioxideEmissionLevel;
    private float totalCo2;

    @Override
    public String toString() {
        return "Incoming{" +
                "incomingCode='" + incomingCode + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", incomingAmount=" + incomingAmount +
                ", incomingDate='" + incomingDate + '\'' +
                ", upcyclingCarbonDioxideEmissionLevel=" + upcyclingCarbonDioxideEmissionLevel +
                ", totalCo2=" + totalCo2 +
                '}';
    }

    public String getIncomingCode() {
        return incomingCode;
    }

    public void setIncomingCode(String incomingCode) {
        this.incomingCode = incomingCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getIncomingAmount() {
        return incomingAmount;
    }

    public void setIncomingAmount(int incomingAmount) {
        this.incomingAmount = incomingAmount;
    }

    public String getIncomingDate() {
        return incomingDate;
    }

    public void setIncomingDate(String incomingDate) {
        this.incomingDate = incomingDate;
    }

    public float getUpcyclingCarbonDioxideEmissionLevel() {
        return upcyclingCarbonDioxideEmissionLevel;
    }

    public void setUpcyclingCarbonDioxideEmissionLevel(float upcyclingCarbonDioxideEmissionLevel) {
        this.upcyclingCarbonDioxideEmissionLevel = upcyclingCarbonDioxideEmissionLevel;
    }

    public float getTotalCo2() {
        return totalCo2;
    }

    public void setTotalCo2(float totalCo2) {
        this.totalCo2 = totalCo2;
    }
}
