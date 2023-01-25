package ks45team02.ire.admin.dto;

public class RawMaterialsOutgoing {
    private String rawMaterialsOutgoingCode;
    private int rawMaterialsOutgoingAmount;
    private String rawMaterialsOutgoingDate;
    private String rawMaterialsCode;
    private String businessCode;

    private Business business;
    private RawMaterials rawMaterials;

    @Override
    public String toString() {
        return "RawMaterialsOutgoing{" +
                "rawMaterialsOutgoingCode='" + rawMaterialsOutgoingCode + '\'' +
                ", rawMaterialsOutgoingAmount=" + rawMaterialsOutgoingAmount +
                ", rawMaterialsOutgoingDate='" + rawMaterialsOutgoingDate + '\'' +
                ", rawMaterialsCode='" + rawMaterialsCode + '\'' +
                ", businessCode='" + businessCode + '\'' +
                ", business=" + business +
                ", rawMaterials=" + rawMaterials +
                '}';
    }

    public String getRawMaterialsOutgoingCode() {
        return rawMaterialsOutgoingCode;
    }

    public void setRawMaterialsOutgoingCode(String rawMaterialsOutgoingCode) {
        this.rawMaterialsOutgoingCode = rawMaterialsOutgoingCode;
    }

    public int getRawMaterialsOutgoingAmount() {
        return rawMaterialsOutgoingAmount;
    }

    public void setRawMaterialsOutgoingAmount(int rawMaterialsOutgoingAmount) {
        this.rawMaterialsOutgoingAmount = rawMaterialsOutgoingAmount;
    }

    public String getRawMaterialsOutgoingDate() {
        return rawMaterialsOutgoingDate;
    }

    public void setRawMaterialsOutgoingDate(String rawMaterialsOutgoingDate) {
        this.rawMaterialsOutgoingDate = rawMaterialsOutgoingDate;
    }

    public String getRawMaterialsCode() {
        return rawMaterialsCode;
    }

    public void setRawMaterialsCode(String rawMaterialsCode) {
        this.rawMaterialsCode = rawMaterialsCode;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public RawMaterials getRawMaterials() {
        return rawMaterials;
    }

    public void setRawMaterials(RawMaterials rawMaterials) {
        this.rawMaterials = rawMaterials;
    }
}
