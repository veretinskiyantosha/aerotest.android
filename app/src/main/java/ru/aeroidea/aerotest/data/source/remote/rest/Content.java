package ru.aeroidea.aerotest.data.source.remote.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Content {
    @SerializedName("collections")
    private List<Collection> mCollections;

    @SerializedName("banners")
    private List<Banner> mBanners;

    public Content(List<Collection> collections, List<Banner> banners) {
        mCollections = collections;
        mBanners = banners;
    }

    public List<Collection> getCollections() {
        return mCollections;
    }

    public List<Banner> getBanners() {
        return mBanners;
    }
}
