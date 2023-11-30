package exer_3;

public class Fatura implements Pagavel{
    
    private double valorDaFatura;

    public void totalPagar(){
    System.out.println("Valor da sua fatura é de: R$" + valorDaFatura);
    }

    public double getValorDaFatura() {
        return valorDaFatura;
    }

    public void setValorDaFatura(double valorDaFatura) {
        this.valorDaFatura = valorDaFatura;
    }
}
