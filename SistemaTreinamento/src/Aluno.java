public class Aluno {
   private final String id;
   private final String nome;
   private double notaFinal;
   private double horas;

   public Aluno(String id, String nome, double notaFinal) {
      this.id = id;
      this.nome = nome;
      this.notaFinal = notaFinal;
   }
   public String getId() {
      return this.id;
   }
   public String getNome() {
      return this.nome;
   }
   public double getNotaFinal() {
      return this.notaFinal;
   }
   public double getHoras() {
      return this.horas;
   }
   public void setHoras(double horasDeTreinamentoAcumuladas) {
      this.horas += horasDeTreinamentoAcumuladas;
   }
}