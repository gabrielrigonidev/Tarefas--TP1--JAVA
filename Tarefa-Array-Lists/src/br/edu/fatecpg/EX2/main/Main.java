package br.edu.fatecpg.EX2.main;

import br.edu.fatecpg.EX2.model.ListaPedidos;
import br.edu.fatecpg.EX2.model.Pedido;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
   private static final Scanner sc = new Scanner(System.in);
   private static final ListaPedidos listaPedidos = new ListaPedidos();

   public static void main(String[] args) {
      while (true) {
         System.out.println("Sistema de Gerenciamento de Pedidos em Java");
         System.out.println("1 - Adicionar Pedido / 2 - Remover Pedido / 3 - Mostrar Pedidos / 4 - Sair");
         int opcao = sc.nextInt();
         sc.nextLine();

         switch (opcao) {
            case 1:
               adicionarPedido();
               break;
            case 2:
               removerPedido();
               break;
            case 3:
               exibirPedidos();
               break;
            case 4:
               break;
            default:
               System.out.println("Opção inválida. Tente novamente.");
               System.out.println("1 - Adicionar Pedido / 2 - Remover Pedido / 3 - Mostrar Pedidos / 4 - Sair");
               break;
         }
      }
   }

   private static void adicionarPedido() {
      System.out.println("Digite o ID do pedido:");
      int id = sc.nextInt();
      sc.nextLine();

      List<String> itens = new ArrayList<>();
      while (true) {
         System.out.println("Digite um item para o pedido (ou 'SAIR' para terminar):");
         String item = sc.nextLine();
         if (item.equalsIgnoreCase("SAIR")) {
            break;
         }
         itens.add(item);
      }

      Pedido pedido = new Pedido(id, itens);
      listaPedidos.adicionarPedido(pedido);
   }

   private static void removerPedido() {
      System.out.println("Digite o ID do pedido a ser removido:");
      int idRemover = sc.nextInt();
      sc.nextLine();
      for (Pedido pedido : listaPedidos.getPedidos()) {
         if (pedido.getId() == idRemover) {
            listaPedidos.removerPedido(pedido);
            System.out.println("Pedido removido.");
            return;
         }
      }
      System.out.println("Pedido não encontrado.");
   }

   private static void exibirPedidos() {
      System.out.println("Pedidos em andamento:");
      listaPedidos.exibirPedidosEmAndamento();
   }
}
