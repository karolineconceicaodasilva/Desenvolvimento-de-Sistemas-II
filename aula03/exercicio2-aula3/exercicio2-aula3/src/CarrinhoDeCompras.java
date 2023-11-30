public class CarrinhoDeCompras {
    
    public void finalizarCompra(MetodoDePagamento metodoDePagamento, double valor){
        metodoDePagamento.realizarPagamento(valor);
    }

}
