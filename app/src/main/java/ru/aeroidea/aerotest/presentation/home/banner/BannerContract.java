package ru.aeroidea.aerotest.presentation.home.banner;

import ru.aeroidea.aerotest.presentation.base.BasePresenter;
import ru.aeroidea.aerotest.presentation.base.BaseView;

public interface BannerContract {
    interface View extends BaseView<BannerContract.Presenter> {
    }

    interface Presenter extends BasePresenter<BannerContract.View> {
        void showDetail(String title);
    }
}
