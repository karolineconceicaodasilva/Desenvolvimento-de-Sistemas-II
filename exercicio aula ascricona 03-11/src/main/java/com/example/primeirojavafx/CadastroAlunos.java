package com.example.primeirojavafx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CadastroAlunos extends Stage {

    private void createStage(){
        GridPane gridPane = new GridPane();

        Label lblNome = new Label("Nome");
        Label lblDescricao = new Label("Descrição");

        TextField txtNome = new TextField();

        TextArea txtDescricao = new TextArea();
        txtDescricao.setWrapText(true);
        txtDescricao.setPrefRowCount(5);

        Button btnSalvar = new Button("Salvar");

        gridPane.add(lblNome, 0, 0);
        gridPane.add(txtNome, 1, 0);
        gridPane.add(lblDescricao, 0, 1);
        gridPane.add(txtDescricao, 1, 1);
        gridPane.add(btnSalvar, 1,2);

        Scene scene = new Scene(gridPane, 400, 400);
        setScene(scene);
        setTitle("Cadastro de Aluno");
        show();
    }

    public CadastroAlunos(){
        createStage();
    }

}
