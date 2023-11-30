package com.example.apputilidades;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaInicialController {

    @FXML
    protected void onSairButtonClicked() {
        Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
        mensagem.setContentText("Obrigada por usar o sistema");
        mensagem.setTitle("Sair do Sistema");
        mensagem.showAndWait();
        System.exit(0);
    }

    @FXML
    protected void onCalcularMediaButtonClicked() throws IOException {
        Stage stageCalcularMedia = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TelaInicialController.class.getResource("media-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 300 , 300);
        stageCalcularMedia.setScene(scene);
        stageCalcularMedia.setTitle("Calcular Média");
        stageCalcularMedia.showAndWait();
    }

    @FXML
    protected void onCalcularIMCButtonClicked() throws IOException{
        Stage stageCalcularIMC = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TelaInicialController.class.getResource("imc-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 300 , 300);
        stageCalcularIMC.setScene(scene);
        stageCalcularIMC.setTitle("Calcular IMC");
        stageCalcularIMC.showAndWait();
    }
}
