package com.example.Repositorio;

import java.sql.ResultSet;
import java.sql.Statement;

import com.example.Modelo.Produto;

public class ProdutoRepositorio {

    public void criarProduto(Produto Produto) {

        Statement statement = ConexaoBancoRepositorio.buscarStatement();
        String nome = Produto.getNome();
        String descricao = Produto.getDecricao();
        double valor = Produto.getValor();
        int quantidadeEstoque = Produto.getQuantidadeEstoque();

        try {

            int linhasAfetadas = statement.executeUpdate(
                    "INSERT INTO Produto (nome , descricao, valor, quantidade_estoque) VALUES ('"
                            + nome + "','" + descricao + "','" + valor + "','"
                            + quantidadeEstoque + "')");

            if (linhasAfetadas > 0) {
                System.out.println("Produto inserido com sucesso!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public void listarProdutos() {
        Statement statement = ConexaoBancoRepositorio.buscarStatement();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Produto");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                int quantidadeEstoque = rs.getInt("quantidade_estoque");

                System.out.println("Id: " + id + " , Nome: " + nome + ", Descrição: " + descricao
                        + " Valor: " + valor
                        + " Quantidade em Estoque: " + quantidadeEstoque);

            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);

        }
    }

    public void buscarProdutosId(int idConsulta) {

        Statement statement = ConexaoBancoRepositorio.buscarStatement();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Produto WHERE id = " + idConsulta);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                int quantidadeEstoque = rs.getInt("quantidade_estoque");

                System.out.println("Id: " + id + " , Nome: " + nome + ", Descrição: " + descricao
                        + " Valor: " + valor
                        + " Quantidade em Estoque: " + quantidadeEstoque);

            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }
    }

    public void alterarProdutosId(int idConsulta, String nome, String descricao, double valor, int quantidadeEstoque) {

        Statement statement = ConexaoBancoRepositorio.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate("UPDATE  Produto SET nome ='" + nome + "', descricao ='"
                    + descricao + "', valor ='" + valor + "', quantidade_estoque ='" + quantidadeEstoque
                    + "' WHERE id = " + idConsulta);
            if (linhasAfetadas > 0) {
                System.out.println("Produto Atualizado com sucesso!");
            } else {
                System.out.println("Produto não foi Atualizado!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public void deletarProdutoId(int idConsulta) {

        Statement statement = ConexaoBancoRepositorio.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate("DELETE FROM Produto WHERE id = " + idConsulta);
            if (linhasAfetadas > 0) {
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Produto não encontrado para excluir!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

}
