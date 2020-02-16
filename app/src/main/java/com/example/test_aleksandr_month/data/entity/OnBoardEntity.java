package com.example.test_aleksandr_month.data.entity;

public class OnBoardEntity {

    private String title;
    private int image;

    public OnBoardEntity(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
