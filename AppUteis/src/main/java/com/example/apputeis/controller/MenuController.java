package com.example.apputeis.controller;

import com.example.apputeis.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    protected void onSairMouseClicked() {
        System.exit(0);
    }

    @FXML
    protected void onCalcularMouseClicked() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("notas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 300);
        stage.setTitle("Calcular Notas");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onProdutosMouseClicked() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("produto.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 300);
        stage.setTitle("Calcular Produto");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onIMCMouseClicked() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("IMC.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 300);
        stage.setTitle("Calcular IMC");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onClassificarMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("idade.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 300);
        stage.setTitle("Classificação de idade");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onCoversaoMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("conversao.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 300);
        stage.setTitle("Conversão de Moedas");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onSimulacaoMouseClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("simuladorDeCurso.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 300);
        stage.setTitle("Simulador de Curso");
        stage.setScene(scene);
        stage.show();
    }
}
