package com.quilt.entity;

public class ArticleWithBLOBs extends Article {

    private String markdownContent;


    private String htmlContent;

    public String getMarkdownContent() {
        return markdownContent;
    }


    public void setMarkdownContent(String markdownContent) {
        this.markdownContent = markdownContent == null ? null : markdownContent.trim();
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent == null ? null : htmlContent.trim();
    }
}