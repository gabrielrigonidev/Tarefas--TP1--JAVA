package br.edu.fatecpg.EX2.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
   private int id;
   private List<String> itens;
   private boolean status;

   public Pedido(int id, List<String> itens) {
      this.id = id;
      this.itens = itens;
      this.status = false;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public List<String> getItens() {
      return itens;
   }

   public void setItens(List<String> itens) {
      this.itens = itens;
   }

   public boolean getStatus() {
      return status;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }

   public void marcarComoEntregue() {
      this.status = true;
   }

   @Override
   public String toString() {
      String statusString;
      if (status) {
         statusString = "Entregue";
      } else {
         statusString = "Em andamento";
      }
      return "ID: " + id + ", Itens: " + itens + ", Status: " + statusString;
   }
}