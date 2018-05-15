package com.example.kcruz.labo6tabs.models;

public class Restaurant {
    private String type; //chinese, mediterranean
    private int photo;
    private String name;
    private String description;

    public Restaurant() {
    }

    public Restaurant(String type, int photo, String name, String description) {
        this.type = type;
        this.photo = photo;
        this.name = name;
        this.description = description;
    }


    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
