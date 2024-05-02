package br.edu.fatec.model;
import java.util.Scanner;

public class Endereco {
    private String cep;
    private String rua;
    private int num;

    public Endereco(String cep, String rua, int num) {
        this.cep = cep;
        this.rua = rua;
        this.num = num;
    }
    public static Endereco lerEndereco(Scanner sc) {
        System.out.println("Digite o Cep:");
        String cep = sc.nextLine();
        System.out.println("Digite a Rua:");
        String rua = sc.nextLine();
        System.out.println("Digite o Número:");
        int numero = sc.nextInt();
        return new Endereco(cep, rua, numero);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return  "{cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", num=" + num +
                '}';
    }
}
