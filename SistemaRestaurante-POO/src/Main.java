import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
   public static void main(String[] args){
      try (var connection = DB.connect()) {
         if (connection != null) {
            System.out.println("Conectado");
            Restaurante restaurante = new Restaurante();
            ItemPedido item1 = new ItemPedido("Prato 119",5,44.0);
            ItemPedido item2 = new ItemPedido("Prato 2",99,99.5);
            Pedido pedido = new Pedido(1);
            pedido.reservarMesa(35);
//            pedido.adicionarItem(item1);
//            pedido.adicionarItem(item2);

//            cadastrarPedido(pedido);
            atualizarPedido(pedido);
//            deletarPedido(2);
         }
      } catch (SQLException e) {
         System.err.println("Erro ao conectar ou cadastrar pedido: " + e.getMessage());
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   public static void cadastrarPedido(Pedido pedido) {
      String queryPedido = "INSERT INTO pedido(numero, numeroMesa, taxaEntrega) VALUES (?, ?, ?)";
      String queryItem = "INSERT INTO item_pedido(numeroPedido, nomeDoPrato, quantidade, precoUnitario) VALUES (?, ?, ?, ?)";

      try (Connection connection = DB.connect()) {
         connection.setAutoCommit(false);
         try (PreparedStatement stmtPedido = connection.prepareStatement(queryPedido)) {
            stmtPedido.setInt(1, pedido.getNumero());
            stmtPedido.setInt(2, pedido.getNumeroMesa());
            stmtPedido.setDouble(3, pedido.getTaxa());
            stmtPedido.executeUpdate();
         }
         try (PreparedStatement stmtItem = connection.prepareStatement(queryItem)) {
            for (ItemPedido item : pedido.getItens()) {
               stmtItem.setInt(1, pedido.getNumero());
               stmtItem.setString(2, item.getNomeDoPrato());
               stmtItem.setInt(3, item.getQTD());
               stmtItem.setDouble(4, item.getPreco());
               stmtItem.addBatch();
            }
            stmtItem.executeBatch();
         }
         connection.commit();
         System.out.println("Pedido " + pedido.getNumero() + " criado com sucesso!");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void atualizarPedido(Pedido pedido){
      try (Connection connection = DB.connect()) {
         connection.setAutoCommit(false);
         String updatePedidoQuery = "UPDATE pedido SET numeroMesa = ?, taxaEntrega = ? WHERE numero = ?";
         try (PreparedStatement stmtPedido = connection.prepareStatement(updatePedidoQuery)) {
            stmtPedido.setInt(1, pedido.getNumeroMesa());
            stmtPedido.setDouble(2, pedido.getTaxa());
            stmtPedido.setInt(3, pedido.getNumero());
            stmtPedido.executeUpdate();
         }
         String updateItemQuery = "UPDATE item_pedido SET nomeDoPrato = ?, quantidade = ?, precoUnitario = ? WHERE numeroPedido = ?";
         try (PreparedStatement stmtItem = connection.prepareStatement(updateItemQuery)) {
            for (ItemPedido item : pedido.getItens()) {
               stmtItem.setString(1, item.getNomeDoPrato());
               stmtItem.setInt(2, item.getQTD());
               stmtItem.setDouble(3, item.getPreco());
               stmtItem.setInt(4, pedido.getNumero());
               stmtItem.addBatch();
            }
            stmtItem.executeBatch();
         }
         connection.commit();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void deletarPedido(int numeroPedido){
      try (Connection connection = DB.connect()) {
         String deleteItensQuery = "DELETE FROM item_pedido WHERE numeroPedido = ?";
         try (PreparedStatement stmtItens = connection.prepareStatement(deleteItensQuery)) {
            stmtItens.setInt(1, numeroPedido);
            stmtItens.executeUpdate();
         }
         String deletePedidoQuery = "DELETE FROM pedido WHERE numero = ?";
         try (PreparedStatement stmtPedido = connection.prepareStatement(deletePedidoQuery)) {
            stmtPedido.setInt(1, numeroPedido);
            stmtPedido.executeUpdate();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}