package exer_4;

import java.util.Scanner;

public class Trem implements Transporte {
    Scanner tecl = new Scanner(System.in);

    public void custoPorKM() {

        System.out.println("Trem:");
        System.out.println("Informe o valor que está o kwh da energia:");
        double valorKwEnergia = tecl.nextDouble();

        System.out.println("Informe a quantidade de km que o trem faz por kwh de energia:");
        double quantidadeKmTremFazPorKw = tecl.nextDouble();

        System.out.println("O valor do kwh é de energia: " + Utils.formatCurrency(valorKwEnergia));

        double valorPorKm = valorKwEnergia / quantidadeKmTremFazPorKw;
        System.out.println("E esse foi o valor por km: " + Utils.formatCurrency(valorPorKm));
        System.out.println();
    }
}
