package br.com.wakanda.open.ia.model;

public class ResponseEstado {

    private String resposta;

    public ResponseEstado(String resposta) {
        this.resposta = resposta;
    }

    public ResponseEstado() {
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
