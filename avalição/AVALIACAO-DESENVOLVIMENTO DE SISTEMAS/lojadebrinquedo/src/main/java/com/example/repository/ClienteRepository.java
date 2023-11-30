package com.example.repository;

import java.sql.ResultSet;
import java.sql.Statement;

public class ClienteRepository {

    public void criarCliente(String nome, String endereco, String cpf, String sexo) {
        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate("INSERT INTO Clientes (nome , endereco, cpf, sexo) VALUES ('"
                    + nome + "','" + endereco + "','" + cpf + "','" + sexo + "')");

            if (linhasAfetadas > 0) {
                System.out.println("Cliente inserido com sucesso!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public void listarClientes() {
        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Clientes");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String cpf = rs.getString("cpf");
                String sexo = rs.getString("sexo");

                System.out.println("Id: " + id + " , Nome: " + nome + ", Endereço: " + endereco + " CPF: " + cpf
                        + "Sexo: " + sexo);

            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }
    }

    public void buscarClientesId(int idConsulta) {
        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Clientes where id = " + idConsulta);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String cpf = rs.getString("cpf");
                String sexo = rs.getString("sexo");

                System.out.println("Id: " + id + " , Nome: " + nome + ", Endereço: " + endereco + " , CPF: " + cpf
                        + ", Sexo: " + sexo);
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }
    }

    public void alterarClientesId(int idConsulta, String nome, String endereco, String cpf, String sexo) {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate("UPDATE  Clientes SET nome ='" + nome + "', endereco ='"
                    + endereco + "', cpf='" + cpf + "', sexo='" + sexo + "' WHERE id = " + idConsulta);
            if (linhasAfetadas > 0) {
                System.out.println("Cliente Atualizado com sucesso!");
            } else {
                System.out.println("Cliente não foi Atualizado!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }
    }

    public void deletarClienteID(int idConsulta) {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate("DELETE FROM Clientes WHERE id = " + idConsulta);
            if (linhasAfetadas > 0) {
                System.out.println("Cliente excluído com sucesso!");
            } else {
                System.out.println("Cliente não encontrado para excluir!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

}