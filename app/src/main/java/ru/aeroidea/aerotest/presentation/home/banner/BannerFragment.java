package ru.aeroidea.aerotest.presentation.home.banner;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.aeroidea.aerotest.App;
import ru.aeroidea.aerotest.R;

public class BannerFragment extends Fragment implements BannerContract.View {
    private static final String ARG_TITLE = "title";
    private static final String ARG_BANNER_URL = "banner_url";

    @BindView(R.id.banner_title)
    TextView mTitleTextView;
    @BindView(R.id.banner_image_view)
    ImageView mBannerImageView;

    private Unbinder mUnbinder;

    private String mTitle;
    private String mBannerUrl;

    @Inject
    BannerContract.Presenter mPresenter;

    public static BannerFragment newInstance(String title, String bannerUrl) {
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_BANNER_URL, bannerUrl);

        BannerFragment fragment = new BannerFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getComponent().createBannerComponent().injectBannerFragment(this);

        mTitle = getArguments().getString(ARG_TITLE);
        mBannerUrl = getArguments().getString(ARG_BANNER_URL);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banner, container, false);
        view.setOnClickListener(v -> mPresenter.showDetail(mTitle));

        mUnbinder = ButterKnife.bind(this, view);

        mTitleTextView.setText(mTitle);
        Picasso.get().load(mBannerUrl).into(mBannerImageView);

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
