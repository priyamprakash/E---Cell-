package com.mitm.startupmit;

public class Team_Model {
    private int id;
    private String name;
    private String email;
    private String batch;
    private String designation;
    private String url;
    private int image;

    public Team_Model(int id, String name, String email, String batch,String designation, String url, int image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.batch = batch;
        this.designation = designation;
        this.url = url;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBatch() {
        return batch;
    }

    public String getUrl() {
        return url;
    }

    public String getDesignation() {
        return designation;
    }

    public int getImage() {
        return image;
    }
}
