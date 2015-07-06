package br.com.netshoes.model.responses;

import java.util.List;

import br.com.netshoes.model.entities.ShotsResponse;

public class ShotsApiResponse extends ApiReponse{
    private ShotsResponse shots;
    public ShotsResponse getShots() {
        return shots;
    }
    public void setShots(ShotsResponse shots) {
        this.shots = shots;
    }
}
