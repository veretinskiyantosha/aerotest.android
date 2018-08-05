package ru.aeroidea.aerotest.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import ru.aeroidea.aerotest.domain.model.CollectionModel;

public interface CollectionsRepository {

    Observable<List<CollectionModel>> getCollections();
}