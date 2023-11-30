package com.example.apputeis.controller;

import javafx.fxml.FXML;

public abstract class BasicaController {

    @FXML
    protected void onSairMouseClicked() {
        System.exit(0);
    }

    @FXML
    protected abstract void onLimparMouseClicked();
}
