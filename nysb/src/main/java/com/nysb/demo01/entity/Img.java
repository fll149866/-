package com.nysb.demo01.entity;



import java.util.Arrays;

public class Img {

    private int id;

    private byte[] img;

    private int typeId;

    private String imgUrl;

    private int statusId;

    private ImgResult imgResult;

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", img=" + Arrays.toString(img) +
                ", typeId=" + typeId +
                ", imgUrl='" + imgUrl + '\'' +
                ", statusId=" + statusId +
                ", imgResult=" + imgResult +
                '}';
    }

    public Img() {
    }

    public Img(int id, byte[] img, int typeId, String imgUrl, int statusId, ImgResult imgResult) {
        this.id = id;
        this.img = img;
        this.typeId = typeId;
        this.imgUrl = imgUrl;
        this.statusId = statusId;
        this.imgResult = imgResult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public ImgResult getImgResult() {
        return imgResult;
    }

    public void setImgResult(ImgResult imgResult) {
        this.imgResult = imgResult;
    }
}
