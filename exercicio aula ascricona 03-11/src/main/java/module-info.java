module com.example.primeirojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.primeirojavafx to javafx.fxml;
    exports com.example.primeirojavafx;
}