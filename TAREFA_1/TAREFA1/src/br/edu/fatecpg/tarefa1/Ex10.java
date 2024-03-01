package br.edu.fatecpg.tarefa1;
import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        String senhaSecreta = "Java123";
        String tentativaSenha;

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite a Senha: ");
        tentativaSenha = ler.nextLine();

        while(!tentativaSenha.equals(senhaSecreta)){
            System.out.println("Você Errou! Tente novamente.");
            tentativaSenha = ler.nextLine();

        } System.out.println("Você Acertou!");
    }
}