package ru.aeroidea.aerotest.di.module;

import android.support.annotation.Nullable;

import com.google.gson.GsonBuilder;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.aeroidea.aerotest.BuildConfig;
import ru.aeroidea.aerotest.data.source.remote.ApiService;
import ru.aeroidea.aerotest.di.scope.AppScope;

@Module
public class ApiModule {

    @AppScope
    @Provides
    public OkHttpClient.Builder provideHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.authenticator(new Authenticator() {
            @Nullable
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                String credential = Credentials.basic("loginarea", "passarea");
                return response.request().newBuilder().header("Authorization", credential).build();
            }
        });

        return httpClient;
    }

    @AppScope
    @Provides
    public GsonBuilder provideGsonBuilder() {
        return new GsonBuilder()
                .setLenient()
                .serializeNulls();
    }

    @AppScope
    @Provides
    public ApiService provideService(OkHttpClient.Builder httpClient, GsonBuilder gsonBuilder) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(httpClient.build())
                .build();

        return retrofit.create(ApiService.class);
    }
}
