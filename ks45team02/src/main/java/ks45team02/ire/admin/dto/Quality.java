package ks45team02.ire.admin.dto;

public class Quality {
    private String generalQualityLevel;
    private String durabilityTest;
    private String functionalTest;
    private String dyeabilityTest;
    private String hazadousQualityLevel;
    private Float formaldehydeTest;
    private Float phenolChlorideTest;
    private Float haramfulElementsTest;
    private String qualityCode;
    private String checkDate;
    private String incomingCode;
    private String goodsCode;
    private String goodsName;
    private String qualityResult;
    private Goods goods;
    private Incoming incoming;

    @Override
    public String toString() {
        return "Quality{" +
                "generalQualityLevel='" + generalQualityLevel + '\'' +
                ", durabilityTest='" + durabilityTest + '\'' +
                ", functionalTest='" + functionalTest + '\'' +
                ", dyeabilityTest='" + dyeabilityTest + '\'' +
                ", hazadousQualityLevel='" + hazadousQualityLevel + '\'' +
                ", formaldehydeTest=" + formaldehydeTest +
                ", phenolChlorideTest=" + phenolChlorideTest +
                ", haramfulElementsTest=" + haramfulElementsTest +
                ", qualityCode='" + qualityCode + '\'' +
                ", checkDate='" + checkDate + '\'' +
                ", incomingCode='" + incomingCode + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", qualityResult='" + qualityResult + '\'' +
                ", goods=" + goods +
                ", incoming=" + incoming +
                '}';
    }

    public String getGeneralQualityLevel() {
        return generalQualityLevel;
    }

    public void setGeneralQualityLevel(String generalQualityLevel) {
        this.generalQualityLevel = generalQualityLevel;
    }

    public String getDurabilityTest() {
        return durabilityTest;
    }

    public void setDurabilityTest(String durabilityTest) {
        this.durabilityTest = durabilityTest;
    }

    public String getFunctionalTest() {
        return functionalTest;
    }

    public void setFunctionalTest(String functionalTest) {
        this.functionalTest = functionalTest;
    }

    public String getDyeabilityTest() {
        return dyeabilityTest;
    }

    public void setDyeabilityTest(String dyeabilityTest) {
        this.dyeabilityTest = dyeabilityTest;
    }

    public String getHazadousQualityLevel() {
        return hazadousQualityLevel;
    }

    public void setHazadousQualityLevel(String hazadousQualityLevel) {
        this.hazadousQualityLevel = hazadousQualityLevel;
    }

    public Float getFormaldehydeTest() {
        return formaldehydeTest;
    }

    public void setFormaldehydeTest(Float formaldehydeTest) {
        this.formaldehydeTest = formaldehydeTest;
    }

    public Float getPhenolChlorideTest() {
        return phenolChlorideTest;
    }

    public void setPhenolChlorideTest(Float phenolChlorideTest) {
        this.phenolChlorideTest = phenolChlorideTest;
    }

    public Float getHaramfulElementsTest() {
        return haramfulElementsTest;
    }

    public void setHaramfulElementsTest(Float haramfulElementsTest) {
        this.haramfulElementsTest = haramfulElementsTest;
    }

    public String getQualityCode() {
        return qualityCode;
    }

    public void setQualityCode(String qualityCode) {
        this.qualityCode = qualityCode;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getQualityResult() {
        return qualityResult;
    }

    public void setQualityResult(String qualityResult) {
        this.qualityResult = qualityResult;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Incoming getIncoming() {
        return incoming;
    }

    public void setIncoming(Incoming incoming) {
        this.incoming = incoming;
    }
}
