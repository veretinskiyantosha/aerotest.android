package ru.aeroidea.aerotest.presentation.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.aartikov.alligator.annotations.RegisterScreen;
import ru.aeroidea.aerotest.App;
import ru.aeroidea.aerotest.R;
import ru.aeroidea.aerotest.presentation.screens.HomeScreen;

@RegisterScreen(HomeScreen.class)
public class HomeFragment extends Fragment implements HomeContract.View {
    @Inject
    HomeContract.Presenter mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().createHomeComponent().injectHomeFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mUnbinder = ButterKnife.bind(this, view);

        HomeScreen homeScreen = App.getComponent().getScreenResolver().getScreen(this);
        mToolbar.setTitle(homeScreen.getTitle());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.bind(this);
    }

    @Override
    public void onDestroy() {
        mPresenter.unbind();
        mUnbinder.unbind();
        super.onDestroy();
    }
}
