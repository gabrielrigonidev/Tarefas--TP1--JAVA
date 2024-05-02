package br.edu.fatec.model;

import java.util.Scanner;

public class Compra {
   private double vlTotal;
   private int qtdItens;
   private String dtCompra;
   private String nmCliente;
   private Cupom cupom;
   private double valorComDesconto;

   public Compra(double vlTotal, int qtdItens, String dtCompra, String nmCliente) {
      this.vlTotal = vlTotal;
      this.qtdItens = qtdItens;
      this.dtCompra = dtCompra;
      this.nmCliente = nmCliente;
   }

   public void finalizar(Cupom cupom) {
      this.cupom = cupom;
      double desconto = cupom.getVlDesconto();
      this.vlTotal -= desconto;
      this.valorComDesconto = this.vlTotal;
   }

   public static Compra lerDadosCompra(Scanner sc) {
      System.out.println("Digite o Valor da Compra:");
      double vlTotal = sc.nextDouble();
      sc.nextLine();

      System.out.println("Digite a Quantidade de Itens:");
      int qtdItens = sc.nextInt();
      sc.nextLine();

      System.out.println("Digite a Data da Compra:");
      String dtCompra = sc.nextLine();

      System.out.println("Digite o Nome do Cliente:");
      String nmCliente = sc.nextLine();

      return new Compra(vlTotal, qtdItens, dtCompra, nmCliente);
   }

   public double getVlTotal() {
      return vlTotal;
   }

   public void setVlTotal(double vlTotal) {
      this.vlTotal = vlTotal;
   }

   public int getQtdItens() {
      return qtdItens;
   }

   public void setQtdItens(int qtdItens) {
      this.qtdItens = qtdItens;
   }

   public String getDtCompra() {
      return dtCompra;
   }

   public void setDtCompra(String dtCompra) {
      this.dtCompra = dtCompra;
   }

   public String getNmCliente() {
      return nmCliente;
   }

   public void setNmCliente(String nmCliente) {
      this.nmCliente = nmCliente;
   }

   @Override
   public String toString() {
      return "Compra:\n" +
              " Valor Total: R$" + vlTotal +
              "\n Quantidade de Itens: " + qtdItens +
              "\n Data da Compra: " + dtCompra +
              "\n Nome do Cliente: " + nmCliente +
              "\n Valor com Desconto: " + this.valorComDesconto +
              "\nCupom: " + cupom;
   }
}
