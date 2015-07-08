package br.com.netshoes.model.responses;

import br.com.netshoes.model.entities.Shot;

public class ShotDetailApiResponse extends ApiReponse{
    private Shot shotDetail;
    public Shot getShotDetail() {
        return shotDetail;
    }
    public void setShotDetail(Shot shots) {
        this.shotDetail = shots;
    }
}
