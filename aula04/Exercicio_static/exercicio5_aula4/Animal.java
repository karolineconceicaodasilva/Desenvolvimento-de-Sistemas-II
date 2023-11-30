package aula04.Exercicio_static.exercicio5_aula4;

public class Animal {
    
    private static int contarInstancias = 0 ;
    
    public Animal() {
        contarInstancias++;
    }
   
    public static int getContarInstancias() {
        return contarInstancias;
    }
    public static void setContarInstancias(int contarInstancias) {
        Animal.contarInstancias = contarInstancias;
    }

     
}


