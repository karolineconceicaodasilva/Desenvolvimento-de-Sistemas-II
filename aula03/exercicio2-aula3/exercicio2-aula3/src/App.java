public class App {
    public static void main(String[] args) throws Exception {

        MetodoDePagamento metodoBoleto = new Boleto();
        CarrinhoDeCompras carrinho1 = new CarrinhoDeCompras();
        carrinho1.finalizarCompra(metodoBoleto, 40.00);

        MetodoDePagamento metodoPix = new Pix();
        CarrinhoDeCompras carrinho2 = new CarrinhoDeCompras();
        carrinho2.finalizarCompra(metodoPix, 50.00);

    }
}