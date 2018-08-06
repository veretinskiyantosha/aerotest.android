package ru.aeroidea.aerotest.presentation.home;

import ru.aeroidea.aerotest.data.source.remote.rest.Content;
import ru.aeroidea.aerotest.presentation.base.BasePresenter;
import ru.aeroidea.aerotest.presentation.base.BaseView;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);

        void showContent(Content content);
    }

    interface Presenter extends BasePresenter<View> {
        void loadContent();

        void showDetail(String title);
    }
}
