package com.gilos.marcelo.metodos;

import java.io.IOException;

public class LimparTela {
    public static void limparTela() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else {
            String[] clear = { "clear" };
            Runtime.getRuntime().exec(clear);
        }
    }
}
