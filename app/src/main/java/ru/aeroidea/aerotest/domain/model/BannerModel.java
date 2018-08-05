package ru.aeroidea.aerotest.domain.model;

public class BannerModel {
    private String mTitle;
    private String mPictureUrl;

    public BannerModel(String title, String pictureUrl) {
        mTitle = title;
        mPictureUrl = pictureUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPictureUrl() {
        return mPictureUrl;
    }
}
