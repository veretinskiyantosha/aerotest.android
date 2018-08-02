package ru.aeroidea.aerotest.di.module;

import dagger.Module;
import dagger.Provides;
import me.aartikov.alligator.AndroidNavigator;
import me.aartikov.alligator.NavigationContextBinder;
import me.aartikov.alligator.Navigator;
import me.aartikov.alligator.ScreenResolver;
import me.aartikov.alligator.navigationfactories.NavigationFactory;

@Module
public class NavigationModule {
    private AndroidNavigator mAndroidNavigator;

    public NavigationModule(AndroidNavigator androidNavigator) {
        mAndroidNavigator = androidNavigator;
    }

    @Provides
    public NavigationFactory provideNavigationFactory() {
        return mAndroidNavigator.getNavigationFactory();
    }

    @Provides
    public Navigator provideNavigator() {
        return mAndroidNavigator;
    }

    @Provides
    public NavigationContextBinder provideNavigationContextBinder() {
        return mAndroidNavigator;
    }

    @Provides
    public ScreenResolver provideScreenResolver() {
        return mAndroidNavigator.getScreenResolver();
    }
}
