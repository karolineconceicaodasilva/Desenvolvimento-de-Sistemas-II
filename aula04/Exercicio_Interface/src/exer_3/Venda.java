package exer_3;

public class Venda implements Pagavel{
    
    private double valorTotalVendas;

    public double getValorTotalVendas() {
        return valorTotalVendas;
    }

    public void setValorTotalVendas(double valorTotalVendas) {
        this.valorTotalVendas = valorTotalVendas;
    }

    public void totalPagar(){
        System.out.println("Valor total das suas vendas foram: R$" + valorTotalVendas);
    }

   
}
