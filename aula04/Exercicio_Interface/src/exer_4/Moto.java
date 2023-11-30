package exer_4;

import java.util.Scanner;

public class Moto implements Transporte {

    Scanner tecl = new Scanner(System.in);

    public void custoPorKM() {
        System.out.println("Moto:");
        System.out.println("Informe o valor que está a gasolina:");
        double valorPorLitroGasolina = tecl.nextDouble();

        System.out.println("Informe a quantidade de km que sua moto faz por litro de gasolina:");
        double quantidadeKmMotoFazPorLitro = tecl.nextDouble();

        System.out.println("O valor do litro da gasolina é de: " + Utils.formatCurrency(valorPorLitroGasolina));

        double valorPorKm = valorPorLitroGasolina / quantidadeKmMotoFazPorLitro;
        System.out.println("E esse foi o valor por km: " + Utils.formatCurrency(valorPorKm));
        System.out.println();
    }

}
