package br.com.wakanda.open.ia.controller;

import br.com.wakanda.open.ia.model.ResponseEstado;
import br.com.wakanda.open.ia.service.InfoEstadosUsecase;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/ia")
public class SampleController {

    private final OpenAiChatClient client;
    private final InfoEstadosUsecase infoEstadosUsecase;

    public SampleController(OpenAiChatClient client, InfoEstadosUsecase infoEstadosUsecase) {
        this.client = client;
        this.infoEstadosUsecase = infoEstadosUsecase;
    }


    @GetMapping("/simples")
    public String primeiroTeste(
            @RequestParam(value = "msg", defaultValue = "quais estados do Brasil")
            String msg
    ) {
        return client.call(msg);
    }

    @GetMapping("/teste")
    public ChatResponse segundoTeste(
            @RequestParam(value = "msg", defaultValue = "quais estados do Brasil")
            String msg
    ) {
        return client.call(new Prompt(msg));
    }

    @GetMapping("/estado")
    public Flux<String> buscaEstadosBrasil(
            @RequestParam(value = "msg", defaultValue = "Fale sobre o estado que é conhecido pelos seus canaviais")
            //if msg null | defaultValue
            String msg
    ) {
        return infoEstadosUsecase.buscaEstadosBrasil(msg);
    }



}



