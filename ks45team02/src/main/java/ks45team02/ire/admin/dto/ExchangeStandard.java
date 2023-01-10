package ks45team02.ire.admin.dto;

public class ExchangeStandard {
    private String exchangeStandardCode;
    private String goodsExchangeCondition;
    private String exchangeInfo;

    @Override
    public String toString() {
        return "ExchangeStandard{" +
                "exchangeStandardCode='" + exchangeStandardCode + '\'' +
                ", goodsExchangeCondition='" + goodsExchangeCondition + '\'' +
                ", exchangeInfo='" + exchangeInfo + '\'' +
                '}';
    }

    public String getExchangeStandardCode() {
        return exchangeStandardCode;
    }

    public void setExchangeStandardCode(String exchangeStandardCode) {
        this.exchangeStandardCode = exchangeStandardCode;
    }

    public String getGoodsExchangeCondition() {
        return goodsExchangeCondition;
    }

    public void setGoodsExchangeCondition(String goodsExchangeCondition) {
        this.goodsExchangeCondition = goodsExchangeCondition;
    }

    public String getExchangeInfo() {
        return exchangeInfo;
    }

    public void setExchangeInfo(String exchangeInfo) {
        this.exchangeInfo = exchangeInfo;
    }
}
