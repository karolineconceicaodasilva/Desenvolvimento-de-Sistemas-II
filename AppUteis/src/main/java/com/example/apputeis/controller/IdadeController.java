package com.example.apputeis.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IdadeController extends BasicaController{

    @FXML
    private TextField idadeText;
    @FXML
    private Label resultadoLabel;
    @FXML
    private Label anosRsultLabel;


    @FXML
    protected void onIdadeButtonClicked() {
        int idade = Integer.parseInt(idadeText.getText());
        if (idade <= 44) {
            resultadoLabel.setText("Sua idade está classificada na faixa de Jovens");
        } else if (idade >= 45 && idade <= 59) {
            resultadoLabel.setText("Sua idade está classificada na faixa de Idade Mádia");
        } else if (idade >= 60 && idade <= 74) {
            resultadoLabel.setText("Sua idade está classificada na faixa de Pessoa Idosa");
        } else if (idade >= 75 && idade <= 89) {
            resultadoLabel.setText("Sua idade está classificada na faixa de Velhice");
        }else {
            resultadoLabel.setText("Sua idade está classificada na faixa de Grande Velhice");
        }
        anosRsultLabel.setText("Você tem: " + idade + " anos" );
    }

    @FXML
    protected void onLimparMouseClicked() {
        idadeText.clear();
        resultadoLabel.setText("");
        anosRsultLabel.setText("");
    }

}
