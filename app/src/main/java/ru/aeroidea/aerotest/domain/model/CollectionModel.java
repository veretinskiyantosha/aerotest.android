package ru.aeroidea.aerotest.domain.model;

public class CollectionModel {
    private String mName;
    private Integer mProductsCount;
    private String mImgUrl;

    public CollectionModel(String name, Integer productsCount, String imgUrl) {
        mName = name;
        mProductsCount = productsCount;
        mImgUrl = imgUrl;
    }

    public String getName() {
        return mName;
    }

    public Integer getProductsCount() {
        return mProductsCount;
    }

    public String getImgUrl() {
        return mImgUrl;
    }
}
