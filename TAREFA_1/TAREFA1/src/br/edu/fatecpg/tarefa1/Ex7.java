package br.edu.fatecpg.tarefa1;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        int num;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite sua Idade: ");
        num = ler.nextInt();

        if(num < 18){
            System.out.println("Você é Menor de idade!");
        } else if (num < 60) {
            System.out.println("Você é Adulto!");
        } else {
            System.out.println("Você é Idoso!");
        }
    }
}
