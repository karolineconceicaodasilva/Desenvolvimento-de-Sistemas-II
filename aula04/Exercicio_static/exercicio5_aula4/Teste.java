package aula04.Exercicio_static.exercicio5_aula4;

public class Teste {
    public static void main(String[] args) {
        
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        Animal animal4 = new Animal();


        System.out.println("Quantidade de instâncias de Animal: " + Animal.getContarInstancias());  
}
}