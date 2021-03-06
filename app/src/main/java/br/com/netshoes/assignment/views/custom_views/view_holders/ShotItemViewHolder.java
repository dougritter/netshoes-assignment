package br.com.netshoes.assignment.views.custom_views.view_holders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import br.com.netshoes.assignment.R;
import br.com.netshoes.assignment.views.activities.ShotDetailActivity;
import br.com.netshoes.common.utils.Constants;
import br.com.netshoes.model.entities.Shot;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by douglas on 7/7/15.
 */
public class ShotItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    // Java
    Shot mShot;
    Context mContext;

    // UI Objects
    @InjectView(R.id.shotItemImage) ImageView vShotImage;
    @InjectView(R.id.shotTitle) TextView vShotTitle;
    @InjectView(R.id.shotLikes) TextView vShotLikes;
    @InjectView(R.id.sharesContainer) LinearLayout vSharesContainer;

    public ShotItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void showData(Shot shot, Context context){
        mShot = shot;
        mContext = context;

        if(mShot.getImageUrl() != null){
            Picasso.with(mContext)
                    .load(mShot.getImageUrl())
                    .placeholder(R.drawable.placeholder_image)
                    .into(vShotImage, new Callback() {
                        @Override
                        public void onSuccess() {
                            vSharesContainer.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onError() {}
                    });
        }

        if(shot.getTitle() != null){
            vShotTitle.setText(shot.getTitle());
        }
        vShotLikes.setText(Integer.toString(shot.getLikesCount()));

    }

    @Override
    public void onClick(View v) {

        Activity activity = (Activity) mContext;

        Intent intent = new Intent(activity, ShotDetailActivity.class);
        intent.putExtra(Constants.SHOT_DETAIL_EXTRA_ID, mShot.getId());
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_from_main, R.anim.slide_out_from_main);
    }
}
