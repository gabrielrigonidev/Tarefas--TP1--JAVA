import java.sql.SQLException;

public class Main {
   public static void main(String[] args) {
      try (var connection = DB.connect()) {
         if (connection != null) {
            System.out.println("Conectado");
            Instrutor instrutor = new Instrutor("Alessandro", true);
            Instrutor instrutor1 = new Instrutor("Eulaliane", true);
            TreinamentoOnline JavaClass = new TreinamentoOnline(1, instrutor,"Java", "link.com.br");
            TreinamentoPresencial PHPClass = new TreinamentoPresencial(2, instrutor1,"PHP", "Fatec PG");

            Aluno aluno1 = new Aluno("1", "Gabriel", 8);
            Aluno aluno2 = new Aluno("2", "Bruno", 6);
            Aluno aluno3 = new Aluno("3", "Alan", 10);

            instrutor.verificarDisponibilidade();
            JavaClass.setStatusTreinamento();
            JavaClass.definirCargaHoraria(40);

            TreinamentoDAO.criarTabelas();
//          TreinamentoDAO.criarTreinamento(JavaClass);

            instrutor1.verificarDisponibilidade();
            PHPClass.setStatusTreinamento();
            PHPClass.definirCargaHoraria(20);

            JavaClass.adicionarAlunos(aluno1);
            JavaClass.adicionarAlunos(aluno2);
            PHPClass.adicionarAlunos(aluno2);
            JavaClass.adicionarAlunos(aluno3);

//            TreinamentoDAO.inserirAluno(aluno1);
//            TreinamentoDAO.inserirAluno(aluno2);
//            TreinamentoDAO.inserirAluno(aluno3);
            TreinamentoDAO.atualizarAluno(aluno2);
            JavaClass.listarAlunos();
            TreinamentoDAO.deletarAluno(aluno3);

            System.out.println("Média: " + JavaClass.calcularMediaAlunos());
         }
      } catch (SQLException e) {
         System.err.println("Erro ao conectar: " + e.getMessage());
      }
   }
}