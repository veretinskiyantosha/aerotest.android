package ru.aeroidea.aerotest.presentation.home.banner;

import ru.aeroidea.aerotest.App;
import ru.aeroidea.aerotest.presentation.screens.DetailScreen;

public class BannerPresenter implements BannerContract.Presenter {
    private BannerContract.View mView;

    public BannerPresenter() {
    }

    @Override
    public void showDetail(String title) {
        App.getComponent().getNavigator().goForward(new DetailScreen(title));
    }

    @Override
    public void bind(BannerContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
