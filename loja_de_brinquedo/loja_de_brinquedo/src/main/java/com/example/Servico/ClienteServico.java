package com.example.Servico;

import java.util.Scanner;

import com.example.Modelo.Cliente;

import com.example.Repositorio.ClienteRepositorio;

public class ClienteServico {

    ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
    MenuPrincipal menuPrin = new MenuPrincipal();

    public void menuClientes() {
        Scanner teclado = new Scanner(System.in);
        int opcaoMenu;

        do {

            System.out.println();
            System.out.println("************");
            System.out.println("MENU CLIENTE");
            System.out.println("************");
            System.out.println();
            System.out.println("Esse é menu de opções que você tem para a tabela de Clientes!");
            System.out.println("Opção 1- Cadastrar um novo Cliente");
            System.out.println("Opção 2- Ler todos os Clientes");
            System.out.println("Opção 3- Ler os Clientes pelo número de id");
            System.out.println("Opção 4- Atualizar dados do Clientes");
            System.out.println("Opção 5- Excluir cadastro do Cleinte");
            System.out.println("Opção 6- Voltar ao inicio do Sistema");
            System.out.println();
            System.out.println("Gostaria acessar alguma dessas opções?\n" + "Digita a opção desejada:");
            opcaoMenu = teclado.nextInt();

            switch (opcaoMenu) {

                case 1:
                    this.criarCliente();
                    break;

                case 2:
                    this.listarClientes();
                    break;

                case 3:
                    this.buscarClientesId();
                    break;

                case 4:
                    this.alterarClientesId();
                    break;

                case 5:
                    this.deletarClienteID();
                    break;

                case 6:
                    menuPrin.menuPrincipal();
                    break;

                default:
                    break;
            }

        } while (opcaoMenu > 0 && opcaoMenu < 6);
    }

    public void criarCliente() {

        Scanner tecladoCriar = new Scanner(System.in);
        String nome;
        String endereco;
        String cpf;
        String sexo;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**********************");
            System.out.println("CADASTRAR NOVO CLIENTE");
            System.out.println("**********************");
            System.out.println();

            System.out.println("Informe o nome:");
            nome = tecladoCriar.nextLine();

            System.out.println("Informe o endereço:");
            endereco = tecladoCriar.nextLine();

            System.out.println("Informe o cpf, lembrando que ele é composto de 14 caracteres(ex: 123.456.789-10):");
            cpf = tecladoCriar.nextLine();

            while (cpf.length() != 14) {

                System.out.println("Ops! cpf inválido");

                System.out
                        .println("Tente novamente, lembrando que ele é composto de 14 caracteres(ex: 123.456.789-10):");
                cpf = tecladoCriar.nextLine();

            }

            System.out
                    .println("Informe o sexo, digite uma dessas opções: M (Masculino), F (Feminino) ou O (Outro):");
            sexo = tecladoCriar.nextLine();

            while (!(sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F") || sexo.equalsIgnoreCase("O"))) {

                System.out.println("Ops! Opção inválida");

                System.out.println(
                        "Tente novamente, digite uma dessas opções: M (Masculino), F (Feminino) ou O (Outro):");
                sexo = tecladoCriar.nextLine();

            }

            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setEndereco(endereco);
            cliente.setCpf(cpf);
            cliente.setSexo(sexo);

            clienteRepositorio.criarCliente(cliente);

            System.out.println("Gostaria de voltar ao menu anterior ou inserir outro cliente?");
            System.out.println(
                    "Digite [S] para voltar ao Menu Anterior ou qualquer outra tecla para inserir um novo cliente");
            String simOuNao = tecladoCriar.nextLine();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void listarClientes() {

        Scanner tecladoListar = new Scanner(System.in);

        String simOuNao;
        boolean voltar = false;

        do {
            System.out.println();
            System.out.println("**************************");
            System.out.println("BUSCA DE TODOS OS CLIENTES");
            System.out.println("**************************");
            System.out.println();

            clienteRepositorio.listarClientes();
            System.out.println("Gostaria de voltar ao menu anterior ou buscar os Clientes?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para buscar todos os Clientes novamente!");
            simOuNao = tecladoListar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void listarClientesParaOlhar() {
        clienteRepositorio.listarClientes();
    }

    public void buscarClientesId() {

        Scanner tecladoBuscar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("***********************************");
            System.out.println("BUSCAR UM CLIENTE PELO NÚMERO DO ID");
            System.out.println("***********************************");
            System.out.println();

            System.out.println("*****************");
            System.out.println("LISTA DE CLIENTES");
            System.out.println("*****************");
            this.listarClientesParaOlhar();

            System.out.println("Informe o número do id que você gostaria de ver as informações:");
            idConsulta = tecladoBuscar.nextInt();

            tecladoBuscar.nextLine();

            clienteRepositorio.buscarClientesId(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou buscar outro cliente?");
            System.out.println(
                    "Digite [S] para voltar ao Menu Anterior ou qualquer outra tecla para buscar um cliente pelo id novamente");
            String simOuNao = tecladoBuscar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");
        } while (voltar);
    }

    public void alterarClientesId() {

        Scanner tecladoAlterar = new Scanner(System.in);

        int idConsulta = 0;
        String nome;
        String endereco;
        String cpf;
        String sexo;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************************************");
            System.out.println("ATUALIZAR UM CLIENTE PELO NÚMERO DO ID");
            System.out.println("**************************************");
            System.out.println();

            System.out.println("******************");
            System.out.println("LISTA DE CLIENTES");
            System.out.println("******************");
            this.listarClientesParaOlhar();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoAlterar.nextInt();

            tecladoAlterar.nextLine();

            System.out.println("Informe o nome:");
            nome = tecladoAlterar.nextLine();

            System.out.println("Informe o endereço:");
            endereco = tecladoAlterar.nextLine();

            System.out.println("Informe o cpf, lembrando que ele é composto de 14 caracteres(ex: 123.456.789-10):");
            cpf = tecladoAlterar.nextLine();

            System.out.println("Informe o sexo, digite uma dessas opções: M (Masculino), F (Feminino) ou O (Outro):");
            sexo = tecladoAlterar.nextLine();

            if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F") || sexo.equalsIgnoreCase("O")) {

            } else {
                System.out.println("Forma que cadastrou sexo está incorreto");
            }

            clienteRepositorio.alterarClientesId(idConsulta, nome, endereco, cpf, sexo);

            System.out.println("Gostaria de voltar ao menu anterior ou buscar outro cliente?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para Atualizar outro cliente ");
            String simOuNao = tecladoAlterar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);
    }

    public void deletarClienteID() {

        Scanner tecladoDeletar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("************************************");
            System.out.println("DELETAR UM CLIENTE PELO NÚMERO DO ID");
            System.out.println("************************************");
            System.out.println();

            System.out.println("******************");
            System.out.println("LISTA DE CLIENTES");
            System.out.println("******************");
            this.listarClientesParaOlhar();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoDeletar.nextInt();

            tecladoDeletar.nextLine();

            clienteRepositorio.deletarClienteID(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou deletar outro cliente?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para deletar outro cliente");
            String simOuNao = tecladoDeletar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }
}
