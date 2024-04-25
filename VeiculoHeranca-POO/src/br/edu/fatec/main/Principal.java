package br.edu.fatec.main;
import br.edu.fatec.model.*;

public class Principal {
   public static void main(String[] args) {

      Veiculo veiculo = new Veiculo("fff3030", "honda", "FIT");
      System.out.println(veiculo);

      Carro carro = new Carro("fff3030", "honda", "civic", 2, true);
      System.out.println(carro);
      carro.ligar();
      carro.desligar();
      carro.drift();

      Moto moto = new Moto("fff3030", "honda", "civic", true);
      System.out.println(moto);
      moto.ligar();
      moto.desligar();
      moto.empinar();

      Caminhao caminhao = new Caminhao("fff3030", "honda", "civic", 2000);
      System.out.println(caminhao);
      caminhao.ligar();
      caminhao.desligar();
      caminhao.acoplarReboque();
   }
}
