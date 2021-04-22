package com.nysb.demo01.entity;


import java.util.Date;

/**
 * `id` varchar(255) NOT NULL COMMENT '用户唯一标识',
 *   `name` varchar(255) DEFAULT NULL COMMENT '用户名',6
 *   `pwd` varchar(255) DEFAULT NULL COMMENT '密码',
 *   `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
 *   `head_img` varchar(255) DEFAULT NULL COMMENT '头像',
 *   `create_time` datetime DEFAULT NULL COMMENT '创建日期',
 *   `identity` int(255) DEFAULT NULL COMMENT '0普通用户/1会员',
 */
public class User {

    private String id;

    private String name;

    private String pwd;

    private String phone;

    private String headImg;

    private Date createTime;

    private Integer identity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }
}
