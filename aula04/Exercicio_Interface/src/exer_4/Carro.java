package exer_4;


import java.util.Scanner;

public class Carro implements Transporte {

    Scanner tecl = new Scanner(System.in);

    public void custoPorKM() {
        System.out.println("Carro: ");
        System.out.println("Informe o valor que está a gasolina:");
        double valorPorLitroGasolina = tecl.nextDouble();
        
        System.out.println("Informe a quantidade de km que seu carro faz por litro de gasolina:");
        double quantidadeKmCarroFazPorLitro = tecl.nextDouble();

        System.out.println("O valor do litro da gasolina é de: " + Utils.formatCurrency(valorPorLitroGasolina));

        double valorPorKm = valorPorLitroGasolina / quantidadeKmCarroFazPorLitro;
        System.out.println("E esse foi o valor por km: " + Utils.formatCurrency(valorPorKm));
        System.out.println();
    
    }


}
