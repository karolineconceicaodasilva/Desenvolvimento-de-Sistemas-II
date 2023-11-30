package exer_2;

import java.util.Scanner;

public class Quadrado implements Figura {
    Scanner teclado = new Scanner(System.in);
    
    public void area(){
        System.out.println("Informe um valor da area para o quadrado: ");
        int valorArea = teclado.nextInt();
         System.out.println("Valor do area informado é: " + valorArea);
    }
    
    public void perimetro(){
        System.out.println("Informe um valor do perimetro para quadrado: ");
        int valorPerimetro = teclado.nextInt();
        System.out.println("Valor do perimetro informado é: " + valorPerimetro);
    }
}
