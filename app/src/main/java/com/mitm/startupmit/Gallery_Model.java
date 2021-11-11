package com.mitm.startupmit;

public class Gallery_Model {
    private String url;

    public Gallery_Model(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Gallery_Model{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
