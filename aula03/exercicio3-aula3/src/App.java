public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Esse será um sistema de autenticação!");
        System.out.println("A seguir insira as orientações pedidas a baixo.");
        Autenticador loginESenha = new LoginComSenha();
        SistemaDeLogin sistemaDelogin1 = new SistemaDeLogin();
        sistemaDelogin1.realizarLogin(loginESenha);

        System.out.println("Tente também por biometria...");

        Autenticador biometria = new Biometria();
        SistemaDeLogin biometria1 = new SistemaDeLogin();
        biometria1.realizarLogin(biometria);


    }
}
