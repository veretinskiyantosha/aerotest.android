package ru.aeroidea.aerotest.data.source.remote.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import ru.aeroidea.aerotest.data.source.remote.rest.CollectionRest;
import ru.aeroidea.aerotest.domain.model.CollectionModel;

public class CollectionMapper {
    public CollectionMapper() {
    }

    public CollectionModel transform(CollectionRest collection) {
        CollectionModel collectionModel = null;

        if (collection != null) {
            collectionModel = new CollectionModel(
                    collection.getName(),
                    collection.getProductsCount(),
                    collection.getImg());
        }

        return collectionModel;
    }

    public List<CollectionModel> transformList(List<CollectionRest> collections) {
        List<CollectionModel> collectionModels = new ArrayList<>();

        for (CollectionRest collectionRest : collections) {
            if (collectionRest != null) {
                collectionModels.add(transform(collectionRest));
            }
        }

        return collectionModels;
    }
}
