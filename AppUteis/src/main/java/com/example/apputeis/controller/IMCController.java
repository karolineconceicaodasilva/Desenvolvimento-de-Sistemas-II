package com.example.apputeis.controller;

import com.example.apputeis.util.FormatUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IMCController extends BasicaController{

    @FXML
    private TextField pesoText;

    @FXML
    private TextField alturaText;

    @FXML
    private Label resultadoLabel;

    @FXML
    private Label valorIMCLabel;

    @FXML
    protected void onLimparMouseClicked() {
        pesoText.clear();
        alturaText.clear();
        resultadoLabel.setText("");
        valorIMCLabel.setText("");
    }
    @FXML
    protected void onCalcularButtonClicked() {
        double peso = Double.parseDouble(FormatUtil.formatarVirgulas(pesoText.getText()));
        double altura = Double.parseDouble(FormatUtil.formatarVirgulas(alturaText.getText()));
        double imc = peso / (altura * altura);

        if (imc <= 18.5) {
            valorIMCLabel.setText("Você está abaixo do peso");
        } else if (imc >= 18.6 && imc <= 24.9) {
            valorIMCLabel.setText("Peso ideal Parabéns");
        } else if (imc >= 25.0 && imc <= 29.9) {
            valorIMCLabel.setText("Levemente acima do Peso");
        } else if (imc >= 18.6 && imc <= 24.9) {
            valorIMCLabel.setText("Peso ideal Parabéns");
        } else if (imc >= 30.0 && imc <= 34.9) {
            valorIMCLabel.setText("Obesidade grau 1");
        } else if (imc >= 35.0 && imc <= 39.9) {
            valorIMCLabel.setText("Obesidade grau 2");
        } else {
            valorIMCLabel.setText("Obesidade grau 3(mórbida)");
        }
        resultadoLabel.setText("Seu IMC ficou: " + FormatUtil.formatarDoubleDuasCasasDecimais(imc));
    }
}
