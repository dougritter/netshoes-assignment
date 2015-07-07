package br.com.netshoes.assignment.views.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import br.com.netshoes.assignment.R;
import br.com.netshoes.assignment.mvp.presenters.ShotsPresenter;
import br.com.netshoes.assignment.mvp.views.ShotsView;
import br.com.netshoes.common.utils.BusProvider;
import br.com.netshoes.model.entities.ShotsResponse;
import br.com.netshoes.model.responses.ShotsApiResponse;


public class ShotsListActivity extends AppCompatActivity implements ShotsView{

    // Constants
    public static final String LOG_TAG = ShotsListActivity.class.getSimpleName();

    // Java Objects
    private ShotsPresenter mShotsPresenter;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShotsPresenter = new ShotsPresenter(this, 1);
        BusProvider.getUIBusInstance().register(this);

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
