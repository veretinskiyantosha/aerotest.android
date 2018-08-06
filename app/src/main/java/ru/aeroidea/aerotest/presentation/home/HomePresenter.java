package ru.aeroidea.aerotest.presentation.home;

import ru.aeroidea.aerotest.App;
import ru.aeroidea.aerotest.domain.usecase.CallbackWrapper;
import ru.aeroidea.aerotest.domain.usecase.GetContentUseCase;
import ru.aeroidea.aerotest.presentation.screens.DetailScreen;

public class HomePresenter implements HomeContract.Presenter {
    private static final String TAG = HomePresenter.class.getName();

    private HomeContract.View mView;
    private GetContentUseCase mGetContentUseCase;

    public HomePresenter(GetContentUseCase contentUseCase) {
        mGetContentUseCase = contentUseCase;
    }

    @Override
    public void bind(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mGetContentUseCase.dispose();
        mView = null;
    }

    @Override
    public void loadContent() {
        mView.setLoadingIndicator(true);
        mGetContentUseCase.executeUseCase(new CallbackWrapper<GetContentUseCase.ResponseValues>() {
            @Override
            public void onSuccess(GetContentUseCase.ResponseValues responseValues) {
                mView.setLoadingIndicator(false);
                mView.showContent(responseValues.getContent());
            }

            @Override
            public void onError(Throwable e) {
                mView.setLoadingIndicator(false);
            }
        }, new GetContentUseCase.RequestValues());
    }

    @Override
    public void showDetail(String title) {
        App.getComponent().getNavigator().goForward(new DetailScreen(title));
    }
}
