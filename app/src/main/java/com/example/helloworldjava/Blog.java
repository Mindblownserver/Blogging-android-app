package com.example.helloworldjava;

import java.io.Serializable;

public class Blog implements Serializable {
    private static final long  serialVersionUID = 1L;

    private String title;
    private String author;
    private String subtitle;
    private String readTime;
    private String publishDate;
    private String image;

    public Blog(String title, String subtitle, String author,  String readTime, String publishDate, String image) {
        this.title = title;
        this.author = author;
        this.subtitle = subtitle;
        this.readTime = readTime;
        this.publishDate = publishDate;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getImage(){
        return image;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
