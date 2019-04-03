package com.example.cardswapviewpager;

public class Modle {
    private int image;
    private String title;
    private String dsc;

    public Modle(int image, String title, String dsc) {
        this.image = image;
        this.title = title;
        this.dsc = dsc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }
}
