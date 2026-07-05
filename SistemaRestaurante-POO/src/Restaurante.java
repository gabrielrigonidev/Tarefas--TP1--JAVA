import java.util.ArrayList;
import java.util.List;

public class Restaurante {
   private List<Pedido> pedidos = new ArrayList<>();

   public void adicionarPedido(Pedido pedido) {
      this.pedidos.add(pedido);
   }

   public void removerPedido(Pedido pedido) {
      if (pedidos != null) {
         for (Pedido pedidoBusca : this.pedidos) {
            if (pedidoBusca.equals(pedido)) {
               this.pedidos.remove(pedido);
            }
         }
      }
   }
   public void buscarPedido(int numero) {
      if (pedidos != null) {
         for (Pedido pedidoBusca : this.pedidos) {
            if (pedidoBusca.getNumero() == numero) {
               System.out.println("Seu pedido " + pedidoBusca + " está aqui!");
            }
         }
      }
   }
   public void exibirPedido() {
      for (Pedido pedido : this.pedidos) {
         System.out.println(pedido.getNumero());
      }
   }
}