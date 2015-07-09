package br.com.netshoes.assignment.views.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

import br.com.netshoes.assignment.R;
import br.com.netshoes.model.entities.ShotsResponse;
import br.com.netshoes.model.responses.ShotsApiResponse;

/**
 * Created by douglasritter on 7/8/15.
 */
public class ShotsListActivityTest extends ActivityInstrumentationTestCase2<ShotsListActivity> {

    private ShotsListActivity mShotsListActivity;
    private RecyclerView mRecyclerView;

    public ShotsListActivityTest() {
        super(ShotsListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mShotsListActivity = getActivity();
        mRecyclerView = (RecyclerView) mShotsListActivity
                        .findViewById(R.id.shotsList);
    }

    public void testRecyclerViewNotNull() throws Exception {
        assertNotNull(mRecyclerView);
    }

    public void testOnStart() throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                mShotsListActivity.onStart();
            }
        });
    }

    public void testGetData() throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                mShotsListActivity.getData();
            }
        });
    }

    public void testShowShots() throws Exception {
        ShotsApiResponse shotsApiResponse = new ShotsApiResponse();
        shotsApiResponse.setShots(new ShotsResponse());
        mShotsListActivity.showShots(shotsApiResponse);
    }

    public void testShowError() throws Exception {
        String dummyError = "This is an error";
        mShotsListActivity.showError(dummyError);
    }

    @UiThreadTest
    public void testContextNotNull() throws Exception {
        Context context = mShotsListActivity.getContext();
        assertNotNull(context);
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testShowLoading() throws Exception {
        mShotsListActivity.showLoading(false);
    }

    public void testHideLoading() throws Exception {
        mShotsListActivity.hideLoading();
    }

    public void testHideError() throws Exception {
        mShotsListActivity.hideError();
    }

}
