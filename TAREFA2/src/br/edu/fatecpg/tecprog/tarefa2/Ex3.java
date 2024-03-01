package br.edu.fatecpg.tecprog.tarefa2;
import java.util.Scanner;

public class Ex3 {
   public static void main(String[] args) {
      Scanner ler = new Scanner(System.in);

      int[][] matriz = new int[4][2];
      int l, c;

      System.out.println("Digite:");
      for (l = 0; l < 4; l++) {
         for (c = 0; c < 2; c++) {
            matriz[l][c] = ler.nextInt();
         }
      }
      ler.close();

      System.out.println("Matriz Original:");
      for (l = 0; l < 4; l++) {
         for (c = 0; c < 2; c++) {
            System.out.print(matriz[l][c] + " ");
         }
         System.out.println();
      }

      System.out.println("Matriz Transposta:");
      for (c = 0; c < 2; c++) {
         for (l = 0; l < 4; l++) {
            System.out.print(matriz[l][c] + " ");
         }
         System.out.println();
      }
   }
}