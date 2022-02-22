package com.quilt.entity;

import java.util.Date;

public class Article {

    private Integer id;

    private Integer userId;


    private String title;

    private Integer articleType;

    private Integer issueType;

    private String articlePic;

    private Integer viewCount;


    private Integer commentCount;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }


    public Integer getIssueType() {
        return issueType;
    }

    public void setIssueType(Integer issueType) {
        this.issueType = issueType;
    }


    public String getArticlePic() {
        return articlePic;
    }


    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic == null ? null : articlePic.trim();
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }


    public Integer getCommentCount() {
        return commentCount;
    }


    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}