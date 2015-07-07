package br.com.netshoes.assignment.views.custom_views.view_holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.netshoes.assignment.R;
import br.com.netshoes.model.entities.Shot;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by douglas on 7/7/15.
 */
public class ShotItemViewHolder extends RecyclerView.ViewHolder {
    // Java
    Shot mShot;
    Context mContext;

    // UI Objects
    @InjectView(R.id.shotItemImage) ImageView vShotImage;

    public ShotItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);

    }

    public void showData(Shot shot, Context context){
        mShot = shot;
        mContext = context;

        if(mShot.getImageUrl() != null){
            Picasso.with(mContext)
                    .load(mShot.getImageUrl())
                    .into(vShotImage);
        }

    }

}
