package com.example.Repositorio;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import com.example.Modelo.Pedido;

public class PedidoRepositorio {

    public void criarPedido(Pedido pedido) {
        Statement statement = ConexaoBancoRepositorio.buscarStatement();

        double valorTotal = pedido.getValorTotal();
        String statusPedido = pedido.getStatusPedido();
        LocalDate dataEntrega = pedido.getDataEntrega();
        LocalDate dataVenda = pedido.getDataVenda();

        try {

            int linhasAfetadas = statement.executeUpdate(
                    "INSERT INTO Pedido (valor_total , status_pedido, data_venda, data_entrega) VALUES ('"
                            + valorTotal + "','" + statusPedido + "','" + dataVenda + "','"
                            + dataEntrega + "')");

            if (linhasAfetadas > 0) {
                System.out.println("Pedido inserido com sucesso!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public void listarPedidos() {
        Statement statement = ConexaoBancoRepositorio.buscarStatement();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Pedido");

            while (rs.next()) {
                int id = rs.getInt("id");
                double valorTotal = rs.getDouble("valor_total");
                String statusPedido = rs.getString("status_pedido");
                LocalDate dataVenda = rs.getDate("data_venda").toLocalDate();
                LocalDate dataEntrega = rs.getDate("data_entrega").toLocalDate();

                System.out.println("Id: " + id + " , Valor total: " + valorTotal + ", Status Pedido: " + statusPedido
                        + " Data de Venda: " + dataVenda
                        + " Data de Entrega: " + dataEntrega);

            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);

        }
    }

    public void buscarPedidosId(int idConsulta) {

        Statement statement = ConexaoBancoRepositorio.buscarStatement();

        try {

            ResultSet rs = statement.executeQuery("SELECT * FROM Pedido WHERE id = " + idConsulta);

            while (rs.next()) {
                int id = rs.getInt("id");
                double valorTotal = rs.getDouble("valor_total");
                String statusPedido = rs.getString("status_pedido");
                LocalDate dataVenda = rs.getDate("data_venda").toLocalDate();
                LocalDate dataEntrega = rs.getDate("data_entrega").toLocalDate();

                System.out.println("Id: " + id + " , Valor total: " + valorTotal + ", Status Pedido: " + statusPedido
                        + " Data de Venda: " + dataVenda
                        + " Data de Entrega: " + dataEntrega);
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }
    }

    public void alterarPedidosId(int idConsulta, double valorTotal, String statusPedido, LocalDate dataVenda,
            LocalDate dataEntrega) {

        Statement statement = ConexaoBancoRepositorio.buscarStatement();

        try {

            int linhasAfetadas = statement
                    .executeUpdate("UPDATE  Pedido SET valor_total ='" + valorTotal + "', status_pedido ='"
                            + statusPedido + "', data_venda ='" + dataVenda + "', data_entrega ='" + dataEntrega
                            + "' WHERE id = " + idConsulta);
            if (linhasAfetadas > 0) {
                System.out.println("Pedido Atualizado com sucesso!");
            } else {
                System.out.println("Pedido não foi Atualizado!");
            }
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public void deletarPedidoId(int idConsulta) {

        Statement statement = ConexaoBancoRepositorio.buscarStatement();

        try {

            int linhasAfetadas = statement.executeUpdate("DELETE FROM Pedido WHERE id = " + idConsulta);
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
