package br.edu.fatecpg.EX1.model;

public class Tarefa {
   private String titulo;
   private String descricao;
   private boolean status;

   public Tarefa(String titulo, String descricao, boolean status) {
      this.titulo = titulo;
      this.descricao = descricao;
      this.status = status;
   }

   public Tarefa(String titulo, String descricao) {
      this.titulo = titulo;
      this.descricao = descricao;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public boolean isStatus() {
      return status;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return  "Título: " + titulo + "\n" +
              "Descrição: " + descricao + "\n" +
              "Status: " + (status ? "Concluída" : "Pendente") + "\n";
   }
}
