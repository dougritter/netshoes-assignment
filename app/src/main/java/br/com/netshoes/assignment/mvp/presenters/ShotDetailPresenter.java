package br.com.netshoes.assignment.mvp.presenters;

import android.util.Log;

import com.squareup.otto.Subscribe;

import br.com.netshoes.assignment.mvp.views.ShotDetailView;
import br.com.netshoes.assignment.mvp.views.ShotsView;
import br.com.netshoes.common.utils.BusProvider;
import br.com.netshoes.domain.GetShotDetailUseCaseController;
import br.com.netshoes.domain.GetShotsUseCaseController;
import br.com.netshoes.domain.UseCase;
import br.com.netshoes.model.responses.ShotDetailApiResponse;
import br.com.netshoes.model.responses.ShotsApiResponse;
import br.com.netshoes.model.rest.AppUrls;
import br.com.netshoes.model.rest.RestSource;
import retrofit.RetrofitError;

/**
 * Created by douglas on 7/7/15.
 */
public class ShotDetailPresenter extends Presenter {
    public static final String LOG_TAG = ShotDetailPresenter.class.getSimpleName();
    private final ShotDetailView mShotDetailView;
    private int mId;

    public ShotDetailPresenter(ShotDetailView shotsView, int id) {
        mShotDetailView = shotsView;
        mId = id;
    }

    @Subscribe public void onShotsReceived(ShotDetailApiResponse response) {
        mShotDetailView.showShotDetail(response);
    }

    @Subscribe public void onError(RetrofitError error) {
        mShotDetailView.showError(error.getMessage());
    }

    @Override public void start() {
        try {
            BusProvider.getUIBusInstance().register(this);
            UseCase getShotDetail = new GetShotDetailUseCaseController(RestSource.getInstance(AppUrls.DEFAULT_NAMESPACE), BusProvider.getUIBusInstance(), mId);
            getShotDetail.execute();
        } catch (IllegalArgumentException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
    }

    public void refresh() {
        UseCase getShotDetail = new GetShotDetailUseCaseController(RestSource.getInstance(AppUrls.DEFAULT_NAMESPACE), BusProvider.getUIBusInstance(), mId);
        getShotDetail.execute();
    }

    @Override public void stop() {
        try {
            BusProvider.getUIBusInstance().unregister(this);
        } catch (IllegalArgumentException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
    }


}
