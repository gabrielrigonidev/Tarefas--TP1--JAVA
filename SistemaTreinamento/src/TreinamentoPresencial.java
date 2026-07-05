public class TreinamentoPresencial extends Treinamento{
   private final String localAcesso;

   public TreinamentoPresencial(int id, Instrutor nomeInstrutor, String linguagemEnsinada, String localAcesso) {
      super(id, nomeInstrutor, linguagemEnsinada);
      this.localAcesso = localAcesso;
   }
   public String getLocalAcesso() {
      return this.localAcesso;
   }
}
