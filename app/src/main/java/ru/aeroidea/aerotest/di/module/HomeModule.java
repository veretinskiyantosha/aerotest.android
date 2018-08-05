package ru.aeroidea.aerotest.di.module;

import dagger.Module;
import dagger.Provides;
import ru.aeroidea.aerotest.data.source.ContentDataSource;
import ru.aeroidea.aerotest.data.source.remote.ApiService;
import ru.aeroidea.aerotest.data.source.remote.rest.mapper.BannerMapper;
import ru.aeroidea.aerotest.data.source.remote.rest.mapper.CollectionMapper;
import ru.aeroidea.aerotest.di.scope.AppScope;
import ru.aeroidea.aerotest.di.scope.HomeScreenScope;
import ru.aeroidea.aerotest.domain.usecase.GetBannersUseCase;
import ru.aeroidea.aerotest.domain.usecase.GetCollectionsUseCase;
import ru.aeroidea.aerotest.presentation.home.HomeContract;
import ru.aeroidea.aerotest.presentation.home.HomePresenter;

@Module
public class HomeModule {

    @HomeScreenScope
    @Provides
    public BannerMapper provideBannerMapper() {
        return new BannerMapper();
    }

    @HomeScreenScope
    @Provides
    public CollectionMapper provideCollectionMapper() {
        return new CollectionMapper();
    }

    @HomeScreenScope
    @Provides
    public ContentDataSource provideContentDataSource(ApiService apiService,
                                                      BannerMapper bannerMapper,
                                                      CollectionMapper collectionMapper) {
        return new ContentDataSource(apiService, bannerMapper, collectionMapper);
    }

    @Provides
    public GetBannersUseCase provideGetBannersUseCase(ContentDataSource repository) {
        return new GetBannersUseCase(repository);
    }

    @Provides
    public GetCollectionsUseCase provideGetCollectionUseCase(ContentDataSource repository) {
        return new GetCollectionsUseCase(repository);
    }

    @Provides
    public HomeContract.Presenter providePresenter(GetBannersUseCase getBannersUseCase,
                                                   GetCollectionsUseCase getCollectionsUseCase) {
        return new HomePresenter(getBannersUseCase, getCollectionsUseCase);
    }
}