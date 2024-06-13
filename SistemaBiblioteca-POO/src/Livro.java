public class Livro {
   private String titulo;
   private String autor;
   private String isbn;
   private boolean disponibilidade;

   public Livro(String titulo, String autor, String isbn, boolean disponibilidade) {
      this.titulo = titulo;
      this.autor = autor;
      this.isbn = isbn;
      this.disponibilidade = disponibilidade;
   }
   public String getTitulo() {
      return this.titulo;
   }
   public boolean getDisponibilidade() {
      return this.disponibilidade;
   }
   public String getAutor() {
      return this.autor;
   }

   public void realizarEmprestimo(){
      if(this.disponibilidade == true){
         this.disponibilidade = false;
      } else {
         System.out.println("Livro Indisponível");
      }
   }

   public void devolverLivro(){
      if(this.disponibilidade == false){
         this.disponibilidade = true;
      } else {
         System.out.println("Livro não pode ser devolvido");
      }
   }

   public void exibirInformacoes(){
      System.out.println("Titulo: " + this.titulo);
      System.out.println("Autor: " + this.autor);
      System.out.println("ISBN: " + this.isbn);
      System.out.println("Disponibilidade: " + this.disponibilidade);
   }
}
