package br.edu.fatec.main;

import br.edu.fatec.model.ContaBancaria;

public class Principal {
   public static void main(String[] args) {
      ContaBancaria minhaConta = new ContaBancaria(001,001,"Corrente","Rigoni");
      minhaConta.depositarValor(30);
      minhaConta.sacarValor(90);
   }
}
