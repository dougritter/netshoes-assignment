package br.com.netshoes.assignment.mvp.views;

import java.util.List;

import br.com.netshoes.model.entities.ShotsResponse;

/**
 * Created by douglas on 7/6/15.
 */
public interface ShotsView extends MVPView {
    void showShots (ShotsResponse shotsResponse);
    void showLoading ();
    void hideLoading ();
    void showError (String error);
    void hideError ();

}
