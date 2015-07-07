package br.com.netshoes.assignment.views.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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


public class ShotsListActivity extends AppCompatActivity implements ShotsView{

    // Constants
    public static final String LOG_TAG = ShotsListActivity.class.getSimpleName();

    // Java Objects
    private ShotsPresenter mShotsPresenter;
    private ShotsAdapter mShotsAdapter;
    private LinearLayoutManager mLayoutManager;
    private int countPages = 1;

    //UI Objects
    @InjectView(R.id.shotsList) protected RecyclerView mShotsList;

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

    }

    @Override protected void onStart() {
        super.onStart();
        getData();
    }

    public void getData(){
        mShotsPresenter.start();

    }

    @Override protected void onStop() {
        super.onStop();
        mShotsPresenter.stop();
    }

    @Override public void showShots(ShotsApiResponse shotsResponse) {
        Log.e(LOG_TAG, "shots list: "+ shotsResponse.getShots());
        mShotsAdapter.refreshShots(shotsResponse.getShots().getShotList());
    }

    @Override public void showLoading() {

    }

    @Override public void hideLoading() {

    }

    @Override public void showError(String error) {
        Log.e(LOG_TAG, "Error: "+ error);
    }

    @Override public void hideError() {

    }

    @Override public Context getContext() {
        return this;
    }
}
