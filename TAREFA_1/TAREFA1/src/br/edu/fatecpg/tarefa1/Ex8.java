package br.edu.fatecpg.tarefa1;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        int fatorial, num;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um Número: ");
        num = scanner.nextInt();

        fatorial = (int) Math.pow(num, 2);

        System.out.println("Soma dos primeiros " + num + " números ímpares: " + fatorial);
        scanner.close();

//        Versão Anterior
//        int soma = 0;
//        int numeroImpar = 1;
//        for (int i = 0; i < num; i++) {
//            soma = soma + numeroImpar;
//            numeroImpar = numeroImpar + 2;
//        }
    }
}