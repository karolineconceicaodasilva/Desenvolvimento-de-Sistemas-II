package aula04.Exercicio_static.exercicio2_aula4;

import java.util.Scanner;

public class Calculadora {

    public static void calcular() {

        Scanner tec = new Scanner(System.in);

        System.out.println("Digite um valor:");
        int valor1 = tec.nextInt();

        System.out.println("Digite outro valor:");
        int valor2 = tec.nextInt();

        System.out.println("Digite a operação:");
        System.out.println("Valores validos +, -, *, /");
        String operacao = tec.next();

        switch (operacao) {
            case "+":
                System.out.println(adicao(valor1, valor2));
                break;
            case "-":
                System.out.println(subtracao(valor1, valor2));
                break;
            case "*":
                System.out.println(multiplicacao(valor1, valor2));
                break;
            case "/":
                System.out.println(divisao(valor1, valor2));
                break;
            default:
                System.out.println("Operação invalida!");
                break;
        }

        tec.close();
    }

    public static int adicao(int valor1, int valor2) {
        return valor1 + valor2;
    }

    public static int subtracao(int valor1, int valor2) {
        return valor1 - valor2;
    }

    public static int multiplicacao(int valor1, int valor2) {
        return valor1 * valor2;

    }

    public static int divisao(int valor1, int valor2) {
        if (valor2 != 0)
            return valor1 / valor2;

        return 0;
    }

}
