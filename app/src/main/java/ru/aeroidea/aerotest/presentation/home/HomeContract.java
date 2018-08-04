package ru.aeroidea.aerotest.presentation.home;

import ru.aeroidea.aerotest.presentation.base.BasePresenter;
import ru.aeroidea.aerotest.presentation.base.BaseView;

public interface HomeContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
