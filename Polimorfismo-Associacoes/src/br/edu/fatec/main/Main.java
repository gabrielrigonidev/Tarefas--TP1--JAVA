package br.edu.fatec.main;
import br.edu.fatec.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//      1º Pessoa - Endereço (Composição -> Com Parte Todo);
        Pessoa pessoa = Pessoa.lerPessoa(sc);
        System.out.println(pessoa);

//      2º Disciplina - Aluno (Agregação -> Sem Parte Todo)
        Disciplina disciplina = Disciplina.lerDisciplina(sc);
//        Linhas adicionais, caso queira adicionar o Aluno no ToString
//        Aluno aluno = Aluno.lerAluno(sc);
//        disciplina.setAluno(aluno);
        System.out.println(disciplina);

//      3º Compra - Cupom (Dependência -> Depende de)
        Compra compra = Compra.lerDadosCompra(sc);
        Cupom cupom = Cupom.lerDadosCupom(sc);
        compra.finalizar(cupom);
        System.out.println(compra);
    }
}
