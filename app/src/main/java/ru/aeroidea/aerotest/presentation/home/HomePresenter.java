package ru.aeroidea.aerotest.presentation.home;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View mView;

    public HomePresenter() {
    }

    @Override
    public void bind(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
