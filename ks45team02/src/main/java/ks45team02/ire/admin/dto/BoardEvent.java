package ks45team02.ire.admin.dto;

public class BoardEvent {
    private String eventNum;
    private String eventTitle;
    private String eventContents;
    private String eventImage;
    private String eventStartDate;
    private String eventEndDate;
    private String eventRegdate;


    @Override
    public String toString() {
        return "BoardEvent{" +
                "eventNum='" + eventNum + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventContents='" + eventContents + '\'' +
                ", eventImage='" + eventImage + '\'' +
                ", eventStartDate='" + eventStartDate + '\'' +
                ", eventEndDate='" + eventEndDate + '\'' +
                ", eventRegdate='" + eventRegdate + '\'' +
                '}';
    }

    public String getEventNum() {
        return eventNum;
    }

    public void setEventNum(String eventNum) {
        this.eventNum = eventNum;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventContents() {
        return eventContents;
    }

    public void setEventContents(String eventContents) {
        this.eventContents = eventContents;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventRegdate() {
        return eventRegdate;
    }

    public void setEventRegdate(String eventRegdate) {
        this.eventRegdate = eventRegdate;
    }
}