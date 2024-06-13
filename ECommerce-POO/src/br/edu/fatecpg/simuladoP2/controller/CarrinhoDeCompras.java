package br.edu.fatecpg.simuladoP2.controller;
import br.edu.fatecpg.simuladoP2.model.ItemCarrinho;
import br.edu.fatecpg.simuladoP2.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private final List<ItemCarrinho> itens = new ArrayList<>();
    public void adicionarItem(Produto produto, int qtd){
        if(produto.verificarDisponibilidade(qtd)){
            ItemCarrinho itemC = new ItemCarrinho(produto, qtd);
            this.itens.add(itemC);
            produto.removerEstoque(qtd);
        } else {
            System.out.println("Quantidade Insuficiente!");
        }
    }
    public void removerItem(Produto produto){
        ItemCarrinho itemParaRemover = null;
        for(ItemCarrinho item : this.itens){
            if(item.getProduto().getId() == produto.getId()){
                itemParaRemover = item;
                produto.adicionarEstoque(item.getQtd());
            }
        }
        if(itemParaRemover == null){
            System.out.println("Não há produtos com esse nome!");
        } else {
            this.itens.remove(itemParaRemover);
        }
    }
    public double calcularTotal(){
        double total = 0;
        for(ItemCarrinho item : this.itens){
            total += item.calcularValor();
        }
        return total;
    }
    public void exibirCarrinho(){
        for(ItemCarrinho item : this.itens){
            item.mostraItem();
        }
    }
}