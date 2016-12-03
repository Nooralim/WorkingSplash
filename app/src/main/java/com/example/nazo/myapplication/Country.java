package com.example.nazo.myapplication;

/**
 * Created by Nazo on 12/2/2016.
 */

public class Country {
    private String name;
    private int picture_id;

    public Country(String name, int picture_id){

        this.setName(name);
        this.setPicture_id(picture_id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }


}
