package exer_4;

import java.util.Scanner;

public class Onibus implements Transporte{
    
    Scanner tecl = new Scanner(System.in);

    public void custoPorKM() {
        System.out.println("Ônibus:");
        System.out.println("Informe o valor que está o diesel:");
        double valorPorLitroDiesel = tecl.nextDouble();
        
        System.out.println("Informe a quantidade de km que seu ônibus faz por litro de diesel:");
        double quantidadeKmOnibusFazPorLitro = tecl.nextDouble();

        System.out.println("O valor do litro do diesel é de: " + Utils.formatCurrency(valorPorLitroDiesel));

        double valorPorKm = valorPorLitroDiesel / quantidadeKmOnibusFazPorLitro;
        System.out.println("E esse foi o valor por km: " + Utils.formatCurrency(valorPorKm));
        System.out.println();
    }
}
