package ru.aeroidea.aerotest;

import android.app.Application;

import me.aartikov.alligator.AndroidNavigator;
import me.aartikov.alligator.navigationfactories.GeneratedNavigationFactory;
import ru.aeroidea.aerotest.di.component.AppComponent;
import ru.aeroidea.aerotest.di.component.DaggerAppComponent;
import ru.aeroidea.aerotest.di.module.AppModule;
import ru.aeroidea.aerotest.di.module.NavigationModule;

public class App extends Application {
    private static AppComponent sComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .navigationModule(new NavigationModule(new AndroidNavigator(new GeneratedNavigationFactory())))
                .build();
    }

    public static AppComponent getComponent() {
        return sComponent;
    }
}
