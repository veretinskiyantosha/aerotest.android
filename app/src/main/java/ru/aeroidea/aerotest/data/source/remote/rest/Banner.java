package ru.aeroidea.aerotest.data.source.remote.rest;

import com.google.gson.annotations.SerializedName;

public class Banner {
    @SerializedName("title")
    private String mTitle;

    @SerializedName("mobilePicture")
    private String mMobilePicture;

    public Banner(String title, String mobilePicture) {
        mTitle = title;
        mMobilePicture = mobilePicture;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getMobilePicture() {
        return mMobilePicture;
    }
}
