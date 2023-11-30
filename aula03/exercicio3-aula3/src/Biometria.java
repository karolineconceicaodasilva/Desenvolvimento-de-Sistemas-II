public class Biometria implements Autenticador {

    public void autenticar() {
        System.out.println("Insira sua biometria para autenticar!");
        System.out.println("Aguarde o carregamento!");
        for (int i = 0; i < 10; i++) {
            System.out.println("carregando"+ ".".repeat(i));
        }
        System.out.println("Login com Biometria com sucesso!");
    }
}
