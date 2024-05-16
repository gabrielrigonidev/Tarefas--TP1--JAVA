package br.edu.fatecpg.EX1.model;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
   private List<Tarefa> tarefas = new ArrayList<>();

   public ListaTarefas(){}

   public ListaTarefas(List<Tarefa> listaTarefas) {
      this.tarefas = listaTarefas;
   }

   public void addTarefa(Tarefa tarefa){
      this.tarefas.add(tarefa);
   }

   public void removeTarefa(Tarefa tarefa){
      this.tarefas.remove(tarefa);
   }

   public List<Tarefa> getTarefas() {
      return tarefas;
   }

   public void mostrarTarefas(){
      for (Tarefa tarefa : tarefas) {
         System.out.println("------------------------------");
         System.out.println(tarefa);
         System.out.println("------------------------------");
      }
   }
}


