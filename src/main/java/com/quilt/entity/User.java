package com.quilt.entity;

import java.util.Date;

public class User {

    private Integer id;


    private String username;


    private String password;


    private String headPic;


    private String userNickname;


    private String userSignature;


    private String userEmail;


    private String userTag;


    private Date createTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public String getHeadPic() {
        return headPic;
    }


    public void setHeadPic(String headPic) {
        this.headPic = headPic == null ? null : headPic.trim();
    }


    public String getUserNickname() {
        return userNickname;
    }


    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }


    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature == null ? null : userSignature.trim();
    }


    public String getUserEmail() {
        return userEmail;
    }


    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }


    public String getUserTag() {
        return userTag;
    }


    public void setUserTag(String userTag) {
        this.userTag = userTag == null ? null : userTag.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headPic='" + headPic + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userTag='" + userTag + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}