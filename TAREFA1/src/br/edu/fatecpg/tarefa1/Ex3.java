package br.edu.fatecpg.tarefa1;
import java.util.Scanner;
public class Ex3 {
    public static final double PI = 3.14;
    public static void main(String[] args){
        double num1 = 0, num2 = 0, result;
        int numMenu;
        String menu = """
                              Entre com as opções:
                              1 - Área do Quadrado
                              2 - Área do Círculo
                              """;
        System.out.println(menu);
        Scanner ler = new Scanner(System.in);
        numMenu = ler.nextInt();
        switch(numMenu){
            case 1:
                System.out.println("Digite o lado do quadrado: ");
                num1 = ler.nextDouble();
                result = num1 * num1;
                System.out.println(result);
                break;
            case 2:
                System.out.println("Digite o raio do círculo: ");
                num2 = ler.nextDouble();
                result = PI * Math.pow(num2, 2);
                System.out.println(result);
                break;
        }
    }
}
