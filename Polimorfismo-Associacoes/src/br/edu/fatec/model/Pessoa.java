package br.edu.fatec.model;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String doc;
    private Endereco endereco;

    public Pessoa(String nome, String doc, Endereco endereco) {
        this.nome = nome;
        this.doc = doc;
        this.endereco = endereco;
    }

    public static Pessoa lerPessoa(Scanner sc) {
        System.out.println("Digite o Nome:");
        String nome = sc.nextLine();
        System.out.println("Digite o Documento:");
        String documento = sc.nextLine();
        Endereco endereco = Endereco.lerEndereco(sc);
        return new Pessoa(nome, documento, endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa {" +
                "nome='" + nome + '\'' +
                ", doc='" + doc + '\'' +
                ", endereco=" + endereco + '}';
    }
}
