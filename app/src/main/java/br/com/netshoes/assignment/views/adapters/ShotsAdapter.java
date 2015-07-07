package br.com.netshoes.assignment.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.netshoes.assignment.R;
import br.com.netshoes.assignment.views.custom_views.view_holders.ShotItemViewHolder;
import br.com.netshoes.model.entities.Shot;

/**
 * Created by douglas on 7/7/15.
 */
public class ShotsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Shot> mShotsList;
    private Context mContext;

    public ShotsAdapter(Context context) {
        mShotsList = new ArrayList<>();
        mContext = context;
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shot_item_layout, parent, false);
        return new ShotItemViewHolder(itemView);

    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (position < mShotsList.size()) {
            Shot shot = mShotsList.get(position);
            ShotItemViewHolder holder = (ShotItemViewHolder) viewHolder;
            holder.showData(shot, mContext);

        }
    }

    @Override public int getItemCount() {
        return mShotsList.size();
    }

    public void refreshShots(List<Shot> shots) {
        mShotsList = (ArrayList<Shot>) shots;
        notifyDataSetChanged();
    }
}
