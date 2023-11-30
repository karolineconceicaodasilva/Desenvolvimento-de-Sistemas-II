
package com.example.service;

import java.util.List;
import java.util.Scanner;

import com.example.model.Produto;
import com.example.repository.ProdutoRepository;

public class ProdutoService {

    ProdutoRepository produtoRepository = new ProdutoRepository();

    public void menuProdutos() {
        Scanner teclado = new Scanner(System.in);

        int opcaoMenu;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("MENU PRODUTOS");
            System.out.println("**************");
            System.out.println();
            System.out.println("Esse é menu de opções que você tem para a tabela de Produtos!");
            System.out.println("Opção 1- Criar");
            System.out.println("Opção 2- Ler todos os Produtos");
            System.out.println("Opção 3- Ler os Produtos pelo número de id");
            System.out.println("Opção 4- Atualizar");
            System.out.println("Opção 5- Deletar");
            System.out.println("Opção 6- Voltar ao inicio do Sistema");
            System.out.println();
            System.out.println("Gostaria acessar alguma dessas opções?\n" + "Digita a opção desejada:");
            opcaoMenu = teclado.nextInt();

            switch (opcaoMenu) {

                case 1:
                    this.criarProdutos();
                    break;

                case 2:
                    this.listarProdutos();
                    break;

                case 3:
                    this.buscarProdutosId();
                    break;

                case 4:
                    this.alterarProdutosId();
                    break;

                case 5:
                    this.deletarProdutosID();
                    break;

                case 6:
                    break;

                default:
                    break;
            }

        } while (opcaoMenu > 0 && opcaoMenu < 6);
    }

    public void criarProdutos() {

        Scanner tecladoCriar = new Scanner(System.in);

        String nome;
        String descricao;
        double valor;
        int quantidadeEstoque;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("NOVO PRODUTO");
            System.out.println("**************");
            System.out.println();

            System.out.println("Informe o nome:");
            nome = tecladoCriar.nextLine();

            System.out.println("Informe a descrição:");
            descricao = tecladoCriar.nextLine();

            System.out.println("Informe o valor)");
            valor = tecladoCriar.nextDouble();

            System.out.println("Informe a quantidade que tem em estoque");
            quantidadeEstoque = tecladoCriar.nextInt();

            produtoRepository.criarProdutos(nome, descricao, valor, quantidadeEstoque);

            System.out.println("Gostaria de voltar ao menu anterior ou inserir outro produto?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para inserir um novo produto!");
            String simOuNao = tecladoCriar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void listarProdutos() {

        Scanner tecladoListar = new Scanner(System.in);

        String simOuNao;
        boolean voltar = false;

        do {
            System.out.println();
            System.out.println("**************");
            System.out.println("BUSCA DE TODOS OS PRODUTOS");
            System.out.println("**************");
            System.out.println();

            produtoRepository.listarProdutos();
            System.out.println("Gostaria de voltar ao menu anterior ou buscar os produtos?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para buscar todos os produtos novamente!");
            simOuNao = tecladoListar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public List<Produto> listarProdutosParaPedidos() {

        return produtoRepository.listarProdutosParaPedidos();

    }

    public void buscarProdutosId() {

        Scanner tecladoBuscar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("BUSCAR UM PRODUTO PELO NÚMERO DO ID");
            System.out.println("**************");
            System.out.println();

            System.out.println("Informe o número do id que você gostaria de ver as informações:");
            idConsulta = tecladoBuscar.nextInt();

            produtoRepository.buscarProdutosId(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou buscar outro produto?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para buscar um produto pelo id novamente!");
            String simOuNao = tecladoBuscar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");
        } while (voltar);

    }

    public void alterarProdutosId() {

        Scanner tecladoAlterar = new Scanner(System.in);

        int idConsulta = 0;
        String nome;
        String descricao;
        double valor;
        int quantidadeEstoque;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("ATUALIZAR UM PRODUTO PELO NÚMERO DO ID");
            System.out.println("**************");
            System.out.println();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoAlterar.nextInt();

            System.out.println("Informe o nome:");
            nome = tecladoAlterar.nextLine();

            System.out.println("Informe o descrição:");
            descricao = tecladoAlterar.nextLine();

            System.out.println("Informe o valor:");
            valor = tecladoAlterar.nextDouble();

            System.out.println("Informe a quantidade que tem em estoque:");
            quantidadeEstoque = tecladoAlterar.nextInt();

            produtoRepository.alterarProdutosId(idConsulta, nome, descricao, valor, quantidadeEstoque);
            System.out.println("Gostaria de voltar ao menu anterior ou alterar outro produto?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para tualizar outro cliente!");
            String simOuNao = tecladoAlterar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void deletarProdutosID() {
        Scanner tecladoDeletar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("DELETAR UM PRODUTO PELO NÚMERO DO ID");
            System.out.println("**************");
            System.out.println();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoDeletar.nextInt();

            produtoRepository.deletarProdutosID(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou deletar outro produto?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para deletar outro produto!");
            String simOuNao = tecladoDeletar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

}
