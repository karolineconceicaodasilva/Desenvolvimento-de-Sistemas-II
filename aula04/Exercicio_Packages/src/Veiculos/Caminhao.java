package Veiculos;

public class Caminhao {

    private boolean possuiCacamba;

    public boolean isPossuiCacamba() {
        return possuiCacamba;
    }

    public void setPossuiCacamba(boolean possuiCacamba) {
        this.possuiCacamba = possuiCacamba;
    }

    public void iniciar() {
        System.out.println("Solicitamos que inicie!");
    }

    public void parar() {
        System.out.println("Solicitação de parada!");
    }

    public void acelerar(int velocidade) {

        int limiteVelocidade = 60;

        if (velocidade > limiteVelocidade) {
            System.out.println("Preste atenção na multa! Diminua a velocidade o limite é de: " + limiteVelocidade);
        } else if (velocidade < limiteVelocidade) {
            System.out.println(
                    "Está dentro do limite de velocidade, não aumente ela. O limite é de: " + limiteVelocidade);
        } else {
            System.out
                    .println("Está dentro do limite da velocidade, se estiver levando carga continue assim. Parabéns!");
        }
    }
}
