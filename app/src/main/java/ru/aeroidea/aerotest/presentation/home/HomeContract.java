package ru.aeroidea.aerotest.presentation.home;

import java.util.List;

import ru.aeroidea.aerotest.domain.model.BannerModel;
import ru.aeroidea.aerotest.domain.model.CollectionModel;
import ru.aeroidea.aerotest.presentation.base.BasePresenter;
import ru.aeroidea.aerotest.presentation.base.BaseView;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showBanners(List<BannerModel> banners);

        void showCollections(List<CollectionModel> collections);
    }

    interface Presenter extends BasePresenter<View> {
        void loadBanners();

        void loadCollections();

        void showDetail(String title);
    }
}
