package br.com.netshoes.assignment.mvp.presenters;

import android.util.Log;

import com.squareup.otto.Subscribe;

import br.com.netshoes.assignment.mvp.views.ShotsView;
import br.com.netshoes.common.utils.BusProvider;
import br.com.netshoes.domain.GetShotsUseCaseController;
import br.com.netshoes.domain.UseCase;
import br.com.netshoes.model.responses.ShotsApiResponse;
import br.com.netshoes.model.rest.AppUrls;
import br.com.netshoes.model.rest.RestSource;
import retrofit.RetrofitError;

/**
 * Created by douglas on 7/6/15.
 */
public class ShotsPresenter extends Presenter {
    public static final String LOG_TAG = ShotsPresenter.class.getSimpleName();
    private final ShotsView mShotsView;
    private int mPageNumber;
    private boolean mIsLoading;
    private boolean mRegistered;

    public ShotsPresenter(ShotsView shotsView, int pageNumber) {
        mShotsView = shotsView;
        mPageNumber = pageNumber;
        mIsLoading = false;
        mRegistered = false;
    }

    @Subscribe public void onShotsReceived(ShotsApiResponse response) {
        mShotsView.showShots(response);
        mIsLoading = false;
        mShotsView.hideLoading();
        stop();
    }

    @Subscribe public void onError(RetrofitError error) {
        mShotsView.showError(error.getMessage());
    }

    @Override public void start() {
        try {
            mIsLoading = true;
            mShotsView.showLoading(mPageNumber > 1 ? true : false);
            BusProvider.getUIBusInstance().register(this);
            mRegistered = true;
            UseCase getShots = new GetShotsUseCaseController(RestSource.getInstance(AppUrls.DEFAULT_NAMESPACE), BusProvider.getUIBusInstance(), mPageNumber);
            getShots.execute();
        } catch (IllegalArgumentException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            mIsLoading = false;
        }
    }

    public void refresh() {
        UseCase getShots = new GetShotsUseCaseController(RestSource.getInstance(AppUrls.DEFAULT_NAMESPACE), BusProvider.getUIBusInstance(), mPageNumber);
        getShots.execute();
    }

    @Override public void stop() {
        try {
            mIsLoading = false;
            if(mRegistered){
                BusProvider.getUIBusInstance().unregister(this);
                mRegistered = false;
            }
        } catch (IllegalArgumentException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
    }

    public void getOlderPosts(int page) {
        if(!mIsLoading){
            mPageNumber = page;
            start();
            Log.e(LOG_TAG, "getOlderPosts - page: "+page);
        }
    }


}
