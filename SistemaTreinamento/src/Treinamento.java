import java.util.ArrayList;
import java.util.List;

public class Treinamento {
   private int id;
   private Instrutor instrutor;
   private String linguagemEnsinada;
   private double cargaHoraria;
   private boolean status = false;
   private List<Aluno> alunos = new ArrayList<>();

   public Treinamento(int id, Instrutor nomeInstrutor, String linguagemEnsinada) {
      this.id = id;
      this.instrutor = nomeInstrutor;
      this.linguagemEnsinada = linguagemEnsinada;
   }

   public void setStatusTreinamento() {
      boolean statusInstrutor = instrutor.verificarDisponibilidade();
      if(statusInstrutor){
         System.out.println("O Evento irá ocorrer! Instrutor Disponível");
         this.status = true;
      } else {
         System.out.println("O Evento não irá ocorrer! Instrutor Indisponível");
         this.status = false;
      }
   }
   public void definirCargaHoraria(double novaCargaHoraria){
      this.cargaHoraria = novaCargaHoraria; //40
   }
   public double getCargaHoraria(){
      return this.cargaHoraria; //40
   }
   public void setHorasParaAlunos(Aluno aluno){
      aluno.setHoras(getCargaHoraria()); //40
   }
   public void adicionarAlunos(Aluno aluno) {
      if(verificarUltimoTreinamento(aluno)){
         this.alunos.add(aluno);
         setHorasParaAlunos(aluno); //40
         System.out.println("Aluno" + aluno.getNome() + "Adicionado!");
      } else {
         System.out.println("Não foi possível adicionar o aluno!");
      }
   }

   public void removerAlunos(Aluno aluno) {
      this.alunos.remove(aluno);
      System.out.println("Aluno Removido!");
   }
   public double calcularMediaAlunos() {
      double somaMedias = 0;
      double media = 0;
      for (Aluno aluno : alunos) {
         somaMedias += aluno.getNotaFinal();
         media = somaMedias / alunos.size();
      }
      return media;
   }
   public void listarAlunos() {
      for (Aluno aluno : alunos) {
         System.out.println("Nome: " + aluno.getNome());
         System.out.println("Horas Acumuladas: " + aluno.getHoras());
      }
   }

   public boolean verificarUltimoTreinamento(Aluno aluno){
//      int doisMeses = 1460;
      if(aluno.getHoras() >= 80){
         System.out.println("O aluno " + aluno.getNome() + " não pode se inscrever! Carga Horária de 80 horas batida");
         return false;
      } else {
         System.out.println("O aluno " + aluno.getNome() + " pode se inscrever! ");
         return true;
      }
   }

   public int getId() {
      return id;
   }
   public Instrutor getInstrutor() {
      return instrutor;
   }
   public String getLinguagemEnsinada() {
      return linguagemEnsinada;
   }
   public boolean getStatus() {
      return status;
   }
}