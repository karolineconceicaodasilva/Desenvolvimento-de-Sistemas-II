package com.example.acessobanco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicialController {

    @FXML
    protected void onCadastroAlunosButtonClicked() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("cadastro-alunos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setScene(scene);
        stage.setTitle("Cadastro de Alunos");
        stage.show();
    }

    @FXML
    protected void onSairButtonClicked() {
        System.exit(0);
    }

}
