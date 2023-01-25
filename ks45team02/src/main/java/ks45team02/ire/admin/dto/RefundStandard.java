package ks45team02.ire.admin.dto;

public class RefundStandard {
    private String refundStandardCode;
    private String goodsRefundCondition;
    private String refundStandard;

    @Override
    public String toString() {
        return "RefundStandard{" +
                "refundStandardCode='" + refundStandardCode + '\'' +
                ", goodsRefundCondition='" + goodsRefundCondition + '\'' +
                ", refundStandard='" + refundStandard + '\'' +
                '}';
    }

    public String getRefundStandardCode() {
        return refundStandardCode;
    }

    public void setRefundStandardCode(String refundStandardCode) {
        this.refundStandardCode = refundStandardCode;
    }

    public String getGoodsRefundCondition() {
        return goodsRefundCondition;
    }

    public void setGoodsRefundCondition(String goodsRefundCondition) {
        this.goodsRefundCondition = goodsRefundCondition;
    }

    public String getRefundStandard() {
        return refundStandard;
    }

    public void setRefundStandard(String refundStandard) {
        this.refundStandard = refundStandard;
    }
}
