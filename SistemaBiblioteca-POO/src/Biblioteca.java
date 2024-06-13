import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
   private final List<Livro> livros = new ArrayList<>();

   public void adicionarLivro(Livro livro) {
      if(livro.getDisponibilidade()){
         this.livros.add(livro);
         System.out.println("Livro adicionado com sucesso!");
      } else {
         System.out.println("Não foi possível adicionar um livro!");
      }
   }
   public void removerLivro(Livro livro) {
      if(livro.getDisponibilidade()){
         this.livros.remove(livro);
         System.out.println("Livro removido com sucesso!");
      } else {
         System.out.println("Não foi possível remover o livro!");
      }
   }
   public void exibirLivros(){
      System.out.println("--------------------------------------------");
      for (Livro livro : this.livros) {
         livro.exibirInformacoes();
         System.out.println("--------------------------------------------");
      }
   }
   public void buscarLivro(String busca){
      for(Livro livro : this.livros){
         if(busca.equals(livro.getTitulo()) || busca.equals(livro.getAutor())){
            System.out.println("O livro está disponível!");
         } else {
            System.out.println("O livro não está na biblioteca");
         }
      }
   }
}
