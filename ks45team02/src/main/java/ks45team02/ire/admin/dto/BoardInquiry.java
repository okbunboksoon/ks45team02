package ks45team02.ire.admin.dto;

public class BoardInquiry {
    //아니 왜 안올라가니...

    private String inquiryCode;
    private String userId;
    private String inquiryCate;
    private String inquiryTitle;
    private String inquiryContents;
    private String inquiryFile;
    private String inquiryRegDate;
    private int inquiryReRef;
    private int inquiryReLev;

    public String getInquiryCode() {
        return inquiryCode;
    }

    public void setInquiryCode(String inquiryCode) {
        this.inquiryCode = inquiryCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInquiryCate() {
        return inquiryCate;
    }

    public void setInquiryCate(String inquiryCate) {
        this.inquiryCate = inquiryCate;
    }

    public String getInquiryTitle() {
        return inquiryTitle;
    }

    public void setInquiryTitle(String inquiryTitle) {
        this.inquiryTitle = inquiryTitle;
    }

    public String getInquiryContents() {
        return inquiryContents;
    }

    public void setInquiryContents(String inquiryContents) {
        this.inquiryContents = inquiryContents;
    }

    public String getInquiryFile() {
        return inquiryFile;
    }

    public void setInquiryFile(String inquiryFile) {
        this.inquiryFile = inquiryFile;
    }

    public String getInquiryRegDate() {
        return inquiryRegDate;
    }

    public void setInquiryRegDate(String inquiryRegDate) {
        this.inquiryRegDate = inquiryRegDate;
    }

    public int getInquiryReRef() {
        return inquiryReRef;
    }

    public void setInquiryReRef(int inquiryReRef) {
        this.inquiryReRef = inquiryReRef;
    }

    public int getInquiryReLev() {
        return inquiryReLev;
    }

    public void setInquiryReLev(int inquiryReLev) {
        this.inquiryReLev = inquiryReLev;
    }

    @Override
    public String toString() {
        return "BoardInquiry{" +
                "inquiryCode='" + inquiryCode + '\'' +
                ", userId='" + userId + '\'' +
                ", inquiryCate='" + inquiryCate + '\'' +
                ", inquiryTitle='" + inquiryTitle + '\'' +
                ", inquiryContents='" + inquiryContents + '\'' +
                ", inquiryFile='" + inquiryFile + '\'' +
                ", inquiryRegDate='" + inquiryRegDate + '\'' +
                ", inquiryReRef=" + inquiryReRef +
                ", inquiryReLev=" + inquiryReLev +
                '}';
    }
}
