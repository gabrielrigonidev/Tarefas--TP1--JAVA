package br.edu.fatec.model;

import java.util.Scanner;

public class Cupom {
   private String cdCupom;
   private double vlDesconto;
   private String dtValidade;

   public Cupom(String cdCupom, double vlDesconto, String dtValidade) {
      this.cdCupom = cdCupom;
      this.vlDesconto = vlDesconto;
      this.dtValidade = dtValidade;
   }

   public static Cupom lerDadosCupom(Scanner sc) {
      System.out.println("Digite o Código do Cupom:");
      String cdCupom = sc.nextLine();
      System.out.println("Digite o Valor do Desconto:");
      double vlDesconto = sc.nextDouble();
      sc.nextLine();
      System.out.println("Digite a Data de Validade do Cupom:");
      String dtValidade = sc.nextLine();
      return new Cupom(cdCupom, vlDesconto, dtValidade);
   }

   public String getCdCupom() {
      return cdCupom;
   }

   public void setCdCupom(String cdCupom) {
      this.cdCupom = cdCupom;
   }

   public double getVlDesconto() {
      return vlDesconto;
   }

   public void setVlDesconto(double vlDesconto) {
      this.vlDesconto = vlDesconto;
   }

   public String getDtValidade() {
      return dtValidade;
   }

   public void setDtValidade(String dtValidade) {
      this.dtValidade = dtValidade;
   }

   @Override
   public String toString() {
      return  "\n Código do Cupom: " + cdCupom +
              "\n Valor de Desconto: R$" + vlDesconto +
              "\n Data de Validade: " + dtValidade;
   }
}
