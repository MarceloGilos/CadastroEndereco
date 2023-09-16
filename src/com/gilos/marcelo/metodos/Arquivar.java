package com.gilos.marcelo.metodos;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.gilos.marcelo.componentes.Pessoa;

public class Arquivar {
    public static void criarArquivo(List<Pessoa> pessoas) throws IOException {
        try (FileWriter file = new FileWriter("cadastros.json")) {
            file.write(TratamentoApi.converterEnderecoJson(pessoas));
            file.close();
        }
    }

    public static String lerArquivo() throws IOException {

        String json = String.join(" ",Files.readAllLines(Paths.get("cadastros.json")));
                        return json;
    }

}
