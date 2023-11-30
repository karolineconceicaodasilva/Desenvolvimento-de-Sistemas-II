package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexaoBancoRepository {
    
   static Statement statement = null;

    public static Statement buscarStatement(){
        if(statement == null)
            criarConexao();
        
        return statement;
    }

    private static void criarConexao() {
        String url = "jdbc:mysql://localhost:3306/loja?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";
       
        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Estabelece conexão com o banco
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            // Cria um objeto Statement (comando) para enviar consultas ao banco
         statement =  conn.createStatement();
            
        } catch (Exception error) {
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(error);
        }

       
    }

}
