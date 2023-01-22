package ks45team02.ire.admin.dto;

public class BoardEvent {
    private String eventCode;
    private String eventTitle;
    private String eventContents;
    private String eventStartDate;
    private String eventEndDate;
    private String eventRegdate;
    private String eventImageName;
    private String eventImagePath;

    private BoardEventFile boardEventFile;

    @Override
    public String toString() {
        return "BoardEvent{" +
                "eventCode='" + eventCode + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventContents='" + eventContents + '\'' +
                ", eventStartDate='" + eventStartDate + '\'' +
                ", eventEndDate='" + eventEndDate + '\'' +
                ", eventRegdate='" + eventRegdate + '\'' +
                ", eventImageName='" + eventImageName + '\'' +
                ", eventImagePath='" + eventImagePath + '\'' +
                ", boardEventFile=" + boardEventFile +
                '}';
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
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

    public String getEventImageName() {
        return eventImageName;
    }

    public void setEventImageName(String eventImageName) {
        this.eventImageName = eventImageName;
    }

    public String getEventImagePath() {
        return eventImagePath;
    }

    public void setEventImagePath(String eventImagePath) {
        this.eventImagePath = eventImagePath;
    }

    public BoardEventFile getBoardEventFile() {
        return boardEventFile;
    }

    public void setBoardEventFile(BoardEventFile boardEventFile) {
        this.boardEventFile = boardEventFile;
    }
}