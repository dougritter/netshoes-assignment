package br.com.netshoes.assignment.views.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.netshoes.assignment.R;
import br.com.netshoes.assignment.mvp.presenters.ShotDetailPresenter;
import br.com.netshoes.assignment.mvp.views.ShotDetailView;
import br.com.netshoes.common.utils.BusProvider;
import br.com.netshoes.common.utils.Constants;
import br.com.netshoes.model.entities.Shot;
import br.com.netshoes.model.responses.ShotDetailApiResponse;
import butterknife.ButterKnife;
import butterknife.InjectView;

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
    }

    public void getData(){
        mShotDetailPresenter.start();

    }

    @Override protected void onStop() {
        super.onStop();
        mShotDetailPresenter.stop();
    }

    @Override public void showShotDetail(ShotDetailApiResponse shotDetailApiResponse) {
        Log.e(LOG_TAG, "shotDetail: "+shotDetailApiResponse.getShotDetail());

        Shot shot = shotDetailApiResponse.getShotDetail();

        Picasso.with(this)
                .load(shot.getImageUrl())
                .placeholder(R.drawable.placeholder_image)
                .into(mShotImage);

        mShotTitle.setText(shot.getTitle());
        mShotLikes.setText(Integer.toString(shot.getLikesCount()));

        Picasso.with(this)
                .load(shot.getPlayer().getAvatarUrl())
                .placeholder(R.drawable.placeholder_image)
                .into(mShotDetailAvatar);

        mShotDetailUsername.setText(shot.getPlayer().getUsername());
        mShotDetailDescription.setText(Html.fromHtml(shot.getDescription()));

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
