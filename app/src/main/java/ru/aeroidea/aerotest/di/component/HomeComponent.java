package ru.aeroidea.aerotest.di.component;

import dagger.Subcomponent;
import ru.aeroidea.aerotest.di.module.HomeModule;
import ru.aeroidea.aerotest.presentation.home.HomeFragment;

@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {

    void injectHomeFragment(HomeFragment fragment);
}
