package br.com.netshoes.domain;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import br.com.netshoes.common.utils.BusProvider;
import br.com.netshoes.model.DataSource;
import br.com.netshoes.model.responses.ShotsApiResponse;

/**
 * Created by douglas on 7/6/15.
 */
public class GetShotsUseCaseController implements GetShotsUseCase {
    private final DataSource mDataSource;
    private final Bus mUiBus;

    private ShotsApiResponse mShotsResponse;

    public GetShotsUseCaseController(DataSource dataSource, Bus uiBus) {
        if (dataSource == null || uiBus == null)
            throw new IllegalArgumentException("DataSource and Bus cannot be null");

        mDataSource = dataSource;
        mUiBus = uiBus;

        BusProvider.getRestBusInstance().register(this);

    }

    @Override public void getShots(int page) {
        mDataSource.getShots(page);
    }

    @Override
    public void onShotsReceived(ShotsApiResponse response) {
        mShotsResponse = response;
        sendToPresenter();
    }

    @Override
    public void sendToPresenter() {
        mUiBus.post(mShotsResponse);
        BusProvider.getRestBusInstance().unregister(this);
    }

    @Override
    public void execute() {
//        getShots(page);
    }
}
