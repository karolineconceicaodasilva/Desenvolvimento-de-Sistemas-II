package com.example.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.example.model.Produto;
import com.example.repository.PedidoRepository;

public class PedidoService {

    PedidoRepository pedidoRepository = new PedidoRepository();
    ClienteService clienteService = new ClienteService();
    ProdutoService produtoService = new ProdutoService();

    public void menuPedidos() {
        Scanner teclado = new Scanner(System.in);

        int opcaoMenu;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("MENU PEDIDOS");
            System.out.println("**************");
            System.out.println();
            System.out.println("Esse é menu de opções que você tem para a tabela de Pedidos!");
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
                    this.criarPedidos();
                    break;

                case 2:
                    this.listarPedidos();
                    break;

                case 3:
                    this.buscarPedidosId();
                    break;

                case 4:
                    this.alterarPedidosId();
                    break;

                case 5:
                    this.deletarPedidos();
                    break;

                case 6:
                    break;
                    
                default:
                    break;
            }

        } while (opcaoMenu > 0 && opcaoMenu < 6);
    }

    public void criarPedidos() {

        Scanner tecladoCriar = new Scanner(System.in);
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("NOVO PEDIDO");
            System.out.println("**************");
            System.out.println();

            System.out.println("***LISTA DE CLIENTES***");
            clienteService.listarClientesParaPedidos();

            System.out.println("Escolha o cliente que ira fazer o pedido:");
            int idCliente = tecladoCriar.nextInt();

            LocalDate dataVenda = LocalDate.now();
            LocalDate dataEntrega = LocalDate.now().plusDays(3);
            final String STATUS_PEDIDO = "PENDENTE";

            List<Produto> produtos = produtoService.listarProdutosParaPedidos();

            System.out.println("***LISTA DE PRODUTOS***");
            produtos.forEach(produto -> System.out.println(produto));

            System.out.println("Escolha um produto e passe o seu id:");
            int idProdutoEscolhidoCliente = tecladoCriar.nextInt();

            List<Produto> produtoEscolhido = produtos
                    .stream()
                    .filter(produto -> produto.getId() == idProdutoEscolhidoCliente)
                    .collect(Collectors.toList());

            double valorTotal = produtoEscolhido.stream().mapToDouble(Produto::getValor).sum();

            pedidoRepository.criarPedido(valorTotal, STATUS_PEDIDO, dataVenda, dataEntrega, idCliente,
                    produtoEscolhido);

            System.out.println("Gostaria de voltar ao menu anterior ou inserir outro pedido?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para inserir um novo pedido!");
            String simOuNao = tecladoCriar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);
    }

    public void listarPedidos() {

        Scanner tecladoListar = new Scanner(System.in);

        String simOuNao;
        boolean voltar = false;

        do {
            System.out.println();
            System.out.println("**************");
            System.out.println("BUSCA DE TODOS OS PEDIDOS");
            System.out.println("**************");
            System.out.println();

            pedidoRepository.listarPedidos();
            System.out.println("Gostaria de voltar ao menu anterior ou buscar os pedidos?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para buscar todos os cliente novamente");
            simOuNao = tecladoListar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void listarTodosOsPedidos() {

        pedidoRepository.listarPedidos();
    }

    public void buscarPedidosId() {

        Scanner tecladoBuscar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("BUSCAR UM PEDIDO PELO NÚMERO DO ID");
            System.out.println("**************");
            System.out.println();

            System.out.println("Informe o número do id que você gostaria de ver as informações:");
            idConsulta = tecladoBuscar.nextInt();

            pedidoRepository.buscarPedidosId(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou buscar outro pedido?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para buscar um pedido pelo id novamente!");
            String simOuNao = tecladoBuscar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");
        } while (voltar);

    }

    public void alterarPedidosId() {

        Scanner tecladoAlterar = new Scanner(System.in);

        int idConsulta = 0;
        String novoStatus;

        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("ATUALIZAR UM PEDIDO PELO NÚMERO DO ID");
            System.out.println("**************");
            System.out.println();

            System.out.println("Você tem duas opções para atualizar o pedido!");
            System.out.println("Sendo opção 1- Atualizar status do pedido");
            System.out.println("Sendo opção 2- Atualizar data de entrega do pedido");
            System.out.println();

            System.out.println("Gostaria acessar alguma dessas opções?\n" + "Digita a opção desejada:");
            int opcaoDeAlteracao = tecladoAlterar.nextInt();

            if (opcaoDeAlteracao == 1) {

                System.out.println("***LISTA DE TODOS OS PEDIDOS***");
                this.listarTodosOsPedidos();

                System.out.println("Informe o número do id que você gostaria de alterar as informações:");
                idConsulta = tecladoAlterar.nextInt();

                tecladoAlterar.nextLine();

                System.out.println("Informe um novo Status:");
                novoStatus = tecladoAlterar.nextLine();

                pedidoRepository.alterarStatusPedidoId(idConsulta, novoStatus);

            } else if (opcaoDeAlteracao == 2) {
                System.out.println("***LISTA DE TODOS OS PEDIDOS***");
                this.listarTodosOsPedidos();

                System.out.println("Informe o número do id que você gostaria de alterar a informação:");
                idConsulta = tecladoAlterar.nextInt();

                tecladoAlterar.nextLine();

                System.out.println("Informe um nova data de entrega:");
                String novaData = tecladoAlterar.nextLine();
                LocalDate data = LocalDate.parse(novaData);

                pedidoRepository.alterarDataEntregaPedidoId(idConsulta, data);
            }

            System.out.println("Gostaria de voltar ao menu anterior ou buscar outro cliente?");
            System.out.println(
                    "Digite [S] para voltar ao Menu Anterior ou qualquer outra tecla para Atualizar outro cliente ");
            String simOuNao = tecladoAlterar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void deletarPedidos() {

        Scanner tecladoDeletar = new Scanner(System.in);

        int idEscolha;

        System.out.println();
        System.out.println("**************");
        System.out.println("DELETAR UM PEDIDO PELO NÚMERO DO ID");
        System.out.println("**************");
        System.out.println();

        System.out.println("***LISTA DE TODOS OS PEDIDOS***");
        this.listarTodosOsPedidos();

        System.out.println("Informe o número do id que você gostaria de deletar:");
        idEscolha = tecladoDeletar.nextInt();

        pedidoRepository.deletarPedidos(idEscolha);

    }

}
