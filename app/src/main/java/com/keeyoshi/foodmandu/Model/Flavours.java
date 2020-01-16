package com.keeyoshi.foodmandu.Model;

import java.util.ArrayList;
import java.util.List;

public class Flavours {
    static List<Flavours> flavoursList=new ArrayList<>();
    private String image;
    private String item;
    private String cafe;

    public Flavours(String image, String item, String cafe) {
        this.image = image;
        this.item = item;
        this.cafe = cafe;
    }

    public static List<Flavours> getFlavoursList() {
        return flavoursList;
    }

    public static void setFlavoursList(List<Flavours> flavoursList) {
        Flavours.flavoursList = flavoursList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }
}
