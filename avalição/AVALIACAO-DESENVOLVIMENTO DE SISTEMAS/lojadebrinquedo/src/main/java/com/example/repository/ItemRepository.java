package com.example.repository;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Produto;

public class ItemRepository {

    public void criarItem(int idPedido, List<Produto> produtos) {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        for (Produto produto : produtos) {

            try {

                int linhasAfetadas = statement
                        .executeUpdate("INSERT INTO Itens (material , valor, id_pedidos, id_produtos) VALUES ('"
                                + produto.getDecricao() + "','" + produto.getValor() + "','" + idPedido + "','"
                                + produto.getId() + "')");

                if (linhasAfetadas == 0) {
                    System.out.println("Ops, não foi possível completar seu pedido!!!");
                }

            } catch (Exception error) {
                System.out.println("Deu ruim!! Fale com o administrador!");
                System.out.println(error);
            }
        }

    }

    public void deletarItens(int idItem) {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate("DELETE FROM Itens WHERE id = " + idItem);
            if (linhasAfetadas > 0) {
                System.out.println("Item excluído com sucesso!");
            } else {
                System.out.println("Item não encontrado para excluir!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public List<Integer> buscarItensPeloIdDoPedido(int idPedido) {

        Statement statement = ConexaoBancoRepository.buscarStatement();
        List<Integer> itens = new ArrayList<>();

        try {

            ResultSet rs = statement.executeQuery("select * from Itens where id_Pedidos = " + idPedido);
            while (rs.next()) {
                int id = rs.getInt("id");
                itens.add(id);

            }

        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }
        return itens;
    }
}
