public class TreinamentoOnline extends Treinamento {
   private final String linkAcesso;

   public TreinamentoOnline(int id, Instrutor nomeInstrutor, String linguagemEnsinada, String linkAcesso) {
      super(id, nomeInstrutor, linguagemEnsinada);
      this.linkAcesso = linkAcesso;
   }
   public String getLinkAcesso() {
      return this.linkAcesso;
   }
}