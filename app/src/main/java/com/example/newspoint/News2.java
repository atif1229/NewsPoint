package com.example.newspoint;

public class News2 {


    private String title;
    private String link;
    private String image;
    private String detail;
    private String publishDate;

    public News2() {
    }

    public News2(String title, String link, String image, String detail, String publishDate) {

        this.title = title;
        this.link = link;
        this.image = image;
        this.detail = detail;
        this.publishDate = publishDate;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}

