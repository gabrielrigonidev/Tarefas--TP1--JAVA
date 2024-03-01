package br.edu.fatecpg.tarefa1;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        String nome2;
        boolean nomeIgual = false;
        int i;

        Scanner ler = new Scanner(System.in);

        for (i = 0; i < nomes.length; i++) {
            System.out.println("Digite um Nome: ");
            nomes[i] = ler.nextLine();
        }

        System.out.println("Digite OUTRO Nome: ");
        nome2 = ler.nextLine();

        for (i = 0; i < nomes.length; i++) {
            if (nomes[i].equals(nome2)) {
                nomeIgual = true;
            }
        }
        if (nomeIgual = true) {
            System.out.println("Há um nome igual na lista!");

        } else {
            System.out.println("Não há nome igual na lista!");
        }
    }
}
