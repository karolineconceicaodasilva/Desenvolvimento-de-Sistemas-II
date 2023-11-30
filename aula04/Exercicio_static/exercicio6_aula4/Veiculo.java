package aula04.Exercicio_static.exercicio6_aula4;

public class Veiculo {

    private Veiculo(){}

    public static Veiculo criarCarro() {
        Veiculo carro = new Veiculo();
        System.out.println("Criando Carro Novo!");
        return carro;
    }

    public static Veiculo criarBisci() {
        Veiculo bisci = new Veiculo();
        System.out.println("Criando Biscicleta Nova!");
        return bisci;
    }
}
