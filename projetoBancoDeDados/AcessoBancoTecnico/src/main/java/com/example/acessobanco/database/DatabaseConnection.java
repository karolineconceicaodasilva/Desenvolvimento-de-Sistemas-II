package com.example.acessobanco.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private Connection conn;
    private static DatabaseConnection db;
    
    private DatabaseConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/sisienh?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, usuario, senha);
    }

    public static DatabaseConnection getDatabaseConnection() throws Exception {
        if(db == null) db = new DatabaseConnection();
        return db;
    }

    public Connection getConnection() {
        return conn;
    }

}
