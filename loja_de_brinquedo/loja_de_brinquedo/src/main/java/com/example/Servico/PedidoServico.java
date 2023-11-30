package com.example.Servico;

import java.time.LocalDate;
import java.util.Scanner;

import com.example.Modelo.Pedido;

import com.example.Repositorio.PedidoRepositorio;

public class PedidoServico {

    PedidoRepositorio PedidoRepositorio = new PedidoRepositorio();
    MenuPrincipal menuPrin = new MenuPrincipal();

    public void menuPedidos() {

        Scanner teclado = new Scanner(System.in);

        int opcaoMenu;

        do {

            System.out.println();
            System.out.println("************");
            System.out.println("MENU PEDIDOS");
            System.out.println("************");
            System.out.println();

            System.out.println("VOCÊ É CLIENTE OU FUNCIONARIO?");
            System.out.println("Opção 1- Cliente");
            System.out.println("Opção 2- Funcionario");
            System.out.println("Opção 3- Voltar ao inicio do Sistema");
            System.out.println("Gostaria acessar alguma dessas opções?\n" + "Digita a opção desejada:");
            opcaoMenu = teclado.nextInt();

            if (opcaoMenu == 1) {
                System.out.println("Esse é menu de opções que você tem para a tabela de Pedidos!");
                System.out.println("Opção 1- Ler todos os Pedidos");
                System.out.println("Opção 2- Ler os Pedidos pelo número de id");
                System.out.println("Opção 3- Voltar ao inicio do Sistema");
                System.out.println();
                System.out.println("Gostaria acessar alguma dessas opções?\n" + "Digita a opção desejada:");
                int opcaoCliente = teclado.nextInt();

                switch (opcaoCliente) {
                    case 1:
                        this.listarPedidos();
                        break;
                    case 2:
                        this.buscarPedidosId();
                        break;

                    case 3:
                        menuPrin.menuPrincipal();
                        break;

                    default:
                        break;
                }

            } else if (opcaoMenu == 2) {
                System.out.println("Esse é menu de opções que você tem para a tabela de Pedidos!");
                System.out.println("Opção 1- Cadastrar um novo Pedido");
                System.out.println("Opção 2- Ler todos os Pedidos");
                System.out.println("Opção 3- Ler os Pedidos pelo número de id");
                System.out.println("Opção 4- Atualizar dados do Pedidos");
                System.out.println("Opção 5- Excluir cadastro de algum Pedido");
                System.out.println("Opção 6- Voltar ao inicio do Sistema");
                System.out.println();
                System.out.println("Gostaria acessar alguma dessas opções?\n" + "Digita a opção desejada:");
                int opcaoFuncionario = teclado.nextInt();

                switch (opcaoFuncionario) {

                    case 1:
                        this.criarPedido();
                        break;

                    case 2:
                        this.listarPedidos();
                        break;

                    case 3:
                        this.buscarPedidosId();
                        break;

                    case 4:
                        this.alterPedidosId();
                        break;

                    case 5:
                        this.deletarPedidoID();
                        break;

                    case 6:
                        menuPrin.menuPrincipal();
                        break;
                }
            }

        } while (opcaoMenu > 0 && opcaoMenu < 3);
    }

    public void criarPedido() {

        Scanner tecladoCriar = new Scanner(System.in);

        double valorTotal;
        String statusPedido;
        LocalDate dataEntrega;
        LocalDate dataVenda;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("*********************");
            System.out.println("CADASTRAR NOVO PEDIDO");
            System.out.println("*********************");
            System.out.println();

            System.out.println("Informe o valor total do Pedido:");
            valorTotal = tecladoCriar.nextDouble();
            tecladoCriar.nextLine();

            System.out.println("Informe o Status do Pedido:");
            statusPedido = tecladoCriar.nextLine();

            System.out.println("Informe a data da venda (Lembrando que o formato correto é aaaa-mm-dd):");
            dataVenda = LocalDate.parse(tecladoCriar.nextLine());

            System.out.println("Informe a Data de Entrega(Lembrando que o formato correto é aaaa-mm-dd):");
            dataEntrega = LocalDate.parse(tecladoCriar.nextLine());

            Pedido Pedido = new Pedido();
            Pedido.setValorTotal(valorTotal);
            Pedido.setStatusPedido(statusPedido);
            Pedido.setDataVenda(dataVenda);
            Pedido.setDataEntrega(dataEntrega);

            PedidoRepositorio.criarPedido(Pedido);

            System.out.println("Gostaria de voltar ao menu anterior ou inserir outro Pedido?");
            System.out.println(
                    "Digite [S] para voltar ao Menu Anterior ou qualquer outra tecla para inserir um novo Pedido");
            String simOuNao = tecladoCriar.nextLine();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void listarPedidos() {

        Scanner tecladoListar = new Scanner(System.in);

        String simOuNao;
        boolean voltar = false;

        do {
            System.out.println();
            System.out.println("*************************");
            System.out.println("BUSCA DE TODOS OS PEDIDOS");
            System.out.println("*************************");
            System.out.println();

            PedidoRepositorio.listarPedidos();
            System.out.println("Gostaria de voltar ao menu anterior ou buscar os Pedidos?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para buscar todos os Pedidos novamente!");
            simOuNao = tecladoListar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void listarPedidosParaOlhar() {
        PedidoRepositorio.listarPedidos();
    }

    public void buscarPedidosId() {

        Scanner tecladoBuscar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**********************************");
            System.out.println("BUSCAR UM PEDIDO PELO NÚMERO DO ID");
            System.out.println("**********************************");
            System.out.println();

            System.out.println("****************");
            System.out.println("LISTA DE PEDIDOS");
            System.out.println("****************");
            this.listarPedidosParaOlhar();

            System.out.println("Informe o número do id que você gostaria de ver as informações:");
            idConsulta = tecladoBuscar.nextInt();

            tecladoBuscar.nextLine();

            PedidoRepositorio.buscarPedidosId(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou buscar outro Pedido?");
            System.out.println(
                    "Digite [S] para voltar ao Menu Anterior ou qualquer outra tecla para buscar um Pedido pelo id novamente");
            String simOuNao = tecladoBuscar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");
        } while (voltar);
    }

    public void alterPedidosId() {

        Scanner tecladoAlterar = new Scanner(System.in);

        int idConsulta = 0;
        double valorTotal;
        String statusPedido;
        LocalDate dataEntrega;
        LocalDate dataVenda;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************************************");
            System.out.println("ATUALIZAR UM PEDIDO PELO NÚMERO DO ID");
            System.out.println("**************************************");
            System.out.println();

            System.out.println("****************");
            System.out.println("LISTA DE PEDIDOS");
            System.out.println("****************");
            this.listarPedidosParaOlhar();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoAlterar.nextInt();

            System.out.println("Informe o valor total do Pedido:");
            valorTotal = tecladoAlterar.nextDouble();

            System.out.println("Informe o Status do Pedido:");
            statusPedido = tecladoAlterar.nextLine();

            tecladoAlterar.nextLine();

            System.out.println("Informe a data da venda (Lembrando que o formato correto é aaaa-mm-dd)");
            dataVenda = LocalDate.parse(tecladoAlterar.nextLine());

            System.out.println("Informe a Data de Entrega(Lembrando que o formato correto é aaaa-mm-dd)");
            dataEntrega = LocalDate.parse(tecladoAlterar.nextLine());

            PedidoRepositorio.alterarPedidosId(idConsulta, valorTotal, statusPedido, dataVenda, dataEntrega);

            System.out.println("Gostaria de voltar ao menu anterior ou buscar outro Pedido?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para Atualizar outro Pedido ");
            String simOuNao = tecladoAlterar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);
    }

    public void deletarPedidoID() {

        Scanner tecladoDeletar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("***********************************");
            System.out.println("DELETAR UM PEDIDO PELO NÚMERO DO ID");
            System.out.println("***********************************");
            System.out.println();

            System.out.println("****************");
            System.out.println("LISTA DE PEDIDOS");
            System.out.println("****************");
            this.listarPedidosParaOlhar();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoDeletar.nextInt();

            tecladoDeletar.nextLine();

            PedidoRepositorio.deletarPedidoId(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou deletar outro Pedido?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para deletar outro Pedido");
            String simOuNao = tecladoDeletar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }
}
