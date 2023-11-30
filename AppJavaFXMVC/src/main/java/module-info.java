module com.example.appjavafxmvc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appjavafxmvc to javafx.fxml;
    exports com.example.appjavafxmvc;
}