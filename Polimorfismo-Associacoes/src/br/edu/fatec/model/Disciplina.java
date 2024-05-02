package br.edu.fatec.model;

import java.util.Scanner;

public class Disciplina {
   private String nmDisciplina;
   private double qtdCargaHoraria;
   private String nmProfessor;
   private Aluno aluno;

   public Disciplina(String nmDisciplina, double qtdCargaHoraria, String nmProfessor) {
      this.nmDisciplina = nmDisciplina;
      this.qtdCargaHoraria = qtdCargaHoraria;
      this.nmProfessor = nmProfessor;
   }

   public static Disciplina lerDisciplina(Scanner sc) {
      System.out.println("Digite o Nome da Disciplina:");
      String nmDisciplina = sc.nextLine();
      System.out.println("Digite a Carga Horária:");
      double qtdCargaHoraria = sc.nextDouble();
      sc.nextLine();
      System.out.println("Digite o Nome do Professor:");
      String nmProfessor = sc.nextLine();
      return new Disciplina(nmDisciplina, qtdCargaHoraria, nmProfessor);
   }

   public String getNmDisciplina() {
      return nmDisciplina;
   }

   public void setNmDisciplina(String nmDisciplina) {
      this.nmDisciplina = nmDisciplina;
   }

   public double getQtdCargaHoraria() {
      return qtdCargaHoraria;
   }

   public void setQtdCargaHoraria(double qtdCargaHoraria) {
      this.qtdCargaHoraria = qtdCargaHoraria;
   }

   public String getNmProfessor() {
      return nmProfessor;
   }

   public void setNmProfessor(String nmProfessor) {
      this.nmProfessor = nmProfessor;
   }

   public Aluno getAluno() {
      return aluno;
   }

   public void setAluno(Aluno aluno) {
      this.aluno = aluno;
   }

   @Override
   public String toString() {
      return "Disciplina:\n" +
              " Nome = '" + nmDisciplina + '\'' +
              ", \n Carga Horária = " + qtdCargaHoraria +
              ", \n Professor = '" + nmProfessor + '\'' +
              ",\n Aluno: " + aluno;
   }
}
