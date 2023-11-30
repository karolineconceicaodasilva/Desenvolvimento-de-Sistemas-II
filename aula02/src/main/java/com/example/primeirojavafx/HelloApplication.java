package com.example.primeirojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        VBox caixa = new VBox();

        Button btnOK = new Button();
        btnOK.setText("OK");
        btnOK.setOnMouseClicked((e) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Boas vindas");
            alert.setContentText("Olá mundo!");
            alert.show();
        });

        Button btnAbreCadastroAlunos = new Button("Abre cadastro de alunos");
        btnAbreCadastroAlunos.setOnMouseClicked((e) -> {
            CadastroAlunos cadastroAlunos = new CadastroAlunos();
        });

        Label lblNome = new Label();
        lblNome.setText("Informe seu nome:");

        TextField txtNome = new TextField();

        caixa.getChildren().addAll(btnOK, lblNome, txtNome, btnAbreCadastroAlunos);

        Scene scene = new Scene(caixa, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}