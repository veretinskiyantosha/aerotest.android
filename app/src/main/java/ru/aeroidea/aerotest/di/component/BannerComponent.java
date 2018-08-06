package ru.aeroidea.aerotest.di.component;

import dagger.Subcomponent;
import ru.aeroidea.aerotest.di.module.BannerModule;
import ru.aeroidea.aerotest.presentation.home.banner.BannerFragment;

@Subcomponent(modules = {BannerModule.class})
public interface BannerComponent {

    void injectBannerFragment(BannerFragment fragment);
}
