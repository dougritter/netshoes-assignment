package br.com.netshoes.assignment.mvp.views;

import br.com.netshoes.model.responses.ShotDetailApiResponse;

/**
 * Created by douglasritter on 7/7/15.
 */
public interface ShotDetailView extends MVPView{
    void showShotDetail (ShotDetailApiResponse shotDetailApiResponse);
    void showLoading ();
    void hideLoading ();
    void showError (String error);
    void hideError ();
}
