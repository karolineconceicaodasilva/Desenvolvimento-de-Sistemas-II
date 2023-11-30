package com.example.apputeis.controller;

import com.example.apputeis.util.FormatUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class SimuladorDeCursoController extends BasicaController{

    private final String ADM = "Administração";
    private final String TI = "Técnologia da Informação";
    private final String PSICOLOGIA = "Psicologia";


    @FXML
    private Label valorCursoLabel;

    @FXML
    private TextField creditosText;

    @FXML
    private Label valorParcelasLabel;

    @FXML
    private Label valorCreditoLabel;

    double adm = 500.00;
    double ti = 550.00;
    double psicologia = 650.00;
    @FXML
    private ComboBox<String> cbCurso;

    @FXML
    public void onCursoMouseClicked() {
        List<String> opcoesList = Arrays.asList(ADM, TI, PSICOLOGIA);
        ObservableList<String> opcoes = FXCollections.observableList(opcoesList);
        cbCurso.setItems(opcoes);
    }
    private void calcularCreditos(double valorCurso, double valorCreditos) {
        double result = valorCurso * valorCreditos;
        valorCursoLabel.setText("Valor integral do seu curso é: R$" + FormatUtil.formatarDoubleDuasCasasDecimais(result));
        double valorParcela = result / 6;
        valorParcelasLabel.setText("Valor parcelado em 6x fica: R$" + FormatUtil.formatarDoubleDuasCasasDecimais(valorParcela));
        valorCreditoLabel.setText("O valor de cada Créditos é de: R$" + FormatUtil.formatarDoubleDuasCasasDecimais(valorCreditos));
    }
    @FXML
    public void onCalcularMouseClicked() {
        double valorCursoDouble = Double.parseDouble(FormatUtil.formatarVirgulas(creditosText.getText()));
        switch (cbCurso.getValue()) {
            case ADM:
                this.calcularCreditos(valorCursoDouble, adm);
                break;
            case TI:
                this.calcularCreditos(valorCursoDouble, ti);
                break;
            case PSICOLOGIA:
                this.calcularCreditos(valorCursoDouble, psicologia);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onLimparMouseClicked() {

        creditosText.clear();
        valorParcelasLabel.setText("");
        valorCreditoLabel.setText("");
        valorCursoLabel.setText("");
    }
}



