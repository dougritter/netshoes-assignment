package br.com.netshoes.assignment.views.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.netshoes.assignment.R;
import br.com.netshoes.assignment.mvp.presenters.ShotDetailPresenter;
import br.com.netshoes.assignment.mvp.views.ShotDetailView;
import br.com.netshoes.common.utils.BusProvider;
import br.com.netshoes.common.utils.Constants;
import br.com.netshoes.model.entities.Shot;
import br.com.netshoes.model.responses.ShotDetailApiResponse;
import butterknife.ButterKnife;
import butterknife.InjectView;
import pl.tajchert.sample.DotsTextView;

public class ShotDetailActivity extends AppCompatActivity implements ShotDetailView{
    // Constants
    public static final String LOG_TAG = ShotDetailActivity.class.getSimpleName();

    // Java
    private ShotDetailPresenter mShotDetailPresenter;
    private int mId = 1757954;

    // UI Objects
    @InjectView(R.id.shotItemImage) ImageView mShotImage;
    @InjectView(R.id.shotTitle) TextView mShotTitle;
    @InjectView(R.id.shotLikes) TextView mShotLikes;
    @InjectView(R.id.shotDetailAvatar) ImageView mShotDetailAvatar;
    @InjectView(R.id.shotDetailUsername) TextView mShotDetailUsername;
    @InjectView(R.id.shotDetailDescription) TextView mShotDetailDescription;
    @InjectView(R.id.dots) DotsTextView mDots;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shot_detail);
        ButterKnife.inject(this);

        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mId = extras.getInt(Constants.SHOT_DETAIL_EXTRA_ID);
        }

        mShotDetailPresenter = new ShotDetailPresenter(this, mId);
        BusProvider.getUIBusInstance().register(this);

    }

    @Override protected void onStart() {
        super.onStart();
        getData();
        showLoading();
    }

    public void getData(){
        mShotDetailPresenter.start();

    }

    @Override protected void onStop() {
        super.onStop();
        mShotDetailPresenter.stop();
    }

    @Override public void showShotDetail(ShotDetailApiResponse shotDetailApiResponse) {
        Log.d(LOG_TAG, "shotDetail: " + shotDetailApiResponse.getShotDetail());

        Shot shot = shotDetailApiResponse.getShotDetail();

        if(shot != null){
            if(shot.getImageUrl() != null){
                Picasso.with(this)
                        .load(shot.getImageUrl())
                        .placeholder(R.drawable.placeholder_image)
                        .into(mShotImage);
            }

            mShotTitle.setText(shot.getTitle() != null ? shot.getTitle() : "");
            mShotLikes.setText(shot.getLikesCount() >= 0 ? Integer.toString(shot.getLikesCount()) : "0");

            if(shot.getPlayer() != null){
                if(shot.getPlayer().getAvatarUrl() != null){
                    Picasso.with(this)
                            .load(shot.getPlayer().getAvatarUrl())
                            .placeholder(R.drawable.placeholder_image)
                            .into(mShotDetailAvatar);
                }
                mShotDetailUsername.setText(shot.getPlayer().getUsername() != null ? shot.getPlayer().getUsername() : "");
            }

            mShotDetailDescription.setText(shot.getDescription() != null ? Html.fromHtml(shot.getDescription()) : "");

        }

    }

    @Override public void showLoading() {
        Log.d(LOG_TAG, "showLoading");
        mDots.showAndPlay();
        mDots.setVisibility(View.VISIBLE);
    }

    @Override public void hideLoading() {
        Log.d(LOG_TAG, "hideLoading");
        mDots.hideAndStop();
        mDots.setVisibility(View.GONE);
    }

    @Override public void showError(String error) {
        Log.e(LOG_TAG, "Error: "+ error);
    }

    @Override public void hideError() {

    }

    @Override public Context getContext() {
        return this;
    }

    @Override public void onBackPressed() {
        finish();
    }

    @Override public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_from_internal, R.anim.slide_out_from_internal);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
