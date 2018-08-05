package ru.aeroidea.aerotest.di.component;

import dagger.Component;
import me.aartikov.alligator.NavigationContextBinder;
import me.aartikov.alligator.Navigator;
import me.aartikov.alligator.ScreenResolver;
import me.aartikov.alligator.navigationfactories.NavigationFactory;
import ru.aeroidea.aerotest.di.module.ApiModule;
import ru.aeroidea.aerotest.di.module.AppModule;
import ru.aeroidea.aerotest.di.module.NavigationModule;
import ru.aeroidea.aerotest.di.scope.AppScope;

@AppScope
@Component(modules = {AppModule.class, NavigationModule.class, ApiModule.class})
public interface AppComponent {
    NavigationFactory getNavigationFactory();

    Navigator getNavigator();

    NavigationContextBinder getNavigationContextBinder();

    ScreenResolver getScreenResolver();

    HomeComponent createHomeComponent();
}
