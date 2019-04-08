package com.deerwalk.model;
public class Schedule {

    private int id;
    private String nmcCode;
    private String docName;
    private String hiId;
    private String hiName;
    private String hiType;
    private String startTime;
    private String endTime;
    private String day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setNmcCode(String nmcCode) {
        this.nmcCode = nmcCode;
    }

    public String getNmcCode() {
        return nmcCode;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocName() {
        return docName;
    }

    public void setHiId(String hiId) {
        this.hiId = hiId;
    }

    public String getHiId() {
        return hiId;
    }

    public void setHiName(String hiName) {
        this.hiName = hiName;
    }

    public String getHiName() {
        return hiName;
    }

    public void setHiType(String hiType) {
        this.hiType = hiType;
    }

    public String getHiType() {
        return hiType;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;

    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}


