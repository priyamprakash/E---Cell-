package com.mitm.startupmit;

import androidx.annotation.Keep;

@Keep
public class Notification_Model {

    String date;
    String description;
    String link;
    String title;

    public Notification_Model() {
    }

    public Notification_Model(String date, String description, String link, String title) {
        this.date = date;
        this.description = description;
        this.link = link;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Notification_Model{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
