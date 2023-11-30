package com.example.apputeis.controller;

import com.example.apputeis.util.FormatUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.*;

public class ConversaoController extends BasicaController{

    private final String DOLAR = "Dolar";
    private final String EURO = "Euro";
    private final String LIBRA = "Libra";

    private final String DOLAR_MOEDA = "$ ";
    private final String EURO_MOEDA = "€ ";
    private final String LIBRA_MOEDA = "£ ";


    @FXML
    private Label resultLabel;

    @FXML
    private TextField realText;
    double dolar = 4.90;
    double euro = 5.33;
    double libra = 6.12;

    @FXML
    private ComboBox<String> cbCorversao;

    @FXML
    protected void onLimparMouseClicked() {
        resultLabel.setText("");
        realText.setText("");
    }

    @FXML
    public void onCoversaoMouseClicked() {
        List<String> opcoesList = Arrays.asList(DOLAR, EURO, LIBRA);
        ObservableList<String> opcoes = FXCollections.observableList(opcoesList);
        cbCorversao.setItems(opcoes);
    }

    private void calcularCoversao(double realValor, double moedaCoversao, String moeda) {
        double result = realValor * moedaCoversao;
        String resultString = moeda + FormatUtil.formatarDoubleDuasCasasDecimais(result);
        resultLabel.setText(resultString);
    }

    @FXML
    public void onCalcularMouseClicked() {
        double realValorDouble = Double.parseDouble(FormatUtil.formatarVirgulas(realText.getText()));

        switch (cbCorversao.getValue()) {
            case DOLAR:
                this.calcularCoversao(realValorDouble, dolar, DOLAR_MOEDA);
                break;
            case EURO:
                this.calcularCoversao(realValorDouble, euro, EURO_MOEDA);
                break;
            case LIBRA:
                this.calcularCoversao(realValorDouble, libra, LIBRA_MOEDA);
                break;
            default: break;
        }
    }
}
