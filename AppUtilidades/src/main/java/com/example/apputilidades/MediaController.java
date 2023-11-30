package com.example.apputilidades;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MediaController {
    @FXML
    private TextField nota1Text;
    @FXML
    private TextField nota2Text;
    @FXML
    private TextField nota3Text;
    @FXML
    private Label resultadoLabel;

    @FXML
    protected void onCalcularButtonClicked() {
        double nota1 = Double.parseDouble(nota1Text.getText());
        double nota2 = Double.parseDouble(nota2Text.getText());
        double nota3 = Double.parseDouble(nota3Text.getText());
        double media = (nota1 + nota2 + nota3) / 3;
        resultadoLabel.setText("A média ficou em:" + media);

    }
}
