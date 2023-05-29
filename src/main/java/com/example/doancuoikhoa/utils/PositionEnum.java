package com.example.doancuoikhoa.utils;

public enum PositionEnum {
    TEACHER(1, "TEACHER") , STUDENT(2, "STUDENT");
    private int positionId;
    private String positionName;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    PositionEnum(int positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }
}
