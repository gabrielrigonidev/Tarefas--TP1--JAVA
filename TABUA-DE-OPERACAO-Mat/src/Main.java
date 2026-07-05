import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner ler = new Scanner(System.in);

      System.out.println("Qual operação deseja realizar?");
      String respOperacao = ler.nextLine();

      System.out.println("Qual o número?");
      int respNum = ler.nextInt();

      if (respOperacao.equals("+")){
         Tabua.somarZ(respNum);
      } else if (respOperacao.equals("*")){
         Tabua.multZ(respNum);
      }
   }
}