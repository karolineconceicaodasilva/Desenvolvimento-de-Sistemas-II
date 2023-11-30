package com.example;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
    
        Scanner teclado = new Scanner(System.in);

        System.out.println();
        System.out.println("*************************************");
        System.out.println("*************************************");
        System.out.println("*************Sistema IENH************");
        System.out.println("*************************************");
        System.out.println("*************************************");
        System.out.println();

        System.out.println();
        System.out.println("Opções do sistema:");
        System.out.println("1 - Exibir todos os alunos");
        System.out.println("2 - Exibir todos os alunos com excesso de peso");
        System.out.println("3 - Buscar aluno pelo id");
        System.out.println("4 - Buscar aluno pelo nome");
        System.out.println("5 - Excluir aluno pelo id");
        System.out.println("6 - Inserir aluno");
        System.out.println("7 - Atualizar aluno");
        System.out.println("Qualquer outra tecla - Finalizar o programa");
        System.out.println();

        System.out.println("Informe sua opção:");
        int opcao = teclado.nextInt();

        if(opcao == 1){
            BancoDados.consultaTodosAlunos();
        }

        if(opcao == 2){
            BancoDados.consultaTodosAlunosComExcessoDePeso();   
        }

        if(opcao == 3){
            BancoDados.buscarAlunoPeloId();
        }

        if(opcao == 4){
            BancoDados.buscarAlunoPeloNome();
        }

        if(opcao == 5){
            BancoDados.excluirAlunoPeloId();
        }

        if(opcao == 6){
            BancoDados.inserirAluno();
        }

        if(opcao == 7){
            BancoDados.atualizarAluno();
        }

        System.out.println();
        System.out.println("Bye!!!!");
        System.out.println();

    }

}