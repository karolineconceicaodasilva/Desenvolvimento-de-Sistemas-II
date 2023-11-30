package aula04.Exercicio_static.exercicio3_aula4;

import java.util.Scanner;

public class ConversorDeTemperatura {
 
  public static void coverter() {
    
    Scanner tec = new Scanner(System.in);

    System.out.println("Digite um valor para a converção:");
    int valor = tec.nextInt();

    System.out.println("Você gostaria de converter esse valor de CelsIus para Fahrenheit, ou de Fahrenheit para Celsius?");
    String escolha = tec.next();

    if(escolha.equalsIgnoreCase("Celsius")){
      double resultado = converterCelsius(valor);
      System.out.println(resultado);

    }else if(escolha.equalsIgnoreCase("Fahrenheit")){
      double resultado = converterFahre(valor);
      System.out.println(resultado);
    }else{
      System.out.println("Informação errada!");
    }

    tec.close();
}
  public static double converterCelsius(double celsius) {
    double resultado = (celsius -32 ) / 1.8;
    return resultado;
  }

  public static double converterFahre(double fahre) {
    double resultado =(fahre * 1.8) + 32; 
    return resultado;
  }

}

