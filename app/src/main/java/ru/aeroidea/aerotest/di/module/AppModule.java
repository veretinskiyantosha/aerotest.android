package ru.aeroidea.aerotest.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ru.aeroidea.aerotest.di.scope.AppScope;

@Module
public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @AppScope
    @Provides
    Context provideContext() {
        return mContext;
    }
}
