package br.edu.fatecpg.view;

import br.edu.fatecpg.controller.Turma;
import br.edu.fatecpg.model.Aluno;
import br.edu.fatecpg.model.Disciplina;

public class Main {
   public static void main(String[] args) {
      Disciplina disciplina = new Disciplina("TP1",8);
      Disciplina disciplina1 = new Disciplina("WEB 2",9);
      Disciplina disciplina2 = new Disciplina("MATEMÁTICA",6.5);

      Turma DSM2 = new Turma("DSM2");
      Aluno aluno = new Aluno("1","Gabriel",19, DSM2);

      aluno.adicionarDisciplina(disciplina);
      aluno.adicionarDisciplina(disciplina1);
      aluno.adicionarDisciplina(disciplina2);
      aluno.removerDisciplina(disciplina2);

      disciplina.adicionarNota(10);
      DSM2.adicionarAlunos(aluno);

      aluno.exibirInformacoes();
      disciplina.exibirInformacoes();
      DSM2.buscarAlunos(aluno);
      System.out.println("MÉDIA DA TURMA: " + DSM2.calcularMediaTurma());
   }
}