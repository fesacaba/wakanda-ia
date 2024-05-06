package br.com.wakanda.open.ia.service;

import br.com.wakanda.open.ia.model.ResponseEstado;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class InfoEstadosUsecase {


    private final OpenAiChatClient client;
    private final VerificaQuantidadeToken verificaQuantidadeToken;

    public InfoEstadosUsecase(OpenAiChatClient client, VerificaQuantidadeToken verificaQuantidadeToken) {
        this.client = client;
        this.verificaQuantidadeToken = verificaQuantidadeToken;
    }

    public Flux<String> buscaEstadosBrasil(String msg) {
        //log.info("****[InfoEstadosUsecase - buscaEstadosBrasil()]****")

        //msg


        try {

            System.out.println("Qtd tokens Request :".concat(verificaQuantidadeToken.run(msg).toString()));


            return client.stream(msg);



        } catch (Exception e) {
            //log.erro(DEU RUIM)
            //Salvar na dabase
            throw new RuntimeException();
        }

    }
}
