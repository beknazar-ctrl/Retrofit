package com.example.retrofit.data.model;

import com.google.gson.annotations.SerializedName;

public class BoredApiModel {

    @SerializedName("activity")
    private String avtivities;

    @SerializedName("type")
    private String type;

    @SerializedName("price")
    private double price;

    public String getAvtivities() {
        return avtivities;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
