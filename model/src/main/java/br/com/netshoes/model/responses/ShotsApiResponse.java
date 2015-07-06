package br.com.netshoes.model.responses;

import java.util.List;

import br.com.netshoes.model.entities.ShotsResponse;

public class ShotsApiResponse extends ApiReponse{
    private List<ShotsResponse> shots;
    public List<ShotsResponse> getShots() {
        return shots;
    }
    public void setShots(List<ShotsResponse> shots) {
        this.shots = shots;
    }
}
