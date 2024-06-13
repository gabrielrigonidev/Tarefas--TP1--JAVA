public class Main {
   public static void main(String[] args) {
      Livro livro1 = new Livro("Java10", "Rigoni", "1111-2222",true);
      livro1.exibirInformacoes();
      livro1.realizarEmprestimo();
      livro1.exibirInformacoes();
      livro1.devolverLivro();

      Biblioteca fatec = new Biblioteca();
      fatec.adicionarLivro(livro1);
      fatec.buscarLivro("AlAN");
      fatec.exibirLivros();
      fatec.removerLivro(livro1);
   }
}