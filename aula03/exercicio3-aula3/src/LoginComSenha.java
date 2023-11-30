import java.util.Scanner;

public class LoginComSenha implements Autenticador {

    public void autenticar() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite seu login: ");
        String login = tec.nextLine();
        System.out.println("Digite seu senha: ");
        String senha = tec.nextLine();

        if(login.equals("curso@gmail.com") && senha.equals("123@456"))
            System.out.println("Login com sucesso!");
        else
            System.out.println("Falha no Login!");
        
    }
}
