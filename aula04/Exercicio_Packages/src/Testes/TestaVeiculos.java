package Testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utilidades.Util;
import Veiculos.Caminhao;
import Veiculos.Carro;
import Veiculos.Moto;

//import Veiculos.*;

public class TestaVeiculos {

    public static void main(String[] args) {

        // Scanner teclado = new Scanner(System.in);

        // System.out.println("Informe uma quantidade de nomes de carro que gostaria de
        // dar:");
        // int quantidade = teclado.nextInt();

        // List<String> carros = new ArrayList();

        // for (int i = 1; i <= quantidade; i++) {
        // Scanner tec = new Scanner(System.in);
        // System.out.println("Informe o " + i + "° nome do carro:");
        // String carro = tec.nextLine();
        // carros.add(carro);
        // }

        // System.out.println("Esses foram os nomes dos carros informados: " + carros);

        // Caminhao caminhao1 = new Caminhao();
        // caminhao1.iniciar();
        // caminhao1.parar();
        // caminhao1.acelerar(80);

        // Carro carro1 = new Carro();
        // carro1.setCavalos(80);
        // carro1.setModelo("Palio");
        // carro1.setMarca("Fiat");
        // double kmPorLitrosCarro = Util.eficienciaCombustivel(600, 60);
        // carro1.setKmPorLitros(kmPorLitrosCarro);
        // System.out.println(carro1.toString());

        Moto moto1 = new Moto();
        double kmPorLitrosMoto = Util.eficienciaCombustivel(1800, 60);
        moto1.setKmPorLitros(kmPorLitrosMoto);
        System.out.println(moto1.getKmPorLitros());
    }

}