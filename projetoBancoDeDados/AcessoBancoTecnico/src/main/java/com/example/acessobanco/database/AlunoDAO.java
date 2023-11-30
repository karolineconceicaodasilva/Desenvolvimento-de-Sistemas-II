package com.example.acessobanco.database;

import com.example.acessobanco.database.entidades.Aluno;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public static List<Aluno> obterTodos() throws Exception{
        List<Aluno> alunos = new ArrayList<>();
        Connection conn = DatabaseConnection.getDatabaseConnection().getConnection();
        //Cria um objeto Statement (comando) para enviar consultas ao banco
        Statement stmt = conn.createStatement();
        //Executa a consulta SQL
        ResultSet rs = stmt.executeQuery("SELECT * FROM ALUNO");
        //Itera sobre os resultados e imprime no console
        while(rs.next()){
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            double peso = rs.getDouble("peso");
            String cpf = rs.getString("cpf");
            Aluno aluno = new Aluno(id, nome, peso, cpf);
            alunos.add(aluno);
        }
        return alunos;
    }

    public static Aluno obterPorId(int idBusca) throws Exception{
        Aluno aluno = null;
        Connection conn = DatabaseConnection.getDatabaseConnection().getConnection();
        //Cria um objeto Statement (comando) para enviar consultas ao banco
        Statement stmt = conn.createStatement();
        //Executa a consulta SQL
        ResultSet rs = stmt.executeQuery("SELECT * FROM ALUNO where id = " + idBusca);
        //Itera sobre os resultados e imprime no console
        while(rs.next()){
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            double peso = rs.getDouble("peso");
            String cpf = rs.getString("cpf");
            aluno = new Aluno(id, nome, peso, cpf);
        }
        return aluno;
    }

    public static int insere(Aluno aluno) throws Exception{
        Connection conn = DatabaseConnection.getDatabaseConnection().getConnection();
        //Cria um objeto Statement (comando) para enviar uma instrução SQL ao banco
        Statement stmt = conn.createStatement();
        //Executa uma instrução SQL
        int linhasAfetadas = stmt.executeUpdate("INSERT INTO ALUNO (nome, peso , cpf) VALUES ('" + aluno.getNome() + "', " + aluno.getPeso() + " , '" + aluno.getCpf() + "')");
        return linhasAfetadas;
    }

    public static int atualiza(Aluno aluno) throws Exception{
        Connection conn = DatabaseConnection.getDatabaseConnection().getConnection();
        Statement stmt = conn.createStatement();
        int linhasAfetadas = stmt.executeUpdate("UPDATE ALUNO SET nome = '" + aluno.getNome() + "', peso = " + aluno.getPeso() + " , cpf= '" + aluno.getCpf() + "' WHERE id = " + aluno.getId());
        return linhasAfetadas;
    }

    public static int exclui(Aluno aluno) throws Exception{
        Connection conn = DatabaseConnection.getDatabaseConnection().getConnection();
        Statement stmt = conn.createStatement();
        int linhasAfetadas = stmt.executeUpdate("DELETE FROM ALUNO WHERE id = " + aluno.getId());
        return linhasAfetadas;
    }

}
