package ru.aeroidea.aerotest.data.source;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import ru.aeroidea.aerotest.data.source.remote.ApiService;
import ru.aeroidea.aerotest.data.source.remote.rest.BannerRest;
import ru.aeroidea.aerotest.data.source.remote.rest.CollectionRest;
import ru.aeroidea.aerotest.data.source.remote.rest.mapper.BannerMapper;
import ru.aeroidea.aerotest.data.source.remote.rest.mapper.CollectionMapper;
import ru.aeroidea.aerotest.domain.model.BannerModel;
import ru.aeroidea.aerotest.domain.model.CollectionModel;
import ru.aeroidea.aerotest.domain.repository.BannersRepository;
import ru.aeroidea.aerotest.domain.repository.CollectionsRepository;

public class ContentDataSource implements BannersRepository, CollectionsRepository {
    private ApiService mApiService;
    private BannerMapper mBannerMapper;
    private CollectionMapper mCollectionMapper;

    private List<BannerRest> mCachedBanners;
    private List<CollectionRest> mCachedCollections;

    public ContentDataSource(ApiService apiService, BannerMapper bannerMapper, CollectionMapper collectionMapper) {
        mApiService = apiService;
        mBannerMapper = bannerMapper;
        mCollectionMapper = collectionMapper;
    }

    @Override
    public Observable<List<BannerModel>> getBanners() {
        if (mCachedBanners != null) {
            return Observable.just(mBannerMapper.transformList(mCachedBanners));
        } else {
            return mApiService.getMainContent("ru")
                    .doOnNext(contentRest ->
                            refreshCache(contentRest.getBanners(), contentRest.getCollections())
                    ).map(contentRest -> mBannerMapper.transformList(contentRest.getBanners()));
        }
    }

    @Override
    public Observable<List<CollectionModel>> getCollections() {
        if (mCachedCollections != null) {
            return Observable.just(mCollectionMapper.transformList(mCachedCollections));
        } else {
            return mApiService.getMainContent("ru")
                    .doOnNext(contentRest ->
                            refreshCache(contentRest.getBanners(), contentRest.getCollections())
                    ).map(contentRest ->
                            mCollectionMapper.transformList(contentRest.getCollections())
                    );
        }
    }

    private void refreshCache(List<BannerRest> banners, List<CollectionRest> collections) {
        mCachedBanners = new LinkedList<>(banners);
        mCachedCollections = new LinkedList<>(collections);
    }
}
