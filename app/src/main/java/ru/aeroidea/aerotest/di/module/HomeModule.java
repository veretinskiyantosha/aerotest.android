package ru.aeroidea.aerotest.di.module;

import dagger.Module;
import dagger.Provides;
import ru.aeroidea.aerotest.domain.repository.ContentRepository;
import ru.aeroidea.aerotest.domain.usecase.GetContentUseCase;
import ru.aeroidea.aerotest.presentation.home.HomeContract;
import ru.aeroidea.aerotest.presentation.home.HomePresenter;

@Module
public class HomeModule {

    @Provides
    public GetContentUseCase provideGetCollectionUseCase(ContentRepository contentRepository) {
        return new GetContentUseCase(contentRepository);
    }

    @Provides
    public HomeContract.Presenter providePresenter(GetContentUseCase getContentUseCase) {
        return new HomePresenter(getContentUseCase);
    }
}