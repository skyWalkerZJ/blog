package com.quilt.entity;

import java.util.Date;

public class Visitor {

    private Integer id;


    private String ip;


    private String brower;


    private Date createTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getIp() {
        return ip;
    }


    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }


    public String getBrower() {
        return brower;
    }


    public void setBrower(String brower) {
        this.brower = brower == null ? null : brower.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}