package exer_3;

public class Teste {
    public static void main(String[] args) {
        
        Fatura primeiraFatura = new Fatura();
        primeiraFatura.setValorDaFatura(500.00);
        primeiraFatura.totalPagar();

        Salario primeiroSalario = new Salario();
        primeiroSalario.setValor(800.00);
        primeiroSalario.totalPagar();

        Venda primeiraVenda = new Venda();
        primeiraVenda.setValorTotalVendas(250.00);
        primeiraVenda.totalPagar();
    }
}
