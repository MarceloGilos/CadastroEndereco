package com.gilos.marcelo.metodos;
import com.gilos.marcelo.componentes.Endereco;
import com.gilos.marcelo.componentes.Pessoa;
import com.gilos.marcelo.main.Main;

public class Cadastro {
    public static Pessoa cadastro() {
        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();
        System.out.println("Nome:");
        pessoa.setNome(Main.SCANNER.nextLine());
        System.out.println("Idade");
        pessoa.setIdade(Main.SCANNER.nextLine());
        System.out.println("CEP:");
        pessoa.setEndereco(endereco.carregarEndereco(Main.SCANNER.nextLine()));
        if(pessoa.getEndereco().getErro() != null){
            System.out.println("CEP INVALIDO");
        }
        return pessoa;

    }
}
