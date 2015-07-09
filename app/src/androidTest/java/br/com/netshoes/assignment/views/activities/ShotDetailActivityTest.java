package br.com.netshoes.assignment.views.activities;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.netshoes.assignment.R;
import br.com.netshoes.model.entities.Shot;
import br.com.netshoes.model.responses.ShotDetailApiResponse;

/**
 * Created by douglasritter on 7/9/15.
 */
public class ShotDetailActivityTest extends ActivityInstrumentationTestCase2<ShotDetailActivity> {
    private ShotDetailActivity mShotDetailActivity;

    ImageView mShotImage;
    TextView mShotTitle;
    TextView mShotLikes;
    ImageView mShotDetailAvatar;
    TextView mShotDetailUsername;
    TextView mShotDetailDescription;

    public ShotDetailActivityTest() {
        super(ShotDetailActivity.class);
    }

    @Override public void setUp() throws Exception {
        super.setUp();
        mShotDetailActivity = getActivity();

        mShotImage = (ImageView) mShotDetailActivity.findViewById(R.id.shotItemImage);
        mShotTitle = (TextView) mShotDetailActivity.findViewById(R.id.shotTitle);
        mShotLikes = (TextView) mShotDetailActivity.findViewById(R.id.shotLikes);
        mShotDetailAvatar = (ImageView) mShotDetailActivity.findViewById(R.id.shotDetailAvatar);
        mShotDetailUsername = (TextView) mShotDetailActivity.findViewById(R.id.shotDetailUsername);
        mShotDetailDescription = (TextView) mShotDetailActivity.findViewById(R.id.shotDetailDescription);

    }

    @Override public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testOnStop() throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                mShotDetailActivity.onStop();
            }
        });
    }

    public void testShowShotDetail() throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                ShotDetailApiResponse shotDetailApiResponse = new ShotDetailApiResponse();
                shotDetailApiResponse.setShotDetail(new Shot());
                mShotDetailActivity.showShotDetail(shotDetailApiResponse);
            }
        });
    }

    public void testShowLoading() throws Exception {
        mShotDetailActivity.showLoading();
    }

    public void testHideLoading() throws Exception {
        mShotDetailActivity.hideLoading();
    }

    public void testShowError() throws Exception {
        String dummyError = "This is an error";
        mShotDetailActivity.showError(dummyError);
    }

    public void testHideError() throws Exception {
        mShotDetailActivity.hideError();
    }

    public void testGetContext() throws Exception {
        assertNotNull(mShotDetailActivity.getContext());
    }

    public void testOnBackPressed() throws Exception {
        mShotDetailActivity.onBackPressed();
    }

    public void testFinish() throws Exception {
        mShotDetailActivity.finish();
    }

}