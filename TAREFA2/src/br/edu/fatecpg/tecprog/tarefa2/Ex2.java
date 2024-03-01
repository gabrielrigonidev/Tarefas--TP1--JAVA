package br.edu.fatecpg.tecprog.tarefa2;
import java.util.Scanner;
public class Ex2 {
   public static void main(String[] args) {
      Scanner ler = new Scanner(System.in);
      String[][] usuarios = new String[6][2];
      boolean loginValido = false, senhaValida = false;

      for (int l = 0; l <= 5; l++) {
         System.out.println("Crie o Login: ");
         usuarios[l][0] = ler.nextLine();
         System.out.println("CRIE uma Senha: ");
         usuarios[l][1] = ler.nextLine();
      }

      System.out.print("ENTRE com um Login válido: ");
      String login = ler.nextLine();
      System.out.print("ENTRE com uma Senha válida: ");
      String senha = ler.nextLine();
      ler.close();

      for (int l = 0; l <= 5; l++) {
         if (usuarios[l][0].equals(login)) {
               loginValido = true;
            if (usuarios[l][1].equals(senha)) {
               senhaValida = true;
            }
            break;
         }
      }

//      for (String[] usuario : usuarios) {
//         if (usuario[0].equals(login) ) {
//            loginValido = true;
//         }
//         if (usuario[1].equals(senha)) {
//            senhaValida = true;
//         }
//      }

      if (loginValido && senhaValida) {
         System.out.println("LOGIN E SENHA VALIDADOS!");
      } else if (!senhaValida) {
         System.out.println("SENHA INVALIDADA!");
      } else if (!loginValido){
         System.out.println("LOGIN INVALIDADO!");
      }
      else{
         System.out.println("LOGIN E SENHA INVALIDADOS!");
      }
   }
}
