package br.edu.fatecpg.simuladoP2.view;
import br.edu.fatecpg.simuladoP2.controller.CarrinhoDeCompras;
//import br.edu.fatecpg.simuladoP2.model.ItemCarrinho;
import br.edu.fatecpg.simuladoP2.model.Produto;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        Produto prod1 = new Produto(1,"Celular", "Celular Top",500,10);
        Produto prod2 = new Produto(2,"PC", "XUXA",800,5);

        System.out.println("PRODUTOS: ");
        prod1.exibirInformacoes();
        prod2.exibirInformacoes();

        System.out.println("PREÇO ATUALIZADO: ");
        prod1.atualizarPreco(600);
        prod1.exibirInformacoes();

        //ItemCarrinho item = new ItemCarrinho(prod2,2);
        System.out.println("CARRINHO: ");
        carrinho.adicionarItem(prod1, 2);
        carrinho.adicionarItem(prod2, 4);
        carrinho.removerItem(prod1);
        carrinho.exibirCarrinho();
        System.out.println(carrinho.calcularTotal());
    }
}