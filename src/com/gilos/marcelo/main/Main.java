package com.gilos.marcelo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gilos.marcelo.componentes.Pessoa;
import com.gilos.marcelo.metodos.Cadastro;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        List<Pessoa> listaCadastro = new ArrayList<Pessoa>();
        int contadorCadastro = 0;
        boolean sair = false;
        while (sair == false) {
            System.out.println("""
                    Bem-vindo ao cadastro de pessoas
                    """);
            System.out.println("""
                    Menu
                    1-Adicionar nova pessoa
                    2-Excluir pessoa
                    3-Listar pessoas
                    4-Buscar pessoas
                    5-Sair
                    """);           
            switch (Integer.parseInt(SCANNER.nextLine())) {
                case 1:
                    listaCadastro.add(contadorCadastro, Cadastro.cadastro());
                    System.out.println("Cadastro feito com sucesso");
                    break;
                case 2:
                    break;
                case 3:
                    for (Pessoa pessoa : listaCadastro) {
                        System.out.println(pessoa.toString());
                    }
                    break;
                case 4:
                    break;
                case 5:
                    sair = true;
                    break;
            }
        }
        SCANNER.close();
    }
}
