import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TreinamentoDAO {
   public static void criarTabelas() {
      String queryTabelaTreinamento = "CREATE TABLE IF NOT EXISTS treinamentos (numero INT PRIMARY KEY AUTO_INCREMENT,instrutor VARCHAR(100) NOT NULL,linguagemEnsinada VARCHAR(100) NOT NULL,cargaHoraria DOUBLE NOT NULL,statusTreinamento BOOLEAN NOT NULL);".formatted();
      String queryTabelaAluno = "CREATE TABLE IF NOT EXISTS aluno (id INT PRIMARY KEY,nome VARCHAR(100) NOT NULL,notaFinal VARCHAR(100) NOT NULL,horas DOUBLE);".formatted();
      String queryTreinamentosOnline = "CREATE TABLE IF NOT EXISTS treinamentos_online (" +
              "numero INT PRIMARY KEY," +
              "linkAcesso VARCHAR(100) NOT NULL," +
              "FOREIGN KEY (numero) REFERENCES treinamentos(numero) ON DELETE CASCADE" +
              ");";

      String queryTreinamentosPresenciais = "CREATE TABLE IF NOT EXISTS treinamentos_presenciais (" +
              "numero INT PRIMARY KEY," +
              "localAcesso VARCHAR(100) NOT NULL," +
              "FOREIGN KEY (numero) REFERENCES treinamentos(numero) ON DELETE CASCADE" +
              ");";

      try (Connection connection = DB.connect()) {
         connection.setAutoCommit(false);
         try (PreparedStatement stmtTabelasTreinamento = connection.prepareStatement(queryTabelaTreinamento)) {
            stmtTabelasTreinamento.executeUpdate();
         }

         try (PreparedStatement stmtTabelasAluno = connection.prepareStatement(queryTabelaAluno)) {
            stmtTabelasAluno.executeUpdate();
         }

         try (PreparedStatement stmtOnline = connection.prepareStatement(queryTreinamentosOnline)) {
            stmtOnline.executeUpdate();
         }

         try (PreparedStatement stmtPresenciais = connection.prepareStatement(queryTreinamentosPresenciais)) {
            stmtPresenciais.executeUpdate();
         }

         connection.commit();
         System.out.println("Tabelas criadas com sucesso!");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void criarTreinamento(Treinamento treinamento) {
      String queryTreinamento = "INSERT INTO treinamentos(numero, instrutor, linguagemEnsinada, cargaHoraria, statusTreinamento) VALUES (?, ?, ?, ?, ?)";
      String queryTreinamentoOnline = "INSERT INTO treinamentos_online(numero, linkAcesso) VALUES (?, ?)";
      String queryTreinamentoPresencial = "INSERT INTO treinamentos_presenciais(numero, localAcesso) VALUES (?, ?)";

      try (Connection connection = DB.connect()) {
         connection.setAutoCommit(false);
         try (PreparedStatement stmtTreinamento = connection.prepareStatement(queryTreinamento)) {
            stmtTreinamento.setInt(1, treinamento.getId());
            stmtTreinamento.setString(2, treinamento.getInstrutor().getNomeInstrutor());
            stmtTreinamento.setString(3, treinamento.getLinguagemEnsinada());
            stmtTreinamento.setDouble(4, treinamento.getCargaHoraria());
            stmtTreinamento.setBoolean(5, treinamento.getStatus());
            stmtTreinamento.executeUpdate();
         }
         if (treinamento instanceof TreinamentoOnline) {
            try (PreparedStatement stmtOnline = connection.prepareStatement(queryTreinamentoOnline)) {
               TreinamentoOnline treinamentoOnline = (TreinamentoOnline) treinamento;
               stmtOnline.setInt(1, treinamento.getId());
               stmtOnline.setString(2, treinamentoOnline.getLinkAcesso());
               stmtOnline.executeUpdate();
            }
         } else if (treinamento instanceof TreinamentoPresencial) {
            try (PreparedStatement stmtPresencial = connection.prepareStatement(queryTreinamentoPresencial)) {
               TreinamentoPresencial treinamentoPresencial = (TreinamentoPresencial) treinamento;
               stmtPresencial.setInt(1, treinamento.getId());
               stmtPresencial.setString(2, treinamentoPresencial.getLocalAcesso());
               stmtPresencial.executeUpdate();
            }
         }

         connection.commit();
         System.out.println("Treinamento " + treinamento.getId() + " criado com sucesso!");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void atualizarTreinamento(Treinamento treinamento) {
      String queryAtualizarTreinamento = "UPDATE treinamentos SET instrutor = ?, linguagemEnsinada = ?, cargaHoraria = ?, statusTreinamento = ? WHERE numero = ?";
      String queryAtualizarTreinamentoOnline = "UPDATE treinamentos_online SET linkAcesso = ? WHERE numero = ?";
      String queryAtualizarTreinamentoPresencial = "UPDATE treinamentos_presenciais SET localAcesso = ? WHERE numero = ?";

      try (Connection connection = DB.connect()) {
         connection.setAutoCommit(false);
         try (PreparedStatement stmtTreinamento = connection.prepareStatement(queryAtualizarTreinamento)) {
            stmtTreinamento.setString(1, treinamento.getInstrutor().getNomeInstrutor());
            stmtTreinamento.setString(2, treinamento.getLinguagemEnsinada());
            stmtTreinamento.setDouble(3, treinamento.getCargaHoraria());
            stmtTreinamento.setBoolean(4, treinamento.getStatus());
            stmtTreinamento.setInt(5, treinamento.getId());
            stmtTreinamento.executeUpdate();
         }

         if (treinamento instanceof TreinamentoOnline) {
            TreinamentoOnline treinamentoOnline = (TreinamentoOnline) treinamento;
            try (PreparedStatement stmtOnline = connection.prepareStatement(queryAtualizarTreinamentoOnline)) {
               stmtOnline.setString(1, treinamentoOnline.getLinkAcesso());
               stmtOnline.setInt(2, treinamentoOnline.getId());
               stmtOnline.executeUpdate();
            }
         } else if (treinamento instanceof TreinamentoPresencial) {
            TreinamentoPresencial treinamentoPresencial = (TreinamentoPresencial) treinamento;
            try (PreparedStatement stmtPresencial = connection.prepareStatement(queryAtualizarTreinamentoPresencial)) {
               stmtPresencial.setString(1, treinamentoPresencial.getLocalAcesso());
               stmtPresencial.setInt(2, treinamentoPresencial.getId());
               stmtPresencial.executeUpdate();
            }
         }

         connection.commit();
         System.out.println("Treinamento " + treinamento.getId() + " atualizado com sucesso!");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void deletarTreinamento(int treinamentoId) {
      String queryDeletarTreinamentoOnline = "DELETE FROM treinamentos_online WHERE numero = ?";
      String queryDeletarTreinamentoPresencial = "DELETE FROM treinamentos_presenciais WHERE numero = ?";
      String queryDeletarTreinamento = "DELETE FROM treinamentos WHERE numero = ?";

      try (Connection connection = DB.connect()) {
         connection.setAutoCommit(false);
         try (PreparedStatement stmtOnline = connection.prepareStatement(queryDeletarTreinamentoOnline)) {
            stmtOnline.setInt(1, treinamentoId);
            stmtOnline.executeUpdate();
         }
         try (PreparedStatement stmtPresencial = connection.prepareStatement(queryDeletarTreinamentoPresencial)) {
            stmtPresencial.setInt(1, treinamentoId);
            stmtPresencial.executeUpdate();
         }
         try (PreparedStatement stmtTreinamento = connection.prepareStatement(queryDeletarTreinamento)) {
            stmtTreinamento.setInt(1, treinamentoId);
            stmtTreinamento.executeUpdate();
         }
         connection.commit();
         System.out.println("Treinamento " + treinamentoId + " deletado com sucesso!");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void inserirAluno(Aluno aluno){
      String queryAluno = "INSERT INTO aluno(id, nome, notaFinal, horas) VALUES (?, ?, ?, ?)";
      try (Connection connection = DB.connect()) {
         try (PreparedStatement stmtAluno = connection.prepareStatement(queryAluno)) {
            stmtAluno.setString(1, aluno.getId());
            stmtAluno.setString(2, aluno.getNome());
            stmtAluno.setDouble(3, aluno.getNotaFinal());
            stmtAluno.setDouble(4, aluno.getHoras());
            stmtAluno.executeUpdate();
         }
         System.out.println("Aluno inserido com sucesso!");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void atualizarAluno(Aluno aluno){
      String updateAlunoQuery = "UPDATE aluno SET nome = ?, notaFinal = ? WHERE id = ?";
      try (Connection connection = DB.connect()) {
         try (PreparedStatement stmtAluno = connection.prepareStatement(updateAlunoQuery)) {
            stmtAluno.setString(1, aluno.getNome());
            stmtAluno.setDouble(2, aluno.getNotaFinal());
            stmtAluno.setString(3, aluno.getId());
            stmtAluno.executeUpdate();
         }
         System.out.println("Aluno atualizado com sucesso!");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void deletarAluno(Aluno aluno){
      String queryAluno = "DELETE FROM aluno WHERE id = ?";
      try (Connection connection = DB.connect()) {
         try (PreparedStatement stmtAluno = connection.prepareStatement(queryAluno)) {
            stmtAluno.setString(1, aluno.getId());
            stmtAluno.executeUpdate();
         }
         System.out.println("Aluno excluído com sucesso!");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}