package ru.aeroidea.aerotest.data.source.remote.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContentRest {
    @SerializedName("collections")
    private List<CollectionRest> mCollections;

    @SerializedName("banners")
    private List<BannerRest> mBanners;

    public List<CollectionRest> getCollections() {
        return mCollections;
    }

    public List<BannerRest> getBanners() {
        return mBanners;
    }

    public void setCollections(List<CollectionRest> collections) {
        mCollections = collections;
    }

    public void setBanners(List<BannerRest> banners) {
        mBanners = banners;
    }
}
