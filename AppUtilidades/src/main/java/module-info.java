module com.example.apputilidades {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.apputilidades to javafx.fxml;
    exports com.example.apputilidades;
}