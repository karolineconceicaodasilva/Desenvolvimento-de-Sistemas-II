package com.example.Servico;

import java.util.Scanner;

public class MenuPrincipal {

    public void menuPrincipal() {

        Scanner teclado = new Scanner(System.in);

        ClienteServico clienteService = new ClienteServico();
        ProdutoServico produtoService = new ProdutoServico();
        PedidoServico pedidoService = new PedidoServico();

        int opcaoTabela = 0;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("MENU PRINCIPAL");
            System.out.println("**************");
            System.out.println();

            System.out.println("Bem-Vindo você está em um sistema de uma Loja de Brinquedos!");
            System.out.println();

            System.out.println("Escolha uma das opções listadas a baixo:");
            System.out.println("Sendo opção 1- Clientes");
            System.out.println("Sendo opção 2- Pedidos");
            System.out.println("Sendo opção 3- Produtos");
            System.out.println("Sendo opção 4- Para encerrar o Sistema");
            System.out.println();

            System.out.println("Digite a opção desejada:");
            opcaoTabela = teclado.nextInt();

            switch (opcaoTabela) {
                case 1:
                    clienteService.menuClientes();
                    break;
                case 2:
                    pedidoService.menuPedidos();
                    break;
                case 3:
                    produtoService.menuProdutos();
                    break;

                default:
                    break;
            }

        } while (opcaoTabela > 0 && opcaoTabela < 4);

        System.out.println("Sistema encerrado! Obrigado(a) por utilizar-lo");
    }
}
