package br.edu.fatecpg.EX2.model;

import java.util.ArrayList;
import java.util.List;

public class ListaPedidos {
   private List<Pedido> pedidos;

   public ListaPedidos() {
      this.pedidos = new ArrayList<>();
   }

   public List<Pedido> getPedidos() {
      return pedidos;
   }

   public void setPedidos(List<Pedido> pedidos) {
      this.pedidos = pedidos;
   }

   public void adicionarPedido(Pedido pedido) {
      pedidos.add(pedido);
   }

   public void removerPedido(Pedido pedido) {
      pedidos.remove(pedido);
   }

   public void exibirPedidosEmAndamento() {
      for (Pedido pedido : pedidos) {
         if (!pedido.getStatus()) {
            System.out.println(pedido);
         }
      }
   }
}