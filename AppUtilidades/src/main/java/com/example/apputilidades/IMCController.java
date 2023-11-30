package com.example.apputilidades;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IMCController {


    @FXML
    private TextField pesoText;
    @FXML
    private TextField alturaText;
    @FXML
    private Label resultadoLabel;

    @FXML
    protected void onCalcularButtonClicked() {
        double peso = Double.parseDouble(pesoText.getText());
        double altura = Double.parseDouble(alturaText.getText());
        double imc = (altura * altura)/peso;
        resultadoLabel.setText("Seu IMC ficou:" + imc);

    }

}
