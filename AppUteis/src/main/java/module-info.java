module com.example.apputeis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.apputeis to javafx.fxml;
    exports com.example.apputeis;
    exports com.example.apputeis.controller;
    opens com.example.apputeis.controller to javafx.fxml;
}