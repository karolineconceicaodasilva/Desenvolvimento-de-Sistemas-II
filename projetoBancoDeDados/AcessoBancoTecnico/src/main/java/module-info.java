module com.example.acessobanco {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.acessobanco to javafx.fxml;
    exports com.example.acessobanco;
    exports com.example.acessobanco.database;
    exports com.example.acessobanco.database.entidades;
    opens com.example.acessobanco.database to javafx.fxml;
    opens com.example.acessobanco.database.entidades to javafx.fxml;
}