package com.example.service;
import java.util.Scanner;
import com.example.repository.ClienteRepository;

public class ClienteService {

ClienteRepository clienteRepository = new ClienteRepository();

    public void menuClientes() {
        Scanner teclado = new Scanner(System.in);
      
        int opcaoMenu;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("MENU CLIENTE");
            System.out.println("**************");
            System.out.println();
            System.out.println("Esse é menu de opções que você tem para a tabela de Clientes!");
            System.out.println("Opção 1- Criar");
            System.out.println("Opção 2- Ler todos os Clientes");
            System.out.println("Opção 3- Ler os Clientes pelo número de id");
            System.out.println("Opção 4- Atualizar");
            System.out.println("Opção 5- Deletar");
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
            System.out.println("**************");
            System.out.println("NOVO CLIENTE");
            System.out.println("**************");
            System.out.println();

            System.out.println("Informe o nome:");
            nome = tecladoCriar.nextLine();

            System.out.println("Informe o endereço:");
            endereco = tecladoCriar.nextLine();

            System.out.println("Informe o cpf, lembrando que ele é composto de 14 caracteres(ex: 123.456.789-10):");
            cpf = tecladoCriar.nextLine();
          
            System.out.println("Informe o sexo, digite uma dessas opções: M (Masculino), F (Feminino) ou O (Outro):");
            sexo = tecladoCriar.nextLine();

            if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F") || sexo.equalsIgnoreCase("O")) {

            } else {
                System.out.println("Forma que cadastrou sexo está incorreto");
            }

            clienteRepository.criarCliente(nome, endereco, cpf, sexo);

            System.out.println("Gostaria de voltar ao menu anterior ou inserir outro cliente?");
            System.out.println(
                    "Digite [S] para voltar ao Menu Anterior ou qualquer outra tecla para inserir um novo cliente");
            String simOuNao = tecladoCriar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

    public void listarClientesParaPedidos() {

        clienteRepository.listarClientes();

    }

    public void listarClientes() {

        Scanner tecladoListar = new Scanner(System.in);

        String simOuNao;
        boolean voltar = false;

        do {
            System.out.println();
            System.out.println("**************");
            System.out.println("BUSCA DE TODOS OS CLIENTES");
            System.out.println("**************");
            System.out.println();

            clienteRepository.listarClientes();
            System.out.println("Gostaria de voltar ao menu anterior ou buscar os clientes novamente?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para buscar todos os clientes novamente");
            simOuNao = tecladoListar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);
      
    }

    public void buscarClientesId() {

        Scanner tecladoBuscar = new Scanner(System.in);

        int idConsulta = 0;
        boolean voltar = false;

        do {

            System.out.println();
            System.out.println("**************");
            System.out.println("BUSCAR UM CLIENTE PELO NÚMERO DO ID");
            System.out.println("**************");
            System.out.println();

            System.out.println("Informe o número do id que você gostaria de ver as informações:");
            idConsulta = tecladoBuscar.nextInt();

            clienteRepository.buscarClientesId(idConsulta);

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
            System.out.println("**************");
            System.out.println("ATUALIZAR UM CLIENTE PELO NÚMERO DO ID");
            System.out.println("**************");
            System.out.println();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoAlterar.nextInt();

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

            clienteRepository.alterarClientesId(idConsulta, nome, endereco, cpf, sexo);

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
            System.out.println("**************");
            System.out.println("DELETAR UM CLIENTE PELO NÚMERO DO ID");
            System.out.println("**************");
            System.out.println();

            System.out.println("Informe o número do id que você gostaria de alterar as informações:");
            idConsulta = tecladoDeletar.nextInt();

            clienteRepository.deletarClienteID(idConsulta);

            System.out.println("Gostaria de voltar ao menu anterior ou deletar outro cliente?");
            System.out.println(
                    "Digite [S] para voltar ao menu anterior ou qualquer outra tecla para deletar outro cliente");
            String simOuNao = tecladoDeletar.next();
            voltar = !simOuNao.equalsIgnoreCase("S");

        } while (voltar);

    }

}
