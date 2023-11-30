package Veiculos.Componentes;

public class Motor {
    
    private double cilindradas;

    public void ronca(){
        System.out.println("Vruuuuuuummm...");
    }

    public double getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(double cilindradas) {
        this.cilindradas = cilindradas;
    }

}
