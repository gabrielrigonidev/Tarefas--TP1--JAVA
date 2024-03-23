package br.edu.fatec.tp.abstracao;

public class Carro {
   private String marca;
   private String modelo;
   private String placa;
   private String chassi;
   private String motor;
   public final double velMax = 180;
   public double velAtual = 0;
   public boolean estado = false;
   public double tanque = 50;

   //Construtor
   public Carro(String marca, String modelo, String placa, String chassi, String motor) {
      this.marca = marca;
      this.modelo = modelo;
      this.placa = placa;
      this.motor = motor;
      this.chassi = chassi;
   }

   public String getMarca() {
      return marca;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public String getModelo() {
      return modelo;
   }

   public void setModelo(String modelo) {
      this.modelo = modelo;
   }

   public String getPlaca() {
      return placa;
   }

   public void setPlaca(String placa) {
      this.placa = placa;
   }

   public void girarChave() throws InterruptedException {
      if (this.estado == false) {
         this.estado = true;
         System.out.println("Ligando...");
         Thread.sleep(1500);
         System.out.println("Vrum Vrum!");
      } else if (this.estado == true) {
         this.estado = false;
         System.out.println("Desligando...");
         Thread.sleep(1500);
         System.out.println("Desligado!");
      }
   }

   public void acelerar(double aceleracao) throws InterruptedException {
      if (this.velAtual < this.velMax) {
         this.velAtual += aceleracao;
         System.out.println("Acelerando...");
         Thread.sleep(1000);

         if (velAtual >= 180) {
            this.velAtual = 180;
            System.out.println("Velocidade máxima atendida");
            System.out.println("Por favor diminua!");
         }
      }
   }

   public void desacelerar(double desaceleraracao) throws InterruptedException {
      if (this.velAtual != 0) {
         this.velAtual -= desaceleraracao;
         System.out.println("Desacelerando...");
         Thread.sleep(1000);

         if (velAtual == 0) {
            this.velAtual = 0;
            System.out.println("Velocidade mínima atendida");
            System.out.println("Por favor acelere!");
         }
      }
   }

   public void buzinar() {
      System.out.println("Bi... Bi... Bi");
   }

   public void abastecer(double valorGasolina) {
      double tanqueCheio = valorGasolina * tanque;
      System.out.println("O valor total para encher o tanque: R$" + tanqueCheio);
   }
}