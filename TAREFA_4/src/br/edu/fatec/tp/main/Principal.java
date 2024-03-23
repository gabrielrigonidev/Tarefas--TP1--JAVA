package br.edu.fatec.tp.main;
import br.edu.fatec.tp.abstracao.Carro;
import java.util.Scanner;

public class Principal {
   public static void main(String[] args) throws InterruptedException {
      Scanner ler = new Scanner(System.in);
      double velocidade;
      String respCarro;

      System.out.println("---- Simulador de Carro 2024 ---- Eae, bora dirigir?");
      System.out.println("Digite as informações do seu carro:");

      System.out.print("Marca: ");
      String marca = ler.nextLine();

      System.out.print("Modelo: ");
      String modelo = ler.nextLine();

      System.out.print("Placa: ");
      String placa = ler.nextLine();

      System.out.print("Motor: ");
      String motor = ler.nextLine();

      System.out.print("Chassi: ");
      String chassi = ler.nextLine();

      Carro meuCarro = new Carro(marca, modelo, placa, chassi, motor);

      System.out.println("-------------------------------------------------------------------");
      System.out.println("Cockpit: 1 - Ligar carro | 2 - Sair do carro | 3 - Abastecer");
      int resp = ler.nextInt();
      ler.nextLine();

      if (resp == 1){
         meuCarro.girarChave();
         while (meuCarro.estado) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Velocidade Atual: " + meuCarro.velAtual);
            System.out.println("Cockpit: 'A' - Acelerar | 'F' - Freiar: | 'B' Buzinar: | '0' Desligar:");
            respCarro = ler.nextLine();

            switch (respCarro.toUpperCase()) {
               case "A":
                  System.out.print("KM: ");
                  velocidade = ler.nextDouble();
                  ler.nextLine();
                  meuCarro.acelerar(velocidade);
                  break;
               case "F":
                  System.out.print("KM: ");
                  velocidade = ler.nextDouble();
                  ler.nextLine();
                  meuCarro.desacelerar(velocidade);
                  break;
               case "B":
                  meuCarro.buzinar();
                  break;
               case "0":
                  meuCarro.girarChave();
                  break;
               default:
                  return;
            }
         }
      } else if (resp == 2){
         return;
      } else if (resp == 3){
         System.out.println("Digite o valor do Litro: ");
         double valorGasolina = ler.nextDouble();
         meuCarro.abastecer(valorGasolina);
      }
//                if (respCarro.equalsIgnoreCase("A")){
//                    System.out.print("KM: ");
//                    velocidade = ler.nextDouble();
//                    ler.nextLine();
//                    meuCarro.acelerar(velocidade);
//                } else if (respCarro.equalsIgnoreCase("F")){
//                    System.out.print("KM: ");
//                    velocidade = ler.nextDouble();
//                    ler.nextLine();
//                    meuCarro.desacelerar(velocidade);
//                } else if (respCarro.equalsIgnoreCase("B")){
//                    meuCarro.buzinar();
//                } else if (respCarro.equals("0")){
//                    meuCarro.girarChave();
//                }
      }
   }