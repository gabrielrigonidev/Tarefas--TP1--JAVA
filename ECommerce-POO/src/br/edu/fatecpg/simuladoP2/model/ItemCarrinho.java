package br.edu.fatecpg.simuladoP2.model;
public class ItemCarrinho {
    private Produto produto;
    private int qtd;

    public ItemCarrinho(Produto produto, int qtd){
        this.produto = produto;
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }
    public int getQtd() {
        return qtd;
    }
    public double calcularValor(){
        return produto.getPreco() * this.qtd;
    }
    public void mostraItem(){
        System.out.println("PRODUTO: " + this.produto.getNome());
        System.out.println("QUANTIDADE: " + this.qtd);
    }
}
