package br.com.netshoes.domain;

import br.com.netshoes.model.responses.ShotDetailApiResponse;
import br.com.netshoes.model.responses.ShotsApiResponse;

/**
 * Created by douglas on 7/7/15.
 */
public interface GetShotDetailUseCase extends UseCase{
    void getShotDetail(int id);
    void onShotDetailReceived(ShotDetailApiResponse response);

}
