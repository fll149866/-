package com.nysb.demo01.entity;

public class Plant {

    private int id;

    private String shiQi;

    private String features;

    private String advice;

    private int typeId;

    private String imgUrl;

    private float percent;

    private Status status;

    private ImgResult imgResult;

    public ImgResult getImgResult() {
        return imgResult;
    }

    public void setImgResult(ImgResult imgResult) {
        this.imgResult = imgResult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShiQi() {
        return shiQi;
    }

    public void setShiQi(String shiQi) {
        this.shiQi = shiQi;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
