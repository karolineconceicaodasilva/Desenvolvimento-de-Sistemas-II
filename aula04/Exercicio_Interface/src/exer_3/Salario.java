package exer_3;

public class Salario implements Pagavel{
    
    private double valor;

    public void totalPagar(){
        System.out.println("Total a pagar pelo seu salario é de: R$" + valor);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
