package br.edu.fatec.tecprog;

public class Carro {

   public String marca;
   public String modelo;
   public String placa;
   public double velMax = 180;
   public double velAtual = 0;
   public boolean estado = false;

   public void ligar() throws InterruptedException {
      if (this.estado == false) {
         this.estado = true;
         System.out.println("Ligando...");
         Thread.sleep(1500);
         System.out.println("Vrum Vrum!");
      }
   }

   public void desligar() throws InterruptedException {
      if (this.estado == true){
         this.estado = false;
         System.out.println("Desligando...");
         Thread.sleep(1500);
         System.out.println("Desligado!");
      }
   }

   public void acelerar(double aceleracao) {
      if(this.velAtual < this.velMax) {
         this.velAtual += aceleracao;
         if (velAtual >= 180) {
            this.velAtual = 180;
            System.out.println("Velocidade máxima atendida");
            System.out.println("Por favor diminua!");
         }
      } else {
         System.out.println("Acelerando...");
      }
   }

   public void desacelerar(double desaceleraracao) {
      if(this.velAtual != 0) {
         this.velAtual -= desaceleraracao;
         if (velAtual == 0) {
            this.velAtual = 0;
            System.out.println("Velocidade mínima atendida");
            System.out.println("Por favor acelere!");
         }
      } else {
         System.out.println("Desacelerando...");
      }
   }

   public void buzinar() {
      System.out.println("Bi... Bi... Bi");
   }

}