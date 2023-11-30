public class App {
    public static void main(String[] args) throws Exception {

        Calculadora adicao = new CalculadoraAvancada();
        adicao.calcularAdicao();

        Calculadora subtracao = new CalculadoraAvancada();
        subtracao.calcularSubtracao();

        Calculadora mult = new CalculadoraAvancada();
        mult.calcularMultiplicacao();

        Calculadora div = new CalculadoraAvancada();
        div.calcularDivisao();

        Calculadora poten = new CalculadoraAvancada();
        poten.calcularPotenciacao();
    }
}
