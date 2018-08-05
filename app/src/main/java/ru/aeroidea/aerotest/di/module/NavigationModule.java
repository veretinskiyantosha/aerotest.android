package ru.aeroidea.aerotest.di.module;

import dagger.Module;
import dagger.Provides;
import me.aartikov.alligator.AndroidNavigator;
import me.aartikov.alligator.NavigationContextBinder;
import me.aartikov.alligator.Navigator;
import me.aartikov.alligator.ScreenResolver;
import me.aartikov.alligator.navigationfactories.NavigationFactory;
import ru.aeroidea.aerotest.di.scope.AppScope;

@Module
public class NavigationModule {
    private AndroidNavigator mAndroidNavigator;

    public NavigationModule(AndroidNavigator androidNavigator) {
        mAndroidNavigator = androidNavigator;
    }

    @AppScope
    @Provides
    public NavigationFactory provideNavigationFactory() {
        return mAndroidNavigator.getNavigationFactory();
    }

    @AppScope
    @Provides
    public Navigator provideNavigator() {
        return mAndroidNavigator;
    }

    @AppScope
    @Provides
    public NavigationContextBinder provideNavigationContextBinder() {
        return mAndroidNavigator;
    }

    @AppScope
    @Provides
    public ScreenResolver provideScreenResolver() {
        return mAndroidNavigator.getScreenResolver();
    }
}
