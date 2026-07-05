import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidosDAO {

   public void salvar(Pedido pedido){
      String queryPedido = "INSERT INTO pedido(numero, numeroMesa, taxaEntrega) VALUES (?, ?, ?)";
      String queryItem = "INSERT INTO item_pedido(item_numero, nomeDoPrato, quantidade, precoUnitario) VALUES (?, ?, ?, ?)";

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
}
