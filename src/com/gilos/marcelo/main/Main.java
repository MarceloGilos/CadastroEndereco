package com.gilos.marcelo.main;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gilos.marcelo.componentes.Pessoa;
import com.gilos.marcelo.metodos.Arquivar;
import com.gilos.marcelo.metodos.Cadastro;
import com.gilos.marcelo.metodos.LimparTela;
import com.gilos.marcelo.metodos.TratamentoApi;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException, IOException {
        List<Pessoa> listaCadastro = new ArrayList<Pessoa>();
        int contadorCadastro = 0;
        boolean sair = false;
        int menuEscolha;

        try {
            listaCadastro = TratamentoApi.converterJsonBdb(Arquivar.lerArquivo());
        } catch (Exception e) {

        }
        while (sair == false) {
            System.out.println("Bem-vindo ao cadastro de pessoas");
            System.out.println("""
                    Menu
                    1-Adicionar nova pessoa
                    2-Excluir pessoa
                    3-Listar pessoas
                    4-Buscar pessoa
                    5-Sair
                    """);
            System.out.println("Opção:");
            menuEscolha = Integer.parseInt(SCANNER.nextLine());
            LimparTela.limparTela();
            switch (menuEscolha) {
                case 1:
                    listaCadastro.add(contadorCadastro, Cadastro.cadastro());
                    System.out.println("\nCadastro feito com sucesso");
                    break;
                case 2:
                    System.out.println("Qual o nome da Pessoa:");
                    String nome = SCANNER.nextLine();
                    if (Cadastro.deletarPessoa(listaCadastro, nome) != null) {
                        listaCadastro.remove(Integer.parseInt(Cadastro.deletarPessoa(listaCadastro, nome)));
                        System.out.println(nome + " deletado com sucesso");
                    }else{
                        System.out.println("Pessoa não esta na lista");
                    }

                    break;
                case 3:
                    for (Pessoa pessoa : listaCadastro) {
                        System.out.println(pessoa.toString() + "\n");
                    }
                    break;
                case 4:
                    break;
                case 5:
                    Arquivar.criarArquivo(listaCadastro);
                    sair = true;
                    break;
            }
            System.out.println("\n Precione ENTER para continuar");
            SCANNER.nextLine();
            LimparTela.limparTela();
        }
        SCANNER.close();
    }
}
