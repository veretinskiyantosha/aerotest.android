package ru.aeroidea.aerotest.domain.usecase;

import java.util.List;

import io.reactivex.Observable;
import ru.aeroidea.aerotest.domain.model.CollectionModel;
import ru.aeroidea.aerotest.domain.repository.CollectionsRepository;

public class GetCollectionsUseCase extends UseCase<GetCollectionsUseCase.RequestValues, GetCollectionsUseCase.ResponseValues> {
    private final CollectionsRepository mCollectionsRepository;

    public GetCollectionsUseCase(CollectionsRepository collectionsRepository) {
        mCollectionsRepository = collectionsRepository;
    }

    @Override
    protected Observable<ResponseValues> buildUseCaseObservable(RequestValues requestValues) {
        return mCollectionsRepository.getCollections().map(ResponseValues::new);
    }

    public static final class RequestValues implements UseCase.RequestValues {

    }

    public static final class ResponseValues implements UseCase.ResponseValues {
        private final List<CollectionModel> mCollections;

        public ResponseValues(List<CollectionModel> collections) {
            mCollections = collections;
        }

        public List<CollectionModel> getCollections() {
            return mCollections;
        }
    }
}
