package ru.aeroidea.aerotest.data.source.remote.rest;

import com.google.gson.annotations.SerializedName;

public class Collection {
    @SerializedName("name")
    private String mName;

    @SerializedName("img")
    private String mImg;

    @SerializedName("productsCount")
    private Integer mProductsCount;

    public Collection(String name, String img, Integer productsCount) {
        mName = name;
        mImg = img;
        mProductsCount = productsCount;
    }

    public String getName() {
        return mName;
    }

    public String getImg() {
        return mImg;
    }

    public Integer getProductsCount() {
        return mProductsCount;
    }
}
