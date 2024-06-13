package br.edu.fatecpg.simuladoP2.model;
public class Produto {
    private int id;
    private String nome;
    private String desc;
    private double preco;
    private int qtd;

    public Produto(int id, String nome, String desc, double preco, int qtd) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }

    public int getId(){
        return this.id;
    }
    public double getPreco(){
        return this.preco;
    }
    public String getNome(){
        return this.nome;
    }
    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
    }
    public void adicionarEstoque(int qtd) {
        this.qtd +=qtd;
    }
    public void removerEstoque(int qtd) {
        this.qtd -=qtd;
    }
    public boolean verificarDisponibilidade(int qtd){
        return this.qtd >= qtd;
    }
    public void exibirInformacoes(){
        System.out.println("ID: " + this.id);
        System.out.println("NOME: " + this.nome);
        System.out.println("PREÇO: " + this.preco);
        System.out.println("QTD: " + this.qtd);
    }
}