package com.gilos.marcelo.metodos;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.gilos.marcelo.componentes.Endereco;
import com.gilos.marcelo.componentes.Pessoa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TratamentoApi {
    static public Endereco converterJsonEndereco(String string) {
        Gson json = new Gson();
        Endereco tipo = json.fromJson(string.toString(), Endereco.class);
        return tipo;
    }
        static public List<Pessoa> converterJsonBdb(String string) {
        Type collectionType = new TypeToken<List<Pessoa>>(){}.getType();
         Gson json = new Gson();
       List<Pessoa> tipo = json.fromJson(string.toString(), collectionType);
        return tipo;
    }
    static public String converterEnderecoJson(List<Pessoa> pessoa){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        return json.toJson(pessoa);
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
