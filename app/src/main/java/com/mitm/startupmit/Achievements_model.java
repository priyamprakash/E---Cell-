package com.mitm.startupmit;

public class Achievements_model {

    String description;
    String title;
    String members;

    public Achievements_model() {
    }

    public Achievements_model(String description, String title , String members) {
        this.description = description;
        this.title = title;
        this.members = members;
    }

    @Override
    public String toString() {
        return "Achievements_model{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", members='" + members + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }
}
