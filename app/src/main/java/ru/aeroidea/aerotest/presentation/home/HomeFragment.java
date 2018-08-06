package ru.aeroidea.aerotest.presentation.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.aartikov.alligator.annotations.RegisterScreen;
import ru.aeroidea.aerotest.App;
import ru.aeroidea.aerotest.R;
import ru.aeroidea.aerotest.data.source.remote.rest.Banner;
import ru.aeroidea.aerotest.data.source.remote.rest.Collection;
import ru.aeroidea.aerotest.data.source.remote.rest.Content;
import ru.aeroidea.aerotest.presentation.home.banner.BannerFragment;
import ru.aeroidea.aerotest.presentation.screens.HomeScreen;

@RegisterScreen(HomeScreen.class)
public class HomeFragment extends Fragment implements HomeContract.View {
    private static final String TAG = HomeFragment.class.getName();

    @Inject
    HomeContract.Presenter mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.banners_view_pager)
    ViewPager mBannersViewPager;
    @BindView(R.id.collections_recycler_view)
    RecyclerView mCollectionsRecyclerView;
    @BindView(R.id.progress)
    ProgressBar mProgress;

    private Unbinder mUnbinder;
    private CollectionAdapter mCollectionAdapter;
    private BannerAdapter mBannerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getComponent().createHomeComponent().injectHomeFragment(this);

        mCollectionAdapter = new CollectionAdapter(new ArrayList<>(0), mPresenter::showDetail);
        mBannerAdapter = new BannerAdapter(getChildFragmentManager(), new ArrayList<>(0));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mUnbinder = ButterKnife.bind(this, view);

        HomeScreen homeScreen = App.getComponent().getScreenResolver().getScreen(this);
        mToolbar.setTitle(homeScreen.getTitle());

        mBannersViewPager.setAdapter(mBannerAdapter);

        mCollectionsRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mCollectionsRecyclerView.setAdapter(mCollectionAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.bind(this);
        mPresenter.loadContent();
    }

    @Override
    public void onDestroy() {
        mPresenter.unbind();
        mUnbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            mProgress.setVisibility(View.VISIBLE);
        } else {
            mProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void showContent(Content content) {
        mBannerAdapter.setBanners(content.getBanners());
        mCollectionAdapter.setCollections(content.getCollections());
    }

    private static class BannerAdapter extends FragmentStatePagerAdapter {
        private List<Banner> mBanners;

        public BannerAdapter(FragmentManager fm, List<Banner> banners) {
            super(fm);
            mBanners = banners;
        }

        @Override
        public Fragment getItem(int i) {
            Banner banner = mBanners.get(i);
            return BannerFragment.newInstance(banner.getTitle(), banner.getMobilePicture());
        }

        @Override
        public int getCount() {
            return mBanners.size();
        }

        public void setBanners(List<Banner> banners) {
            mBanners = banners;
            notifyDataSetChanged();
        }
    }

    public static class CollectionHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view)
        ImageView mImageView;
        @BindView(R.id.name_text_view)
        TextView mNameTextView;
        @BindView(R.id.products_count_text_view)
        TextView mProductsCountTextView;

        private String mProductsCaption;

        public CollectionHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            if (mProductsCaption == null) {
                mProductsCaption = itemView.getContext().getString(R.string.products);
            }
        }

        public void bindCollection(Collection collection) {
            Picasso.get().load(collection.getImg()).into(mImageView);
            mNameTextView.setText(collection.getName());

            String text = collection.getProductsCount() + " " + mProductsCaption;
            mProductsCountTextView.setText(text);
        }
    }

    public static class CollectionAdapter extends RecyclerView.Adapter<CollectionHolder> {
        private List<Collection> mCollections;
        private ItemListener mItemListener;

        public CollectionAdapter(List<Collection> collections, ItemListener itemListener) {
            mCollections = collections;
            mItemListener = itemListener;
        }

        @NonNull
        @Override
        public CollectionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            View view = layoutInflater.inflate(R.layout.collection_list_item, viewGroup, false);

            return new CollectionHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CollectionHolder collectionHolder, int i) {
            collectionHolder.itemView.setOnClickListener(v -> {
                mItemListener.onItemClick(mCollections.get(i).getName());
            });

            collectionHolder.bindCollection(mCollections.get(i));
        }

        @Override
        public int getItemCount() {
            return mCollections.size();
        }

        public void setCollections(List<Collection> collections) {
            mCollections = collections;
            notifyDataSetChanged();
        }
    }

    public interface ItemListener {
        void onItemClick(String title);
    }
}
