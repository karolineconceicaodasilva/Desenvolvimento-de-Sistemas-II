package Veiculos;

public class Carro {

    private String marca;
    private int cavalos; // privado
    protected String modelo; // public dentro de pacote
    private double kmPorLitros;

    @Override
    public String toString() {
        return "Carro [marca=" + marca + ", cavalos=" + cavalos + ", modelo=" + modelo + ", kmPorLitros=" + kmPorLitros
                + "]";
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getKmPorLitros() {
        return kmPorLitros;
    }

    public void setKmPorLitros(double kmPorLitros) {
        this.kmPorLitros = kmPorLitros;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCavalos() {
        return cavalos;
    }

    public void setCavalos(int cavalos) {
        this.cavalos = cavalos;
    }

    public void liga() {
        System.out.println("Liga...");
    }

    public void iniciar() {
        System.out.println("Solicitamos que inicie!");
    }

    public void parar() {
        System.out.println("Solicitação de parada!");
    }

    public void acelerar(int velocidade) {

        int limiteVelocidade = 80;

        if (velocidade > limiteVelocidade) {
            System.out.println("Preste atenção na multa! Diminua a velocidade o limite é de: " + limiteVelocidade);
        } else if (velocidade < limiteVelocidade) {
            System.out.println(
                    "Está dentro do limite de velocidade, não aumente ela, verifique se os pasageiros estão todos de cinto. O limite é de: "
                            + limiteVelocidade);
        } else {
            System.out
                    .println("Está dentro do limite da velocidade. Parabéns!");
        }
    }
}
