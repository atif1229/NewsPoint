package com.example.newspoint;

public class News {

    private String title;
    private String link;
    private String detail;
    private String publishDate;
    private String image;

    public News() {
    }

    public News(String title, String link, String detail, String publishDate, String image) {
        this.title = title;
        this.link = link;
        this.detail = detail;
        this.publishDate = publishDate;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
