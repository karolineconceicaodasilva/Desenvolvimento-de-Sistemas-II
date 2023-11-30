module com.example.primeiroappjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.primeiroappjavafx to javafx.fxml;
    exports com.example.primeiroappjavafx;
}