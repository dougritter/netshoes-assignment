package br.com.netshoes.model.rest;

import br.com.netshoes.model.entities.ShotsResponse;
import br.com.netshoes.model.responses.ShotsApiResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by douglas on 7/6/15.
 */
public interface NetshoesApi {

    //http://api.dribbble.com/shots/popular?page=1
    @GET("/shots/popular")
    void getShots(@Query("page") int page, Callback<ShotsResponse> callback);

}
