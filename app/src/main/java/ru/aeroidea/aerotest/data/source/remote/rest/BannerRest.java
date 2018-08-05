package ru.aeroidea.aerotest.data.source.remote.rest;

import com.google.gson.annotations.SerializedName;

public class BannerRest {
    @SerializedName("id")
    private Integer mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("link")
    private String mLink;

    @SerializedName("mobilePicture")
    private String mMobilePicture;

    @SerializedName("tabletPicture")
    private String mTabletPicture;

    @SerializedName("type")
    private Integer mType;

    @SerializedName("content")
    private Object mContent;

    @SerializedName("itemId")
    private Integer mItemId;

    @SerializedName("breadCrumbTitle")
    private String mBreadCrumbTitle;

    @SerializedName("breadCrumbImg")
    private String mBreadCrumbImg;

    public Integer getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getLink() {
        return mLink;
    }

    public String getMobilePicture() {
        return mMobilePicture;
    }

    public String getTabletPicture() {
        return mTabletPicture;
    }

    public Integer getType() {
        return mType;
    }

    public Object getContent() {
        return mContent;
    }

    public Integer getItemId() {
        return mItemId;
    }

    public String getBreadCrumbTitle() {
        return mBreadCrumbTitle;
    }

    public String getBreadCrumbImg() {
        return mBreadCrumbImg;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public void setMobilePicture(String mobilePicture) {
        mMobilePicture = mobilePicture;
    }

    public void setTabletPicture(String tabletPicture) {
        mTabletPicture = tabletPicture;
    }

    public void setType(Integer type) {
        mType = type;
    }

    public void setContent(Object content) {
        mContent = content;
    }

    public void setItemId(Integer itemId) {
        mItemId = itemId;
    }

    public void setBreadCrumbTitle(String breadCrumbTitle) {
        mBreadCrumbTitle = breadCrumbTitle;
    }

    public void setBreadCrumbImg(String breadCrumbImg) {
        mBreadCrumbImg = breadCrumbImg;
    }
}
