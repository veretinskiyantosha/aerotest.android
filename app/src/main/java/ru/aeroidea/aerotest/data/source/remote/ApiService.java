package ru.aeroidea.aerotest.data.source.remote;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import ru.aeroidea.aerotest.data.source.remote.rest.ContentRest;

public interface ApiService {

    @FormUrlEncoded
    @POST("/api/content/main")
    Observable<ContentRest> getMainContent(@Field("countryCode") String countryCode);
}
