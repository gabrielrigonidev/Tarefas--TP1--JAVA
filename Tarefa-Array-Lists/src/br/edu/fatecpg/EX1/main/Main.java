package br.edu.fatecpg.EX1.main;

import java.util.Objects;
import java.util.Scanner;
import br.edu.fatecpg.EX1.model.ListaTarefas;
import br.edu.fatecpg.EX1.model.Tarefa;
import br.edu.fatecpg.EX2.model.Pedido;

public class Main {
   private static final Scanner sc = new Scanner(System.in);
   private static final ListaTarefas listaTarefas = new ListaTarefas();

   public static void main(String[] args) {
      while (true) {
         System.out.println("Sistema de Gerenciamento de Tarefas em Java");
         System.out.println("Digite | 1 - Criar Tarefa / 2 - Marcar Tarefa como Concluída / 3 - Mostrar Tarefas / 4 - Remover Tarefas");
         int resposta = sc.nextInt();
         sc.nextLine();

         switch (resposta) {
            case 1:
               criarTarefa();
               break;
            case 2:
               marcarTarefaComoConcluida();
               break;
            case 3:
               listaTarefas.mostrarTarefas();
               break;
            case 4:
               removeTarefa();
               break;
            default:
               System.out.println("Opção inválida!");
               System.out.println("Digite | 1 - Criar Tarefa / 2 - Marcar Tarefa como Concluída / 3 - Mostrar Tarefas / 4 - Remover Tarefas");
               break;
         }
      }
   }

   private static void criarTarefa() {
      System.out.println("Digite o título da tarefa:");
      String titulo = sc.nextLine();
      System.out.println("Digite a descrição da tarefa:");
      String descricao = sc.nextLine();

      Tarefa tarefa = new Tarefa(titulo, descricao);
      listaTarefas.addTarefa(tarefa);
      System.out.println("Tarefa adicionada com sucesso!");
      System.out.println("------------------------------");
   }

   private static void marcarTarefaComoConcluida() {
      System.out.println("Digite o título da tarefa a ser marcada como concluída:");
      String titulo = sc.nextLine();
      for (Tarefa tarefa : listaTarefas.getTarefas()) {
         if (tarefa.getTitulo().equals(titulo)) {
            tarefa.setStatus(true);
            System.out.println("Tarefa marcada como concluída!");
            System.out.println("------------------------------");
            return;
         }
      }
      System.out.println("Tarefa não encontrada!");
   }

   private static void removeTarefa(){
      System.out.println("Digite o nome da tarefa a ser removido:");
      String tarefaRemover = sc.next();
      for (Tarefa tarefa : listaTarefas.getTarefas()) {
         if (Objects.equals(tarefa.getTitulo(), tarefaRemover)) {
            listaTarefas.removeTarefa(tarefa);
            System.out.println("Tarefa removida.");
            return;
         }
      }
      System.out.println("Tarefa não encontrada.");
   }
}