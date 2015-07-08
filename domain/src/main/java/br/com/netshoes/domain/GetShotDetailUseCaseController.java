package br.com.netshoes.domain;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import br.com.netshoes.common.utils.BusProvider;
import br.com.netshoes.model.DataSource;
import br.com.netshoes.model.responses.ShotDetailApiResponse;

/**
 * Created by douglas on 7/7/15.
 */
public class GetShotDetailUseCaseController implements GetShotDetailUseCase {
    private final DataSource mDataSource;
    private final Bus mUiBus;

    private int mId;
    private ShotDetailApiResponse mShotDetailApiResponse;

    public GetShotDetailUseCaseController(DataSource dataSource, Bus uiBus, int id) {
        if (dataSource == null || uiBus == null)
            throw new IllegalArgumentException("DataSource and Bus cannot be null");

        mDataSource = dataSource;
        mUiBus = uiBus;
        mId = id;

        BusProvider.getRestBusInstance().register(this);

    }

    @Override public void getShotDetail(int id) {
        mDataSource.getShotDetail(id);
    }

    @Subscribe
    @Override public void onShotDetailReceived(ShotDetailApiResponse response) {
        mShotDetailApiResponse = response;
        sendToPresenter();
    }

    @Override public void sendToPresenter() {
        mUiBus.post(mShotDetailApiResponse);
        BusProvider.getRestBusInstance().unregister(this);
    }

    @Override
    public void execute() {
        getShotDetail(mId);
    }
}
