package br.com.netshoes.domain;

import br.com.netshoes.model.responses.ShotsApiResponse;

/**
 * Created by douglas on 7/6/15.
 */
public interface GetShotsUseCase extends UseCase{
    void getShots(int page);
    void onShotsReceived(ShotsApiResponse response);

}
