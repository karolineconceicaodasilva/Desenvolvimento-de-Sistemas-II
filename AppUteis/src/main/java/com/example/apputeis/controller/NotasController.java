package com.example.apputeis.controller;

import com.example.apputeis.util.FormatUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NotasController extends BasicaController{

    @FXML
    private TextField nota1Text;

    @FXML
    private TextField nota2Text;

    @FXML
    private TextField nota3Text;

    @FXML
    private TextField nota4Text;

    @FXML
    private TextField nota5Text;

    @FXML
    private Label resultadoLabel;

    @FXML
    protected void onLimparMouseClicked() {
        nota1Text.clear();
        nota2Text.clear();
        nota3Text.clear();
        nota4Text.clear();
        nota5Text.clear();
        resultadoLabel.setText("");
    }

    @FXML
    protected void onCalcularMouseClicked() {
        double nota1 = Double.parseDouble(FormatUtil.formatarVirgulas(nota1Text.getText()));
        double nota2 = Double.parseDouble(FormatUtil.formatarVirgulas(nota2Text.getText()));
        double nota3 = Double.parseDouble(FormatUtil.formatarVirgulas(nota3Text.getText()));
        double nota4 = Double.parseDouble(FormatUtil.formatarVirgulas(nota4Text.getText()));
        double nota5 = Double.parseDouble(FormatUtil.formatarVirgulas(nota5Text.getText()));
        double media = (nota1 + nota2 + nota3 + nota4 + nota5) / 5;
        if (media >= 7) {
            resultadoLabel.setText("Aprovado com média " + FormatUtil.formatarDoubleDuasCasasDecimais(media) + "!");
        } else {
            resultadoLabel.setText("Reprovado com média " + FormatUtil.formatarDoubleDuasCasasDecimais(media) + "! No Good!");
        }
    }

}
