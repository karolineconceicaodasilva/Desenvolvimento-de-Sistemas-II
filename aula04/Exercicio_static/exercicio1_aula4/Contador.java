public class Contador {

    public static int contador;

    public Contador() {
        incrementar();
    }

    public static void incrementar() {
        contador++;
    }

    public static void valorAtual() {
        System.out.println(contador);
    }
}
