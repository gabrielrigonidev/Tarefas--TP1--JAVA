import java.util.ArrayList;
import java.util.List;

public class Pedido {
   private int numero;
   private int numeroMesa;
   private double taxaEntrega;
   private List<ItemPedido> itens = new ArrayList<>();

   public Pedido(int numero) {
      this.numero = numero;
   }
   public double getTaxa() {
      return this.taxaEntrega;
   }
   public int getNumero() {
      return this.numero;
   }
   public void setNumero(int numero) {
      this.numero = numero;
   }
   public int getNumeroMesa() {
      return numeroMesa;
   }
   public void reservarMesa(int numeroMesa){
      this.numeroMesa = numeroMesa;
   }
   public void adicionarItem(ItemPedido item){
      this.itens.add(item);
   }

   public List<ItemPedido> getItens() {
      return this.itens;
   }

   public void removerItem(ItemPedido item){
      if(itens != null) {
         this.itens.remove(item);
      } else {
         System.out.println("Não há itens para remover");
      }
   }
   public void calcularValorTotal(){
      double soma = 0;
         for(ItemPedido item : this.itens){
            soma += (item.getPreco() * item.getQTD()) + getTaxa();
         }
   }
}