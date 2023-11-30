package com.example.primeiroappjavafx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaTeste extends Stage {

    public TelaTeste(){


        Button button = new Button();
        button.setText("OK");

        HBox caixa = new HBox();
        caixa.getChildren().add(button);



        Scene scene = new Scene(caixa, 100,100);
        setScene(scene);
        setTitle("Tela de teste");
        show();
    }
}
