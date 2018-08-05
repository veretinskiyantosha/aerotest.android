package ru.aeroidea.aerotest.data.source.remote.rest;

import com.google.gson.annotations.SerializedName;

public class CollectionRest {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("img")
    private String mImg;

    @SerializedName("productsCount")
    private Integer mProductsCount;

    public Integer getId() {
        return mId;
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

    public void setId(Integer id) {
        mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setImg(String img) {
        mImg = img;
    }

    public void setProductsCount(Integer productsCount) {
        mProductsCount = productsCount;
    }
}
