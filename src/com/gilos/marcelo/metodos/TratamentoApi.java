package com.gilos.marcelo.metodos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.gilos.marcelo.componentes.Endereco;
import com.google.gson.Gson;

public class TratamentoApi {
    static public Endereco converterJsonEndereco(String string) {
        Gson json = new Gson();
        Endereco endereco = json.fromJson(string.toString(), Endereco.class);
        return endereco;
    }

    static public String requisitorApiEndereco(String cep) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/"))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;

    }
}
