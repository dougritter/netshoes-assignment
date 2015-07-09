package br.com.netshoes.assignment.views.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import br.com.netshoes.assignment.R;
import br.com.netshoes.assignment.mvp.presenters.ShotsPresenter;
import br.com.netshoes.assignment.mvp.views.ShotsView;
import br.com.netshoes.assignment.views.adapters.ShotsAdapter;
import br.com.netshoes.common.utils.BusProvider;
import br.com.netshoes.model.entities.ShotsResponse;
import br.com.netshoes.model.responses.ShotsApiResponse;
import butterknife.ButterKnife;
import butterknife.InjectView;
import pl.tajchert.sample.DotsTextView;


public class ShotsListActivity extends AppCompatActivity implements ShotsView{

    // Constants
    public static final String LOG_TAG = ShotsListActivity.class.getSimpleName();

    // Java Objects
    private ShotsPresenter mShotsPresenter;
    private ShotsAdapter mShotsAdapter;
    private LinearLayoutManager mLayoutManager;
    private int countPages = 1;
    private int maxPages = 0;

    //UI Objects
    @InjectView(R.id.shotsList) protected RecyclerView mShotsList;
    @InjectView(R.id.dots) protected DotsTextView mDots;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mShotsPresenter = new ShotsPresenter(this, countPages);
        BusProvider.getUIBusInstance().register(this);

        // Populate RecyclerView
        mShotsAdapter = new ShotsAdapter(this);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mShotsList.setLayoutManager(mLayoutManager);
        mShotsList.setAdapter(mShotsAdapter);
        mShotsList.setOnScrollListener(mLiveHubScrollListener);

    }

    @Override protected void onStart() {
        super.onStart();
        getData();
    }

    public void getData(){
        mShotsPresenter.start();
        showLoading(mShotsAdapter != null && mShotsAdapter.getItemCount() > 0 ? true : false);
    }

    @Override protected void onStop() {
        super.onStop();
        mShotsPresenter.stop();
    }

    @Override public void showShots(ShotsApiResponse shotsResponse) {
        if(shotsResponse != null && shotsResponse.getShots() != null
                && shotsResponse.getShots().getShotList() != null){
            mShotsAdapter.appendShotItems(shotsResponse.getShots().getShotList());
            Log.d(LOG_TAG, "appendShotItems of page: "+shotsResponse.getShots().getPage());
            if(maxPages == 0){
                maxPages = shotsResponse.getShots().getPages();
            }
            countPages++;
        }
    }

    @Override public void showLoading(boolean alreadyHasItems) {
        Log.d(LOG_TAG, "showLoading");
        mDots.showAndPlay();
        mDots.setTextColor(alreadyHasItems ? getResources().getColor(android.R.color.white) : getResources().getColor(R.color.primary));
        mDots.setVisibility(View.VISIBLE);
    }

    @Override public void hideLoading() {
        Log.d(LOG_TAG, "hideLoading");
        mDots.hideAndStop();
        mDots.setVisibility(View.GONE);
    }

    @Override public void showError(String error) {
        Log.e(LOG_TAG, "Error: " + error);
    }

    @Override public void hideError() {

    }

    @Override public Context getContext() {
        return this;
    }

    private RecyclerView.OnScrollListener mLiveHubScrollListener = new RecyclerView.OnScrollListener() {
        private int scrollAmount = 0;

        @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            scrollAmount = scrollAmount + dy;
            loadMoreOnReachBottom();
        }
    };

    private void loadMoreOnReachBottom() {
        int pastVisibleItems, visibleItemCount, totalItemCount;

        visibleItemCount = mLayoutManager.getChildCount();
        totalItemCount = mLayoutManager.getItemCount();
        pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();

        if (((visibleItemCount + pastVisibleItems) >= totalItemCount) && (countPages) <= maxPages) {
            mShotsPresenter.getOlderPosts(countPages);
        }

    }
}
