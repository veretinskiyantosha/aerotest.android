package ru.aeroidea.aerotest.domain.repository;

import io.reactivex.Observable;
import ru.aeroidea.aerotest.data.source.remote.rest.Content;

public interface ContentRepository {

    Observable<Content> getMainContent();
}
