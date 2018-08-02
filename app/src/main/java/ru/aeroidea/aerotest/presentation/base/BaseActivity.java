package ru.aeroidea.aerotest.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import me.aartikov.alligator.NavigationContext;
import me.aartikov.alligator.Screen;
import me.aartikov.alligator.listeners.ScreenSwitchingListener;
import me.aartikov.alligator.screenswitchers.FragmentScreenSwitcher;
import ru.aeroidea.aerotest.App;
import ru.aeroidea.aerotest.R;

public abstract class BaseActivity extends AppCompatActivity implements ScreenSwitchingListener {
    private FragmentScreenSwitcher mScreenSwitcher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mScreenSwitcher = new FragmentScreenSwitcher(
                App.getComponent().getNavigationFactory(),
                getSupportFragmentManager(),
                R.id.fragment_container
        );
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        bindNavigationContext();
    }

    private void bindNavigationContext() {
        NavigationContext.Builder builder = new NavigationContext.Builder(this)
                .screenSwitcher(mScreenSwitcher)
                .screenSwitchingListener(this);

        Fragment fragment = mScreenSwitcher.getCurrentFragment();
        if (fragment != null) {
            if (fragment instanceof ContainerIdProvider) {
                builder.containerId(((ContainerIdProvider) fragment).getContainerId())
                        .fragmentManager(fragment.getChildFragmentManager());
            }
        } else {
            builder.containerId(R.id.fragment_container);
        }

        App.getComponent().getNavigationContextBinder().bind(builder.build());
    }

    @Override
    public void onScreenSwitched(@Nullable Screen screenFrom, Screen screenTo) {
        bindNavigationContext();
    }

    @Override
    protected void onPause() {
        App.getComponent().getNavigationContextBinder().unbind();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        App.getComponent().getNavigator().goBack();
    }
}
