package br.com.netshoes.model.rest;

import com.squareup.okhttp.OkHttpClient;

import br.com.netshoes.common.utils.BusProvider;
import br.com.netshoes.model.DataSource;
import br.com.netshoes.model.entities.ShotsResponse;
import br.com.netshoes.model.responses.ShotsApiResponse;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RestSource implements DataSource {
    public static RestSource INSTANCE;
    private OkHttpClient mClient;
    private final NetshoesApi mNetshoesAPI;

    private RestSource(String namespace) {
        mClient = new OkHttpClient();

        RestAdapter netshoesAPIRest = new RestAdapter.Builder()
                .setEndpoint(namespace)
                .build();

        netshoesAPIRest.setLogLevel(RestAdapter.LogLevel.FULL);
        mNetshoesAPI = netshoesAPIRest.create(NetshoesApi.class);
    }

    public static RestSource getInstance(String namespace) {
        if (INSTANCE == null)
            INSTANCE = new RestSource(namespace);
        return INSTANCE;
    }

    @Override public void getShots(int page) {
        mNetshoesAPI.getShots(page, retrofitCallback);
    }

    public Callback retrofitCallback = new Callback() {

        @Override public void success(Object o, Response response) {
            if (o instanceof ShotsApiResponse) {
                ShotsApiResponse shotsApiResponse = (ShotsApiResponse) o;
                BusProvider.getRestBusInstance().post(shotsApiResponse);
            }
        }

        @Override public void failure(RetrofitError error) {
            BusProvider.getUIBusInstance().post(error);
        }
    };

}