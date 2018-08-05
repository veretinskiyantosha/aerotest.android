package ru.aeroidea.aerotest.domain.usecase;

import java.util.List;

import io.reactivex.Observable;
import ru.aeroidea.aerotest.domain.model.BannerModel;
import ru.aeroidea.aerotest.domain.repository.BannersRepository;

public class GetBannersUseCase extends UseCase<GetBannersUseCase.RequestValues, GetBannersUseCase.ResponseValues> {
    private final BannersRepository mBannersRepository;

    public GetBannersUseCase(BannersRepository bannersRepository) {
        mBannersRepository = bannersRepository;
    }

    @Override
    protected Observable<ResponseValues> buildUseCaseObservable(RequestValues requestValues) {
        return mBannersRepository.getBanners().map(ResponseValues::new);
    }

    public static final class RequestValues implements UseCase.RequestValues {

    }

    public static final class ResponseValues implements UseCase.ResponseValues {
        private final List<BannerModel> mBanners;

        public ResponseValues(List<BannerModel> banners) {
            mBanners = banners;
        }

        public List<BannerModel> getBanners() {
            return mBanners;
        }
    }
}
