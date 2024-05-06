package br.com.wakanda.open.ia.service;


import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.ModelType;
import org.springframework.stereotype.Service;

@Service
public class VerificaQuantidadeToken {

    public Integer run(String prompt) {
        var registry = Encodings.newDefaultEncodingRegistry();
        var enc = registry.getEncodingForModel(ModelType.GPT_4);
        return enc.countTokens(prompt);
    }
}
