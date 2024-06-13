package br.edu.fatecpg.controller;
import br.edu.fatecpg.model.Aluno;
import br.edu.fatecpg.model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class Turma {
   private String identificador;
   private List<Aluno> alunos = new ArrayList<>();

   public Turma(String identificador) {
      this.identificador = identificador;
   }
   public String getIdentificador() {
      return identificador;
   }

   public void adicionarAlunos(Aluno aluno) {
      alunos.add(aluno);
   }
   public void removerAlunos(Aluno aluno) {
      if(alunos != null) {
         alunos.remove(aluno);
      } else {
         System.out.println("Não há alunos p/ remover!");
      }
   }

   public void buscarAlunos(Aluno aluno) {
      for(Aluno alunoBusca : alunos) {
         if(alunoBusca.getMatricula().equals(aluno.getMatricula())){
            System.out.println("O Aluno " + alunoBusca.getNome() + " está na turma!");
         } else {
            System.out.println("O Aluno " + alunoBusca.getNome() + " não está na turma!");
         }
      }
   }
   public double calcularMediaTurma() {
      double somaMedias = 0;
      double media = 0;
      for (Aluno aluno : alunos) {
         somaMedias += aluno.calcularMedia();
         media = somaMedias / alunos.size();
      }
      return media;
   }
}
