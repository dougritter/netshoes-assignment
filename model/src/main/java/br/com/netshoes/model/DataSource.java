package br.com.netshoes.model;

public interface DataSource {
    void getShots(int page);
    void getShotDetail(int id);

}