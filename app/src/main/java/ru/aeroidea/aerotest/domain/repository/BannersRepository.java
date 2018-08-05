package ru.aeroidea.aerotest.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import ru.aeroidea.aerotest.domain.model.BannerModel;

public interface BannersRepository {

    Observable<List<BannerModel>> getBanners();
}
