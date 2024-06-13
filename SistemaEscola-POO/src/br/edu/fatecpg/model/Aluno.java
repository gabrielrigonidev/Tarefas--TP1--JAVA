package br.edu.fatecpg.model;

import br.edu.fatecpg.controller.Turma;

import java.util.List;
import java.util.ArrayList;

public class Aluno {
   private String matricula;
   private String nome;
   private int idade;
   private Turma turma;
   private List<Disciplina> disciplinas = new ArrayList<>();

   public Aluno(String matricula, String nome, int idade, Turma turma) {
      this.matricula = matricula;
      this.nome = nome;
      this.idade = idade;
      this.turma = turma;
   }

   public String getMatricula(){
      return matricula;
   }
   public String getNome(){
      return nome;
   }
   public void adicionarDisciplina(Disciplina disciplina){
      disciplinas.add(disciplina);
   }
   public void removerDisciplina(Disciplina disciplina){
      disciplinas.remove(disciplina);
   }

   public double calcularMedia() {
      double somaNotas = 0;
      double media = 0;
      for (Disciplina disciplina : disciplinas) {
         somaNotas += disciplina.getNota();
         media = somaNotas / disciplinas.size();
      }
      return media;
   }

   public void exibirDisciplinas() {
      System.out.print("DISCIPLINAS: ");
      for (Disciplina disciplina : disciplinas) {
         System.out.print(disciplina.getNome() + " ");
      }
   }
   public void exibirInformacoes(){
      System.out.println("MATRÍCULA: " + this.matricula);
      System.out.println("NOME: " + this.nome);
      System.out.println("IDADE: " + this.idade);
      System.out.println("TURMA: " + this.turma.getIdentificador());
      System.out.println("MÉDIA DO SEMESTRE: " + this.calcularMedia());
   }
}