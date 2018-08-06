package ru.aeroidea.aerotest.data.source;

import io.reactivex.Observable;
import ru.aeroidea.aerotest.data.source.remote.ApiService;
import ru.aeroidea.aerotest.data.source.remote.rest.Content;
import ru.aeroidea.aerotest.domain.repository.ContentRepository;

public class ContentDataSource implements ContentRepository {
    private ApiService mApiService;

    private Content mCachedContent;

    public ContentDataSource(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public Observable<Content> getMainContent() {
        if (mCachedContent != null) {
            return Observable.just(mCachedContent);
        } else {
            return mApiService.getMainContent("ru")
                    .doOnNext(content -> mCachedContent = content);
        }
    }
}
