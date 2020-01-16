package com.keeyoshi.foodmandu.ui.home.Model;

import java.util.ArrayList;
import java.util.List;

public class Super7 {

    static List<Super7> superlist=new ArrayList<>();
    private String image;
    private String cafe;
    private String dish;
    private String location;
    private int icon;

    public Super7(String image, String cafe, String dish, String location, int icon) {
        this.image = image;
        this.cafe = cafe;
        this.dish = dish;
        this.location = location;
        this.icon = icon;
    }

    public static List<Super7> getSuperlist() {
        return superlist;
    }

    public static void setSuperlist(List<Super7> superlist) {
        Super7.superlist = superlist;
    }

    public String  getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
