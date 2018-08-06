package ru.aeroidea.aerotest.di.module;

import dagger.Module;
import dagger.Provides;
import ru.aeroidea.aerotest.data.source.ContentDataSource;
import ru.aeroidea.aerotest.data.source.remote.ApiService;
import ru.aeroidea.aerotest.di.scope.AppScope;
import ru.aeroidea.aerotest.domain.repository.ContentRepository;

@Module
public class ContentModule {

    @AppScope
    @Provides
    public ContentRepository provideContentDataSource(ApiService apiService) {
        return new ContentDataSource(apiService);
    }
}
