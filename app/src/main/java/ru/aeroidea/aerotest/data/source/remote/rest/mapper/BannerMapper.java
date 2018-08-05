package ru.aeroidea.aerotest.data.source.remote.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import ru.aeroidea.aerotest.data.source.remote.rest.BannerRest;
import ru.aeroidea.aerotest.domain.model.BannerModel;

public class BannerMapper {
    public BannerMapper() {
    }

    public BannerModel transform(BannerRest banner) {
        BannerModel bannerModel = null;

        if (banner != null) {
            bannerModel = new BannerModel(banner.getTitle(), banner.getMobilePicture());
        }

        return bannerModel;
    }

    public List<BannerModel> transformList(List<BannerRest> banners) {
        List<BannerModel> bannerModels = new ArrayList<>();

        for (BannerRest bannerRest : banners) {
            if (bannerRest != null) {
                bannerModels.add(transform(bannerRest));
            }
        }

        return bannerModels;
    }
}
