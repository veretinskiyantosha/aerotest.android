package ru.aeroidea.aerotest.di.module;

import dagger.Module;
import dagger.Provides;
import ru.aeroidea.aerotest.presentation.home.banner.BannerContract;
import ru.aeroidea.aerotest.presentation.home.banner.BannerPresenter;

@Module
public class BannerModule {

    @Provides
    public BannerContract.Presenter providePresenter() {
        return new BannerPresenter();
    }
}
