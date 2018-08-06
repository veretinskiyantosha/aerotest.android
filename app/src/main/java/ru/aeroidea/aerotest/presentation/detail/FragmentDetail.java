package ru.aeroidea.aerotest.presentation.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.aartikov.alligator.annotations.RegisterScreen;
import ru.aeroidea.aerotest.App;
import ru.aeroidea.aerotest.R;
import ru.aeroidea.aerotest.presentation.screens.DetailScreen;

@RegisterScreen(DetailScreen.class)
public class FragmentDetail extends Fragment {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        mUnbinder = ButterKnife.bind(this, view);

        DetailScreen detailScreen = App.getComponent().getScreenResolver().getScreen(this);
        mToolbar.setTitle(detailScreen.getTitle());

        return view;
    }

    @Override
    public void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }
}
