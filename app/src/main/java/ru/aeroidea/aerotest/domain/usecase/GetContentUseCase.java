package ru.aeroidea.aerotest.domain.usecase;

import io.reactivex.Observable;
import ru.aeroidea.aerotest.data.source.remote.rest.Content;
import ru.aeroidea.aerotest.domain.repository.ContentRepository;

public class GetContentUseCase extends UseCase<GetContentUseCase.RequestValues, GetContentUseCase.ResponseValues> {
    private final ContentRepository mContentRepository;

    public GetContentUseCase(ContentRepository contentRepository) {
        mContentRepository = contentRepository;
    }

    @Override
    protected Observable<ResponseValues> buildUseCaseObservable(RequestValues requestValues) {
        return mContentRepository.getMainContent().map(ResponseValues::new);
    }

    public static final class RequestValues implements UseCase.RequestValues {

    }

    public static final class ResponseValues implements UseCase.ResponseValues {
        private final Content mContent;

        public ResponseValues(Content content) {
            mContent = content;
        }

        public Content getContent() {
            return mContent;
        }
    }
}
