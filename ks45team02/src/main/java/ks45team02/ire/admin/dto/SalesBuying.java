package ks45team02.ire.admin.dto;

public class SalesBuying {
    private String salesBuyingDayGroupCode;
    private String salesBuyingDayCategory;
    private String productOrderPointGroup;
    private String incomingCode;
    private String regDate;
    private String goodsCode;
    private String userId;
    private int finalPaymentAmount;
    private int buyTotal;
    private String monthAndYear;
    private String salesBuyingMonthGroupCode;
    private String salesBuyingYearGroupCode;
    private String year;
    private int jan;
    private int feb;
    private int mar;
    private int apr;
    private int may;
    private int jun;
    private int jul;
    private int aug;
    private int sept;
    private int oct;
    private int nov;
    private int dec;
    private Goods goods;
    private User user;
    private Incoming incoming;

    @Override
    public String toString() {
        return "SalesBuying{" +
                "salesBuyingDayGroupCode='" + salesBuyingDayGroupCode + '\'' +
                ", salesBuyingDayCategory='" + salesBuyingDayCategory + '\'' +
                ", productOrderPointGroup='" + productOrderPointGroup + '\'' +
                ", incomingCode='" + incomingCode + '\'' +
                ", regDate='" + regDate + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", userId='" + userId + '\'' +
                ", finalPaymentAmount=" + finalPaymentAmount +
                ", buyTotal=" + buyTotal +
                ", monthAndYear='" + monthAndYear + '\'' +
                ", salesBuyingMonthGroupCode='" + salesBuyingMonthGroupCode + '\'' +
                ", salesBuyingYearGroupCode='" + salesBuyingYearGroupCode + '\'' +
                ", year='" + year + '\'' +
                ", jan=" + jan +
                ", feb=" + feb +
                ", mar=" + mar +
                ", apr=" + apr +
                ", may=" + may +
                ", jun=" + jun +
                ", jul=" + jul +
                ", aug=" + aug +
                ", sept=" + sept +
                ", oct=" + oct +
                ", nov=" + nov +
                ", dec=" + dec +
                ", goods=" + goods +
                ", user=" + user +
                ", incoming=" + incoming +
                '}';
    }

    public String getSalesBuyingDayGroupCode() {
        return salesBuyingDayGroupCode;
    }

    public void setSalesBuyingDayGroupCode(String salesBuyingDayGroupCode) {
        this.salesBuyingDayGroupCode = salesBuyingDayGroupCode;
    }

    public String getSalesBuyingDayCategory() {
        return salesBuyingDayCategory;
    }

    public void setSalesBuyingDayCategory(String salesBuyingDayCategory) {
        this.salesBuyingDayCategory = salesBuyingDayCategory;
    }

    public String getProductOrderPointGroup() {
        return productOrderPointGroup;
    }

    public void setProductOrderPointGroup(String productOrderPointGroup) {
        this.productOrderPointGroup = productOrderPointGroup;
    }

    public String getIncomingCode() {
        return incomingCode;
    }

    public void setIncomingCode(String incomingCode) {
        this.incomingCode = incomingCode;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
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

    public int getBuyTotal() {
        return buyTotal;
    }

    public void setBuyTotal(int buyTotal) {
        this.buyTotal = buyTotal;
    }

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    public String getSalesBuyingMonthGroupCode() {
        return salesBuyingMonthGroupCode;
    }

    public void setSalesBuyingMonthGroupCode(String salesBuyingMonthGroupCode) {
        this.salesBuyingMonthGroupCode = salesBuyingMonthGroupCode;
    }

    public String getSalesBuyingYearGroupCode() {
        return salesBuyingYearGroupCode;
    }

    public void setSalesBuyingYearGroupCode(String salesBuyingYearGroupCode) {
        this.salesBuyingYearGroupCode = salesBuyingYearGroupCode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getJan() {
        return jan;
    }

    public void setJan(int jan) {
        this.jan = jan;
    }

    public int getFeb() {
        return feb;
    }

    public void setFeb(int feb) {
        this.feb = feb;
    }

    public int getMar() {
        return mar;
    }

    public void setMar(int mar) {
        this.mar = mar;
    }

    public int getApr() {
        return apr;
    }

    public void setApr(int apr) {
        this.apr = apr;
    }

    public int getMay() {
        return may;
    }

    public void setMay(int may) {
        this.may = may;
    }

    public int getJun() {
        return jun;
    }

    public void setJun(int jun) {
        this.jun = jun;
    }

    public int getJul() {
        return jul;
    }

    public void setJul(int jul) {
        this.jul = jul;
    }

    public int getAug() {
        return aug;
    }

    public void setAug(int aug) {
        this.aug = aug;
    }

    public int getSept() {
        return sept;
    }

    public void setSept(int sept) {
        this.sept = sept;
    }

    public int getOct() {
        return oct;
    }

    public void setOct(int oct) {
        this.oct = oct;
    }

    public int getNov() {
        return nov;
    }

    public void setNov(int nov) {
        this.nov = nov;
    }

    public int getDec() {
        return dec;
    }

    public void setDec(int dec) {
        this.dec = dec;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Incoming getIncoming() {
        return incoming;
    }

    public void setIncoming(Incoming incoming) {
        this.incoming = incoming;
    }
}
