package ru.aeroidea.aerotest.di.component;

import dagger.Subcomponent;
import ru.aeroidea.aerotest.di.module.HomeModule;
import ru.aeroidea.aerotest.di.scope.HomeScreenScope;
import ru.aeroidea.aerotest.presentation.home.HomeFragment;

@HomeScreenScope
@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {

    void injectHomeFragment(HomeFragment fragment);
}
