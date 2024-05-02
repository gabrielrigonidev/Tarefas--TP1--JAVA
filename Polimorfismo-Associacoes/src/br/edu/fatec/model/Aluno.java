package br.edu.fatec.model;
import java.util.Scanner;

public class Aluno {
   private int cdMatricula;
   private String nmAluno;
   private String dtNascimento;
   private double numMedia;

   public Aluno(int cdMatricula, String nmAluno, String dtNascimento, double numMedia) {
      this.cdMatricula = cdMatricula;
      this.nmAluno = nmAluno;
      this.dtNascimento = dtNascimento;
      this.numMedia = numMedia;
   }

   public static Aluno lerAluno(Scanner sc) {
      System.out.println("Digite o Código de Matrícula:");
      int cdMatricula = sc.nextInt();
      sc.nextLine();
      System.out.println("Digite o Nome do Aluno:");
      String nome = sc.nextLine();
      System.out.println("Digite a Data de Nascimento:");
      String dtNascimento = sc.nextLine();
      System.out.println("Digite a Média do Aluno:");
      double numMedia = sc.nextDouble();
      return new Aluno(cdMatricula, nome, dtNascimento, numMedia);
   }

   public int getCdMatricula() {
      return cdMatricula;
   }

   public void setCdMatricula(int cdMatricula) {
      this.cdMatricula = cdMatricula;
   }

   public String getNmAluno() {
      return nmAluno;
   }

   public void setNmAluno(String nmAluno) {
      this.nmAluno = nmAluno;
   }

   public String getDtNascimento() {
      return dtNascimento;
   }

   public void setDtNascimento(String dtNascimento) {
      this.dtNascimento = dtNascimento;
   }

   public double getNumMedia() {
      return numMedia;
   }

   public void setNumMedia(double numMedia) {
      this.numMedia = numMedia;
   }

   @Override
   public String toString() {
      return  "\n  Matrícula = '" + cdMatricula + '\'' +
              ",\n  Nome = '" + nmAluno + '\'' +
              ",\n  Data Nascimento = '" + dtNascimento + '\'' +
              ",\n  Média = " + numMedia;
   }
}
