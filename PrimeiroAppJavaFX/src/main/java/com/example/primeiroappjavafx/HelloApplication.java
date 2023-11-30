package com.example.primeiroappjavafx;

import javafx.application.Application;
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
        Button botaoOk = new Button();
        botaoOk.setText("Clique aqui");
        botaoOk.setOnAction((e) -> {
            Alert mensagem = new Alert(Alert.AlertType.INFORMATION);
            mensagem.setTitle("Alerta");
            mensagem.setContentText("Você clicou no botão");
            mensagem.show();
        });

        Button botaoAbreTela = new Button();
        botaoAbreTela.setText("Abre tela de teste");
        botaoAbreTela.setOnMouseClicked((e)->{
            TelaTeste novaTela = new TelaTeste();
        });
        Label titulo = new Label();
        titulo.setText("Minha primeira aplicação JavaFX ");
        TextField caixaTexto = new TextField();
        caixaTexto.setMinWidth(100);

        VBox caixa = new VBox();
        caixa.getChildren().add(titulo);
        caixa.getChildren().add(botaoOk);
        caixa.getChildren().add(caixaTexto);
        caixa.getChildren().add(botaoAbreTela);


        Scene scene = new Scene(caixa, 200, 200);
        stage.setTitle("Minha primeira aplicação JavaFX!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}