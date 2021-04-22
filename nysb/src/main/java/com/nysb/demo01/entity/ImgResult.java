package com.nysb.demo01.entity;

public class ImgResult {

    /**
     * `id` int(11) NOT NULL,
     *   `type` int(255) DEFAULT NULL COMMENT '类型',
     *   `name` varchar(255) DEFAULT NULL COMMENT '病虫害名称',
     *   `content` varchar(255) DEFAULT NULL COMMENT '识别内容',
     *
     */
    private int id;

    private int type;

    private String name;

    private String content;

    private float percent;

    private String desc;

    private Plant plant;

    private Status status;

    @Override
    public String toString() {
        return "ImgResult{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", percent=" + percent +
                ", desc='" + desc + '\'' +
                ", plant=" + plant +
                ", status=" + status +
                '}';
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
