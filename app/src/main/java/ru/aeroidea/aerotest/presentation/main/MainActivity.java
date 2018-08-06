package ru.aeroidea.aerotest.presentation.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.aartikov.alligator.Screen;
import me.aartikov.alligator.annotations.RegisterScreen;
import ru.aeroidea.aerotest.App;
import ru.aeroidea.aerotest.R;
import ru.aeroidea.aerotest.presentation.base.BaseActivity;
import ru.aeroidea.aerotest.presentation.screens.DetailScreen;
import ru.aeroidea.aerotest.presentation.screens.HomeScreen;
import ru.aeroidea.aerotest.presentation.screens.MainScreen;
import ru.aeroidea.aerotest.presentation.screens.TabScreen;

@RegisterScreen(MainScreen.class)
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView mNavigationView;

    private Map<Integer, Screen> mTabScreenMap = new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        initTabScreens();

        mNavigationView.setOnNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            App.getComponent().getNavigator().switchTo(getTabScreen(R.id.action_home));
        }
    }

    private void initTabScreens() {
        mTabScreenMap.put(R.id.action_home, new TabScreen(new HomeScreen(getString(R.string.home))));
        mTabScreenMap.put(R.id.action_catalog, new TabScreen(new DetailScreen(getString(R.string.catalog))));
        mTabScreenMap.put(R.id.action_sales, new TabScreen(new DetailScreen(getString(R.string.sales))));
        mTabScreenMap.put(R.id.action_profile, new TabScreen(new DetailScreen(getString(R.string.profile))));
        mTabScreenMap.put(R.id.action_basket, new TabScreen(new DetailScreen(getString(R.string.basket))));
    }

    private Screen getTabScreen(int tabId) {
        return mTabScreenMap.get(tabId);
    }

    private int getTabId(Screen tabScreen) {
        for (Map.Entry<Integer, Screen> entry : mTabScreenMap.entrySet()) {
            if (tabScreen.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        App.getComponent().getNavigator().switchTo(getTabScreen(menuItem.getItemId()));

        return false;
    }

    @Override
    public void onScreenSwitched(@Nullable Screen screenFrom, Screen screenTo) {
        super.onScreenSwitched(screenFrom, screenTo);

        mNavigationView.getMenu().findItem(getTabId(screenTo)).setChecked(true);
    }
}
