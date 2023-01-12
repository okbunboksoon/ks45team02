package ks45team02.ire.admin.dto;

public class BoardEventFile {
    private String eventFileIdx;
    private String eventFileOriginalName;
    private String eventFileNewName;
    private String eventFilePath;
    private Long eventFileSize;

    @Override
    public String toString() {
        return "EventFile{" +
                "eventFileIdx='" + eventFileIdx + '\'' +
                ", eventFileOriginalName='" + eventFileOriginalName + '\'' +
                ", eventFileNewName='" + eventFileNewName + '\'' +
                ", eventFilePath='" + eventFilePath + '\'' +
                ", eventFileSize=" + eventFileSize +
                '}';
    }

    public String getEventFileIdx() {
        return eventFileIdx;
    }

    public void setEventFileIdx(String eventFileIdx) {
        this.eventFileIdx = eventFileIdx;
    }

    public String getEventFileOriginalName() {
        return eventFileOriginalName;
    }

    public void setEventFileOriginalName(String eventFileOriginalName) {
        this.eventFileOriginalName = eventFileOriginalName;
    }

    public String getEventFileNewName() {
        return eventFileNewName;
    }

    public void setEventFileNewName(String eventFileNewName) {
        this.eventFileNewName = eventFileNewName;
    }

    public String getEventFilePath() {
        return eventFilePath;
    }

    public void setEventFilePath(String eventFilePath) {
        this.eventFilePath = eventFilePath;
    }

    public Long getEventFileSize() {
        return eventFileSize;
    }

    public void setEventFileSize(Long eventFileSize) {
        this.eventFileSize = eventFileSize;
    }

    public void add(String boardeventFileIdx) {
    }
}
