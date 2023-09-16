package com.gilos.marcelo.componentes;

public class Pessoa {
    private String nome;
    private String cpf;
    private String idade;
    private Endereco Endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco endereco) {
        Endereco = endereco;
    }

    @Override
    public String toString() {
        return ("Nome:" + this.getNome() + "\n" +
                "CPF:" + this.getCpf() + "\n" +
                "Idade:" + this.getIdade() + "\n" +
                "Cep:" + this.getEndereco().getCep() + "\n" +
                "Logadouro:" + this.getEndereco().getLogradouro() + "\n" +
                "Complemento:" + this.getEndereco().getComplemento() + "\n" +
                "Bairro:" + this.getEndereco().getBairro() + "\n" +
                "Localidade:" + this.getEndereco().getLocalidade() + "\n" +
                "UF:" + this.getEndereco().getUf());
    }
}
