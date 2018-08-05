package ru.aeroidea.aerotest.presentation.home;

import ru.aeroidea.aerotest.domain.usecase.CallbackWrapper;
import ru.aeroidea.aerotest.domain.usecase.GetBannersUseCase;
import ru.aeroidea.aerotest.domain.usecase.GetCollectionsUseCase;

public class HomePresenter implements HomeContract.Presenter {
    private static final String TAG = HomePresenter.class.getName();

    private HomeContract.View mView;
    private GetBannersUseCase mGetBannersUseCase;
    private GetCollectionsUseCase mGetCollectionsUseCase;

    public HomePresenter(GetBannersUseCase getBannersUseCase, GetCollectionsUseCase getCollectionsUseCase) {
        mGetBannersUseCase = getBannersUseCase;
        mGetCollectionsUseCase = getCollectionsUseCase;
    }

    @Override
    public void bind(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    @Override
    public void loadBanners() {
        mGetBannersUseCase.executeUseCase(new CallbackWrapper<GetBannersUseCase.ResponseValues>() {
            @Override
            public void onSuccess(GetBannersUseCase.ResponseValues responseValues) {
                mView.showBanners(responseValues.getBanners());
            }
        }, new GetBannersUseCase.RequestValues());
    }

    @Override
    public void loadCollections() {
        mGetCollectionsUseCase.executeUseCase(new CallbackWrapper<GetCollectionsUseCase.ResponseValues>() {
            @Override
            public void onSuccess(GetCollectionsUseCase.ResponseValues responseValues) {
                mView.showCollections(responseValues.getCollections());
            }
        }, new GetCollectionsUseCase.RequestValues());
    }

    @Override
    public void showBannerDetail(String title) {

    }

    @Override
    public void showCollectionDetail(String title) {

    }
}
