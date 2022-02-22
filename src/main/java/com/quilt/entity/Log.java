package com.quilt.entity;

import java.util.Date;

public class Log {

    private Integer id;
    private String logType;
    private String logDetail;
    private String ip;
    private Date createTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogType() {
        return logType;
    }
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }
    public String getLogDetail() {
        return logDetail;
    }
    public void setLogDetail(String logDetail) {
        this.logDetail = logDetail == null ? null : logDetail.trim();
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", logType='" + logType + '\'' +
                ", logDetail='" + logDetail + '\'' +
                ", ip='" + ip + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}