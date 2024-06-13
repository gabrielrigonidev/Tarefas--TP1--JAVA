package br.edu.fatecpg.model;

public class Disciplina {
   private String nome;
   private double nota;

   public Disciplina(String nome, double nota) {
      this.nome = nome;
      this.nota = nota;
   }
   public String getNome() {
      return nome;
   }
   public double getNota() {
      return this.nota;
   }

   public void adicionarNota(double novaNota){
      this.nota = novaNota;
   }

   public void exibirInformacoes() {
      System.out.println("NOME DISCIPLINA: " + this.nome);
      System.out.println("NOTA DISCIPLINA: " + this.nota);
   }
}