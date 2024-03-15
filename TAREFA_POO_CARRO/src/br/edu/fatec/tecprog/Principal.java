package br.edu.fatec.tecprog;

import java.util.Scanner;

public class Principal {

   public static void main(String[] args) throws InterruptedException {
      Scanner ler = new Scanner(System.in);
      double velocidade;
      String respCarro;
      Carro meuCarro = new Carro();

      System.out.println("---- Simulador de Carro 2024 ---- Eae, bora dirigir?");
//      System.out.println("Digite as informações do seu carro:");
//
//      System.out.println("Marca:");
//      meuCarro.marca = ler.nextLine();
//
//      System.out.println("Modelo:");
//      meuCarro.modelo = ler.nextLine();
//
//      System.out.println("Placa:");
//      meuCarro.placa = ler.nextLine();

      System.out.println("-------------------------------------------------------------");
      System.out.println("Cockpit: 1 - Ligar carro | 2 - Sair do carro ");
      int resp = ler.nextInt();
      ler.nextLine();

      if (resp == 1){
         meuCarro.ligar();
         while (meuCarro.estado) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Velocidade Atual: " + meuCarro.velAtual);
            System.out.println("Cockpit: 'A' - Acelerar | 'F' - Freiar: | 'B' Buzinar: | '0' Desligar:");
            respCarro = ler.nextLine();

            if (respCarro.equalsIgnoreCase("A")){
               System.out.print("KM: ");
               velocidade = ler.nextDouble();
               ler.nextLine();
               meuCarro.acelerar(velocidade);

            } else if (respCarro.equalsIgnoreCase("F")){
               System.out.print("KM: ");
               velocidade = ler.nextDouble();
               ler.nextLine();
               meuCarro.desacelerar(velocidade);

            } else if (respCarro.equalsIgnoreCase("B")){
               meuCarro.buzinar();
            } else if (respCarro.equals("0")){
               meuCarro.desligar();
            }
         }
      } else if (resp == 2){
         return;
      }
   }
}