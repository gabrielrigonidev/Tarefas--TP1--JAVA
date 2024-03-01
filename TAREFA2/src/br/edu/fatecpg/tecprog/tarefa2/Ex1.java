package br.edu.fatecpg.tecprog.tarefa2;
import java.util.Scanner;

public class Ex1 {
   public static void main(String[] args) {
      Scanner ler = new Scanner(System.in);
      int [][] matriz1 = new int [3][3];
      int [][] matriz2 = new int [3][3];
      int [][] result =  new int [3][3];;

      for (int l = 0; l <= 2; l++){
         for (int c = 0; c <= 2; c++){
            System.out.println("Digite a " + (l + 1) + "ª Linha da " +  (c + 1) + "º Coluna p/ Matriz 1:");
            matriz1[l][c] = ler.nextInt();
         }
      }
      for (int l = 0; l <= 2; l++){
         for (int c = 0; c <= 2; c++){
            System.out.println("Digite o " + c+1 + "º valor p/ Matriz 2:");
            matriz2[l][c] = ler.nextInt();
         }
      }
      ler.close();

      for (int l = 0; l <= 2; l++){
         for (int c = 0; c <= 2; c++){
            result[l][c] = matriz1[l][c] + matriz2 [l][c];
            System.out.print(result[l][c] + " ");
         }
         System.out.println();
      }
   }
}