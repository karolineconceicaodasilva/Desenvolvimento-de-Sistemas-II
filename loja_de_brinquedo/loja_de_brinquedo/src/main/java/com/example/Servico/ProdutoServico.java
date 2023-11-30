package com.example.Servico;

import java.util.Scanner;

import com.example.Modelo.Produto;
import com.example.Repositorio.PedidoRepositorio;
import com.example.Repositorio.ProdutoRepositorio;

public class ProdutoServico {

    ProdutoRepositorio ProdutoRepositorio = new ProdutoRepositorio();
    MenuPrincipal menuPrin = new MenuPrincipal();

    public void menuProdutos() {

        Scanner teclado = new Scanner(System.in);

        int opcaoMenu;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("MENU PRODUTOS");
            System.out.println("**************");
            System.out.println();

            System.out.println("VOCÊ É CLIENTE OU FUNCIONARIO?");
            System.out.println("Opção 1- Cliente");
            System.out.println("Opção 2- Funcionario");
            System.out.println("Opção 3- Voltar ao inicio do Sistema");
            System.out.println("Gostaria acessar alguma dessas opções?\n" + "Digita a opção desejada:");
            opcaoMenu = teclado.nextInt();

            if (opcaoMenu == 1) {
                System.out.println("Esse é menu de opções que você tem para a tabela de Produtos!");
                System.out.println("Opção 1- Ler todos os Produtos");
                System.out.println("Opção 2- Ler os Produtos pelo número de id");
                System.out.println("Opção 3- Voltar ao inicio do Sistema");
                System.out.println();
                System.out.println("Gostaria acessar alguma dessas opções?\n" + "Digita a opção desejada:");
                int opcaoCliente = teclado.nextInt();

                switch (opcaoCliente) {
                    case 1:
                        this.listarProdutos();
                        break;
                    case 2:
                        this.buscarProdutosId();
                        break;
                    case 3:
                        menuPrin.menuPrincipal();
                        break;

                    default:
                        break;
                }

            } else if (opcaoMenu == 2) {
                System.out.println("Esse é menu de opções que você tem para a tabela de Produtos!");
                System.out.println("Opção 1- Cadastrar um novo Produto");
                System.out.println("Opção 2- Ler todos os Produtos");
                System.out.println("Opção 3- Ler os Produtos pelo número de id");
                System.out.println("Opção 4- Atualizar dados do Produtos");
                System.out.println("Opção 5- Excluir cadastro de algum Produto");
                System.out.println("Opção 6- Voltar ao inicio do Sistema");
                System.out.println();
                System.out.println("Gostaria acessar alguma dessas opções?\n" + "Digita a opção desejada:");
                int opcaoFuncionario = teclado.nextInt();

                switch (opcaoFuncionario) {

                    case 1:
                        this.criarProduto();
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
                        this.deletarProdutoID();
                        break;

                    case 6:
                        menuPrin.menuPrincipal();
                        break;

                    default:
                        break;
                }
            }

        } while (opcaoMenu > 0 && opcaoMenu < 3);
    }

    public void criarProduto() {

        Scanner tecladoCriar = new Scanner(System.in);

        String nome;
        String descricao;
        double valor;
        int quantidadeEstoque;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**********************");
            System.out.println("CADASTRAR NOVO PRODUTO");
            System.out.println("**********************");
            System.out.println();

            System.out.println("Informe o nome do produto:");
            nome = tecladoCriar.nextLine();

            System.out.println("Informe a descrição desse Produto:");
            descricao = tecladoCriar.nextLine();

            System.out.println("Informe o valor do Produto:");
            valor = tecladoCriar.nextDouble();

            System.out.println("Informe quantidade em estoque desse Produto:");
            quantidadeEstoque = tecladoCriar.nextInt();

            Produto Produto = new Produto();
            Produto.setNome(nome);
            Produto.setDecricao(descricao);
            Produto.setValor(valor);
            Produto.setQuantidadeEstoque(quantidadeEstoque);

            ProdutoRepositorio.criarProduto(Produto);
            tecladoCriar.nextLine();

            System.out.println("Gostaria de voltar ao menu anterior ou inserir outro Produto?");
            System.out.println(
                    "Digite [S] para voltar ao Menu Anterior ou qualquer outra tecla para inserir um novo Produto");
            String simOuNao = tecladoCriar.nextLine();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void listarProdutos() {

        Scanner tecladoListar = new Scanner(System.in);

        String simOuNao;
        boolean voltar = false;

        do {
            System.out.println();
            System.out.println("**************************");
            System.out.println("BUSCA DE TODOS OS PRODUTOS");
            System.out.println("**************************");
            System.out.println();

            ProdutoRepositorio.listarProdutos();
            System.out.println("Gostaria de voltar ao menu anterior ou buscar os Produtos?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para buscar todos os Produtos novamente!");
            simOuNao = tecladoListar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void listarProdutosParaOlhar() {
        ProdutoRepositorio.listarProdutos();
    }

    public void buscarProdutosId() {

        Scanner tecladoBuscar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("***********************************");
            System.out.println("BUSCAR UM PRODUTO PELO NÚMERO DO ID");
            System.out.println("***********************************");
            System.out.println();

            System.out.println("*****************");
            System.out.println("LISTA DE PRODUTOS");
            System.out.println("*****************");
            this.listarProdutosParaOlhar();

            System.out.println("Informe o número do id que você gostaria de ver as informações:");
            idConsulta = tecladoBuscar.nextInt();

            tecladoBuscar.nextLine();

            ProdutoRepositorio.buscarProdutosId(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou buscar outro Produto?");
            System.out.println(
                    "Digite [S] para voltar ao Menu Anterior ou qualquer outra tecla para buscar um Produto pelo id novamente");
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
            System.out.println("**************************************");
            System.out.println("ATUALIZAR UM PRODUTO PELO NÚMERO DO ID");
            System.out.println("**************************************");
            System.out.println();

            System.out.println("*****************");
            System.out.println("LISTA DE PRODUTOS");
            System.out.println("*****************");
            this.listarProdutosParaOlhar();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoAlterar.nextInt();
            tecladoAlterar.nextLine();
            System.out.println("Informe o nome do produto:");
            nome = tecladoAlterar.nextLine();

            System.out.println("Informe a descrição desse Produto:");
            descricao = tecladoAlterar.nextLine();

            System.out.println("Informe o valor do Produto:");
            valor = tecladoAlterar.nextDouble();

            System.out.println("Informe quantidade em estoque desse Produto:");
            quantidadeEstoque = tecladoAlterar.nextInt();

            ProdutoRepositorio.alterarProdutosId(idConsulta, nome, descricao, valor, quantidadeEstoque);

            System.out.println("Gostaria de voltar ao menu anterior ou buscar outro Produto?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para Atualizar outro Produto ");
            String simOuNao = tecladoAlterar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);
    }

    public void deletarProdutoID() {

        Scanner tecladoDeletar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("************************************");
            System.out.println("DELETAR UM PRODUTO PELO NÚMERO DO ID");
            System.out.println("************************************");
            System.out.println();

            System.out.println("*****************");
            System.out.println("LISTA DE PRODUTOS");
            System.out.println("*****************");
            this.listarProdutosParaOlhar();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoDeletar.nextInt();

            tecladoDeletar.nextLine();

            ProdutoRepositorio.deletarProdutoId(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou deletar outro Produto?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para deletar outro Produto");
            String simOuNao = tecladoDeletar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }
}
