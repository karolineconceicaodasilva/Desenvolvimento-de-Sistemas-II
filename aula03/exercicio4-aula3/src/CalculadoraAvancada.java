import java.util.Scanner;

public class CalculadoraAvancada implements Calculadora {

    public void calcularAdicao() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Informe um valor:");
        double valor1 = tec.nextDouble();

        System.out.println("Informe outro valor:");
        double valor2 = tec.nextDouble();

        double soma = valor1 + valor2;
        double raiz = Math.sqrt(soma);
       
        System.out.println("Essa foi a adição dos valores informado: " + valor1 + " + " + valor2 + " = " + soma);
        System.out.println("E como essa calculadora é avançada, ela fez a raiz quadrada da soma dos valores dados. Esse foi o resultado: " + raiz);
    }

    public void calcularSubtracao() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Informe um valor:");
        double valor1 = tec.nextDouble();

        System.out.println("Informe outro valor:");
        double valor2 = tec.nextDouble();

        double soma = valor1 - valor2;
        double raiz = Math.sqrt(soma);
        
        System.out.println("Essa foi a subtração dos valores informado: " + valor1 + " - " + valor2 + " = " + soma);
         System.out.println("E como essa calculadora é avançada, ela fez a raiz quadrada da soma dos valores dados. Esse foi o resultado: " + raiz);
    }

    public void calcularMultiplicacao() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Informe um valor:");
        double valor1 = tec.nextDouble();

        System.out.println("Informe outro valor:");
        double valor2 = tec.nextDouble();

        double soma = valor1 * valor2;
        double raiz = Math.sqrt(soma);
        
        System.out.println("Essa foi a multiplicação dos valores informado: " + valor1 + " x " + valor2 + " = " + soma);
         System.out.println("E como essa calculadora é avançada, ela fez a raiz quadrada da soma dos valores dados. Esse foi o resultado: " + raiz);

    }

    public void calcularDivisao(){
        Scanner tec = new Scanner(System.in);
        System.out.println("Informe um valor:");
        double valor1 = tec.nextDouble();
        
        System.out.println("Informe outro valor:");
        double valor2 = tec.nextDouble();

        double soma = valor1 / valor2;
        double raiz = Math.sqrt(soma);
        
        
        System.out.println("Essa foi a divisão dos valores informado: " + valor1 + " / " + valor2 + " = " + soma );
        System.out.println("E como essa calculadora é avançada, ela fez a raiz quadrada da soma dos valores dados. Esse foi o resultado: " + raiz);

    }

    public void calcularPotenciacao(){
        Scanner tec = new Scanner(System.in);
        System.out.println("Informe um valor:");
        double valor1 = tec.nextDouble();
        
        System.out.println("Informe outro valor:");
        double valor2 = tec.nextDouble();

        double soma = Math.pow(valor1, valor2);
        double raiz = Math.sqrt(soma);
         
        System.out.println("Essa foi a potenciação dos valores informado: " + soma );
        System.out.println("E como essa calculadora é avançada, ela fez a raiz quadrada da soma dos valores dados. Esse foi o resultado: " + raiz);
    }

}
