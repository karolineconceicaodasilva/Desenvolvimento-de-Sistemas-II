package com.example.apputeis.controller;

import com.example.apputeis.util.FormatUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ProdutoController extends BasicaController{

    @FXML
    private Label resultadoLabel;

    @FXML
    private TextField precoText;

    @FXML
    private TextField quantidadeText;

    @FXML
    protected void onCalcularMouseClicked() {
        double preco = Double.parseDouble(FormatUtil.formatarVirgulas(precoText.getText()));
        int quantidade = Integer.parseInt(FormatUtil.formatarVirgulas(quantidadeText.getText()));
        double total = preco * quantidade;
        resultadoLabel.setText("O resultado é: R$" + FormatUtil.formatarDoubleDuasCasasDecimais(total));
    }
    @FXML
    protected void onLimparMouseClicked() {
        quantidadeText.clear();
        precoText.setText("");
        resultadoLabel.setText("");
    }
}
