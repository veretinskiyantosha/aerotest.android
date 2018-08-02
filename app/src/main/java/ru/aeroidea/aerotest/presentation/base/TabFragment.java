package ru.aeroidea.aerotest.presentation.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.aartikov.alligator.Screen;
import me.aartikov.alligator.annotations.RegisterScreen;
import ru.aeroidea.aerotest.App;
import ru.aeroidea.aerotest.R;
import ru.aeroidea.aerotest.presentation.screens.TabScreen;

@RegisterScreen(TabScreen.class)
public class TabFragment extends Fragment implements ContainerIdProvider {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabScreen screen = App.getComponent().getScreenResolver().getScreen(this);
        Screen innerScreen = screen.getInnerScreen();

        if (getChildFragmentManager().findFragmentById(R.id.inner_container) == null) {
            App.getComponent().getNavigator().reset(innerScreen);
        }
    }

    @Override
    public int getContainerId() {
        return R.id.inner_container;
    }
}
