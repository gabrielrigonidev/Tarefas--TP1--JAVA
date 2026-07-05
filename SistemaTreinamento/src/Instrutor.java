public class Instrutor {
   private String nomeInstrutor;
   private boolean disponibilidade;

   public Instrutor(String nomeInstrutor, boolean disponibilidade) {
      this.nomeInstrutor = nomeInstrutor;
      this.disponibilidade = disponibilidade;
   }

   public String getNomeInstrutor() {
      return this.nomeInstrutor;
   }
   public boolean verificarDisponibilidade(){
      if(getDisponibilidade()){
         return true;
      } else {
         return false;
      }
   }

   public boolean getDisponibilidade() {
      return this.disponibilidade;
   }
}