package com.example.repository;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Produto;

public class ProdutoRepository {

    public void criarProdutos(String nome, String descricao, double valor, int quantidade_estoque) {
        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            int linhasAfetadas = statement
                    .executeUpdate("INSERT INTO Produtos (nome , descricao, valor, quantidade_estoque) VALUES ('"
                            + nome + "','" + descricao + "','" + valor + "','" + quantidade_estoque + "')");

            if (linhasAfetadas > 0) {
                System.out.println("Produto inserido com sucesso!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public List<Produto> listarProdutosParaPedidos() {
        Statement statement = ConexaoBancoRepository.buscarStatement();
        List<Produto> produtos = new ArrayList<>();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Produtos");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                int quantidadeEstoque = rs.getInt("quantidade_estoque");

                Produto produto = new Produto();
                produto.setId(id);
                produto.setNome(nome);
                produto.setDecricao(descricao);
                produto.setQuantidadeEstoque(quantidadeEstoque);
                produto.setValor(valor);

                produtos.add(produto);

            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

        return produtos;
    }

    public List<Produto> listarProdutos() {
        Statement statement = ConexaoBancoRepository.buscarStatement();
        List<Produto> produtos = new ArrayList<>();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Produtos");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                int quantidadeEstoque = rs.getInt("quantidade_estoque");

                Produto produto = new Produto();
                produto.setId(id);
                produto.setNome(nome);
                produto.setDecricao(descricao);
                produto.setQuantidadeEstoque(quantidadeEstoque);
                produto.setValor(valor);

                produtos.add(produto);

                System.out.println("Id: " + id + " , Nome: " + nome + ", Descrição: " + descricao + ", Valor: " + valor
                        + ", Quantidade em Estoque: " + quantidadeEstoque);

            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

        return produtos;
    }

    public void buscarProdutosId(int idConsulta) {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Produtos WHERE id = " + idConsulta);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                int quantidadeEstoque = rs.getInt("quantidade_estoque");

                System.out.println("Id: " + id + " , Nome: " + nome + ", Descrição: " + descricao + ", Valor: " + valor
                        + ", Quantidade em Estoque: " + quantidadeEstoque);

            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public void alterarProdutosId(int idConsulta, String nome, String descricao, double valor, int quantidadeEstoque) {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate("UPDATE  Produtos SET nome ='" + nome + "', descricao ='"
                    + descricao + "', valor ='" + valor + "', quantidade_estoque='" + quantidadeEstoque
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

    public void deletarProdutosID(int idConsulta) {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate("DELETE FROM Produtos WHERE id = " + idConsulta);
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
