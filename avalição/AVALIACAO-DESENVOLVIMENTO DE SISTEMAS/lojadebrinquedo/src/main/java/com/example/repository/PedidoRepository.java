package com.example.repository;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import com.example.model.Produto;

public class PedidoRepository {

    ItemRepository itemRepository = new ItemRepository();

    public void criarPedido(double valorTotal, String statusPedido, LocalDate dataVenda, LocalDate dataEntrega,
            int idCliente,
            List<Produto> produtos) {
        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            statement.executeUpdate(
                    "INSERT INTO Pedidos (valor_total , status_pedido, data_venda, data_entrega, id_clientes) VALUES ('"
                            + valorTotal + "','" + statusPedido + "','" + dataVenda + "','" + dataEntrega + "','"
                            + idCliente + "')");

            int idPedido = buscarUltimoPedido();

            itemRepository.criarItem(idPedido, produtos);

        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public int buscarUltimoPedido() {
        Statement statement = ConexaoBancoRepository.buscarStatement();
        int idPedido = 0;
        try {

            ResultSet rs = statement.executeQuery("select p.id from Pedidos as p order by p.id desc limit 1");

            if (rs.next()) {
                idPedido = rs.getInt("id");
            }

        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

        return idPedido;
    }

    public void listarPedidos() {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Pedidos");

            while (rs.next()) {
                int id = rs.getInt("id");
                double valorTotal = rs.getDouble("valor_total");
                String statusPedidos = rs.getString("status_pedido");
                LocalDate dataVenda = rs.getDate("data_venda").toLocalDate();
                LocalDate dataEntrega = rs.getDate("data_entrega").toLocalDate();
                int idCliente = rs.getInt("id_Clientes");
                System.out.println(
                        "Id: " + id + " , Valor Total: " + valorTotal + ", Status do Pedido: " + statusPedidos
                                + ", Data de venda: " + dataVenda
                                + ", Data de entrega: " + dataEntrega + ", Id do Cliente: " + idCliente);

            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public void buscarPedidosId(int idConsulta) {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Pedidos WHERE id = " + idConsulta);
            while (rs.next()) {
                int id = rs.getInt("id");
                double valorTotal = rs.getDouble("valor_total");
                String statusPedidos = rs.getString("status_pedido");
                LocalDate dataVenda = rs.getDate("data_venda").toLocalDate();
                LocalDate dataEntrega = rs.getDate("data_entrega").toLocalDate();
                int idCliente = rs.getInt("id_Clientes");
                System.out.println(
                        "Id: " + id + " , Valor Total: " + valorTotal + ", Status do Pedido: " + statusPedidos
                                + ", Data de venda: " + dataVenda
                                + ", Data de entrega: " + dataEntrega + ", Id do Cliente: " + idCliente);

            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public void alterarStatusPedidoId(int idConsulta, String statusPedido) {
        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate(
                    "UPDATE  Pedidos SET status_pedido ='" + statusPedido + "' where id = " + idConsulta);

            if (linhasAfetadas > 0) {
                System.out.println("Status do produto Atualizado com sucesso!");
            } else {
                System.out.println("Produto não foi Atualizado!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public void alterarDataEntregaPedidoId(int idConsulta, LocalDate data) {
        Statement statement = ConexaoBancoRepository.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate(
                    "UPDATE  Pedidos SET data_entrega ='" + data + "' where id = " + idConsulta);

            if (linhasAfetadas > 0) {
                System.out.println("Data do Produto Atualizado com sucesso!");
            } else {
                System.out.println("Produto não foi Atualizado!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }
    }

    public void deletarPedidos(int idPedido) {

        Statement statement = ConexaoBancoRepository.buscarStatement();

        List<Integer> listaItens = itemRepository.buscarItensPeloIdDoPedido(idPedido);

        for (Integer idItem : listaItens) {
            itemRepository.deletarItens(idItem);
        }

        try {

            int linhasAfetadas = statement.executeUpdate("DELETE FROM Pedidos WHERE id = " + idPedido);
            if (linhasAfetadas > 0) {
                System.out.println("Pedido excluído com sucesso!");
            } else {
                System.out.println("Pedido não encontrado para excluir!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

}
