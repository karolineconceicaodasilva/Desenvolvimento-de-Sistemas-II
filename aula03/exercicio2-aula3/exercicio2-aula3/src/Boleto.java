public class Boleto implements MetodoDePagamento{

    private String codigoBarras;
    private double valor;

    public void realizarPagamento(double valor) {
      System.out.println("Pagando o valor de: R$" + valor);
    }
    
}
