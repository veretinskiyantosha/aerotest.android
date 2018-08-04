package ru.aeroidea.aerotest.di.module;

import dagger.Module;
import dagger.Provides;
import ru.aeroidea.aerotest.presentation.home.HomeContract;
import ru.aeroidea.aerotest.presentation.home.HomePresenter;

@Module
public class HomeModule {

    @Provides
    public HomeContract.Presenter providePresenter() {
        return new HomePresenter();
    }
}
