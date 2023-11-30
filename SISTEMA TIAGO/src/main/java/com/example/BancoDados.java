package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BancoDados {

    public static void atualizarAluno(){

        String url = "jdbc:mysql://localhost:3306/sisienh?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o id do aluno que deseja alterar:");
        int id = teclado.nextInt();
        System.out.println("Informe o novo nome do aluno:");
        String nome = teclado.nextLine();
        System.out.println("Informe o novo peso do aluno:");
        double peso = teclado.nextDouble();

        try{
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Estabelece conexão com o banco
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            //Cria um objeto Statement (comando) para enviar consultas ao banco
            Statement stmt = conn.createStatement();
            //Executa a consulta SQL
            String sql = "UPDATE aluno SET nome = '" + nome + "', peso = " + peso + " WHERE id = " + id;
            int linhasAfetadas = stmt.executeUpdate(sql);
            if(linhasAfetadas > 0){
                System.out.println("Aluno ATUALIZADO com sucesso!");
            }else{
                System.out.println("Aluno NÃO ATUALIZADO!");
            }
        }catch(Exception error){
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public static void inserirAluno(){

        String url = "jdbc:mysql://localhost:3306/sisienh?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome do aluno:");
        String nome = teclado.nextLine();
        System.out.println("Informe o peso do aluno:");
        double peso = teclado.nextDouble();

        try{
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Estabelece conexão com o banco
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            //Cria um objeto Statement (comando) para enviar consultas ao banco
            Statement stmt = conn.createStatement();
            //Executa a consulta SQL
            int linhasAfetadas = stmt.executeUpdate("INSERT INTO aluno (nome, peso) VALUES ('" + nome + "'," + peso + ")");
            if(linhasAfetadas > 0){
                System.out.println("Aluno INSERIDO com sucesso!");
            }else{
                System.out.println("Aluno NÃO INSERIDO!");
            }
        }catch(Exception error){
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }
    
    public static void excluirAlunoPeloId(){

        String url = "jdbc:mysql://localhost:3306/sisienh?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o id do aluno que quer excluir:");
        int idBusca = teclado.nextInt();

        try{
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Estabelece conexão com o banco
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            //Cria um objeto Statement (comando) para enviar consultas ao banco
            Statement stmt = conn.createStatement();
            //Executa a consulta SQL
            int linhasAfetadas = stmt.executeUpdate("DELETE FROM aluno WHERE id = " + idBusca);
            if(linhasAfetadas > 0){
                System.out.println("Aluno excluído com sucesso!");
            }else{
                System.out.println("Aluno não encontrado para excluir!");
            }
        }catch(Exception error){
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public static void buscarAlunoPeloNome(){

        String url = "jdbc:mysql://localhost:3306/sisienh?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome do aluno que quer buscar:");
        String nomeBusca = teclado.nextLine();

        try{
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Estabelece conexão com o banco
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            //Cria um objeto Statement (comando) para enviar consultas ao banco
            Statement stmt = conn.createStatement();
            //Executa a consulta SQL
            ResultSet rs = stmt.executeQuery("SELECT * FROM aluno WHERE nome = '" + nomeBusca + "'");
            //Itera sobre os resultados e imprime no console
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double peso = rs.getDouble("peso");
                System.out.println(id + " " + nome + " " + peso); 
            }
        }catch(Exception error){
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public static void buscarAlunoPeloId(){

        String url = "jdbc:mysql://localhost:3306/sisienh?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o id do aluno que quer buscar:");
        int idBusca = teclado.nextInt();

        try{
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Estabelece conexão com o banco
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            //Cria um objeto Statement (comando) para enviar consultas ao banco
            Statement stmt = conn.createStatement();
            //Executa a consulta SQL
            ResultSet rs = stmt.executeQuery("SELECT * FROM aluno WHERE id = " + idBusca);
            //Itera sobre os resultados e imprime no console
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double peso = rs.getDouble("peso");
                System.out.println(id + " " + nome + " " + peso); 
            }
        }catch(Exception error){
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public static void consultaTodosAlunos(){

        String url = "jdbc:mysql://localhost:3306/sisienh?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        try{
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Estabelece conexão com o banco
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            //Cria um objeto Statement (comando) para enviar consultas ao banco
            Statement stmt = conn.createStatement();
            //Executa a consulta SQL
            ResultSet rs = stmt.executeQuery("SELECT * FROM aluno");
            //Itera sobre os resultados e imprime no console
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double peso = rs.getDouble("peso");
                System.out.println(id + " " + nome + " " + peso); 
            }
        }catch(Exception error){
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

    public static void consultaTodosAlunosComExcessoDePeso(){

        String url = "jdbc:mysql://localhost:3306/sisienh?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        try{
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Estabelece conexão com o banco
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            //Cria um objeto Statement (comando) para enviar consultas ao banco
            Statement stmt = conn.createStatement();
            //Executa a consulta SQL
            ResultSet rs = stmt.executeQuery("SELECT * FROM aluno WHERE peso > 100");
            //Itera sobre os resultados e imprime no console
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double peso = rs.getDouble("peso");
                System.out.println(id + " " + nome + " " + peso); 
            }
        }catch(Exception error){
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

    }

}
