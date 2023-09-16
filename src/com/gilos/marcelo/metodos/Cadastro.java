package com.gilos.marcelo.metodos;

import java.util.InputMismatchException;
import java.util.List;

import com.gilos.marcelo.componentes.Endereco;
import com.gilos.marcelo.componentes.Pessoa;
import com.gilos.marcelo.main.Main;

public class Cadastro {
    public static Pessoa cadastro() {
        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();
        System.out.println("Nome:");
        pessoa.setNome(Main.SCANNER.nextLine());
        do {
            System.out.println("CPF:");
            pessoa.setCpf(Main.SCANNER.nextLine());
            if (Cadastro.validarCpf(pessoa.getCpf()) == false) {
                System.out.println("CPF invalido, porfavor digitar um CPF valido");
            }
        } while (Cadastro.validarCpf(pessoa.getCpf()) == false);
        System.out.println("Idade");
        pessoa.setIdade(Main.SCANNER.nextLine());
        System.out.println("CEP:");
        pessoa.setEndereco(endereco.carregarEndereco(Main.SCANNER.nextLine()));
        if (pessoa.getEndereco().getErro() != null) {
            System.out.println("CEP INVALIDO");
        }
        return pessoa;

    }

    public static String deletarPessoa(List<Pessoa> pessoas, String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().toUpperCase().equals(nome.toUpperCase())) {
                return String.valueOf(pessoas.indexOf(pessoa));
            }
        }
        return null;
    }

    public static boolean validarCpf(String CPF) {
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
